import json
import os
from json_repair import repair_json
from langgraph.graph import END, MessageGraph,START
from langgraph.checkpoint.memory import MemorySaver
from logger import logger
from utils.llm_call import call_anthropic_model
from utils.azure_summarizer import get_work_description
from utils.jira_ticket_hierarchy import get_jira_description
from utils.redirection_url_finder import redirection_url_finder
from utils.xpath_generator import get_raw_xpath_dictionary
from utils.xpath_segregation import xpath_segregator
from utils.general_utils import extract_text_between_markers, prepare_reply
from prompts.feature_file_generation import WORK_ITEM_TO_FF_AZURE_JIRA_DESC, USER_STORY_CONVERSION_PROMPT
from prompts.testing_files_generation import LOCATOR_FILE_GEN_PROMPT
from prompts.code_generation import GENERATION_PROMPT_LOCATORS,GENERATION_PROMPT_STD_IMP
from prompts.initial_router import ROUTER_PROMPT


def get_user_story_from_description(description_link):
    if description_link:
        if "atlassian.net" in description_link:
            work_item_map = get_jira_description(description_link)
        else:
            work_item_map, _ = get_work_description(description_link)
    
    work_items_str = json.dumps(work_item_map, indent=4).replace('{', '{{').replace('}', '}}')

    logger.info("Descriptions and relations received from a")
    
    user_story_from_description = call_anthropic_model(
        prompt=WORK_ITEM_TO_FF_AZURE_JIRA_DESC.format(work_items_str=work_items_str)
    )
    
    return user_story_from_description
    



def decide_entry_point(messages, config) -> str:

    entry_point = config["configurable"]['entry_point']
    logger.info(f"Start Node Decided : {entry_point}")

    return entry_point


def locators_file_node(messages,config):
    
    xpath_string = config["configurable"]["x_path_string"]
    
    
    final_locator_prompt = LOCATOR_FILE_GEN_PROMPT.format(xpath_string=xpath_string)
    
    logger.info("Locator Node : Instructions Generated for code generation")
    
    return {"role" : "human" , "content" : final_locator_prompt}
def user_story_converter(messages, config):
    
    
    user_story = config["configurable"]["user_story_string"]
    
    final_prompt = USER_STORY_CONVERSION_PROMPT.format(user_story=user_story)
    
    llm_output = call_anthropic_model(
        prompt=final_prompt
    )
    
    
    feature_file_text = llm_output
    dir_path = config['configurable']['dir_path']
    logger.info("Feature file text generated and Saved in current directory")
    with open(f'{dir_path}//feature_file.feature', 'w') as f:
        f.write(feature_file_text)

    logger.info("User Story to Feature File Node : Files ready for code Generation")
    
    return {"role" : "human", "content" : "Feature file ready for step definition and implementation file"}    
    

def java_code_generator(messages_history, config):
    
    
    logger.info(f"Code Generation started for : {config['configurable']['entry_point']}")
    
    dir_path = config['configurable']['dir_path']
    
    if config['configurable']['entry_point'] == 'step_imp':
        with open(f"{dir_path}//feature_file.feature", 'r') as f:
            feature_file_text = f.read()
    
        with open(f"{dir_path}//Locators.java", 'r') as f:
            locator_file_text = f.read()

        final_prompt = GENERATION_PROMPT_STD_IMP.format(locator_file_text=locator_file_text, feature_file_text=feature_file_text)
    else: 
        xpath_string  = config['configurable']['x_path_string']    
        
        final_prompt = GENERATION_PROMPT_LOCATORS.format(xpath_string=xpath_string)
    

    llm_output = call_anthropic_model(
        prompt=final_prompt
    )
    
    logger.info(f"Code Generation complete for : {config['configurable']['entry_point']}")
    
    java_code = llm_output
    
    dir_path = config['configurable']['dir_path'] 
    
    if config['configurable']['entry_point'] == "locator":
        extracted_code_locator = extract_text_between_markers(java_code, "---JAVA-CODE---", "---JAVA-CODE---") 
        with open(f"{dir_path}//Locators.java", "w") as f:
            f.write(extracted_code_locator)    
        logger.info("Locators file generated and saved in directory")
    else:    
        extracted_code_std = extract_text_between_markers(java_code, "---STEP-DEFINITION-FILE-START---", "---STEP-DEFINITION-FILE-END---")
        extracted_code_imp = extract_text_between_markers(java_code, "---IMPLEMENTATION-FILE-START---", "---IMPLEMENTATION-FILE-END---")

        
        with open(f"{dir_path}//StepDefinition.java", "w") as f:
            f.write(extracted_code_std)
        logger.info("Step definition file generated and saved in directory")
        
        with open(f"{dir_path}//Implementation.java", "w") as f:
            f.write(extracted_code_imp)
        logger.info("Implementation file generated and saved in directory") 
    
    
    return {"role" : "ai", "content" : java_code}


def initialize_graph():
        
    logger.info("Initializing Graph...")
    memory = MemorySaver()

    workflow = MessageGraph()

    workflow.add_node("Locator_Node", locators_file_node)
    workflow.add_node("Step_Def_Imp_Node", user_story_converter)
    workflow.add_node("Code_Generator_Agent",java_code_generator)

    workflow.add_conditional_edges(
        START,
        decide_entry_point,
        {"locator" : "Locator_Node", "step_imp" : "Step_Def_Imp_Node"}
    )

    workflow.add_edge("Step_Def_Imp_Node","Code_Generator_Agent")
    workflow.add_edge("Locator_Node", "Code_Generator_Agent")
    workflow.add_edge("Code_Generator_Agent", END)

    app = workflow.compile(checkpointer=memory)
    
    logger.info("Graph initialized")
    
    return app


def generate_code_for_file(app,config):
    input = [("system", "you are a helpful assistant")]
    
    
    code = app.invoke(input=input, config=config)
    
    logger.info(f"Generated code for  : {config['configurable']['entry_point']}")
    
    return code[-1].content

def generate_test_cases(app,xpath_string, user_story,dir_path):
    # 4. Invoke the app

    locator_config = {"configurable": {"thread_id": "1", "entry_point" : "locator" , "x_path_string" : xpath_string, "dir_path" : dir_path}}
    step_def_imp_config =  {"configurable": {"thread_id": "2", "entry_point" : "step_imp", "x_path_string": xpath_string, "user_story_string" : user_story, "dir_path" : dir_path}}    
    
    locator_code = generate_code_for_file(app, locator_config)
    
    step_def_imp_code =  generate_code_for_file(app, step_def_imp_config)
    
    return locator_code , step_def_imp_code


def preprocessing(user_story):
       
    logger.info("pre-processing started")
    
    action_url_dict_list = redirection_url_finder(user_story)
    
    logger.info("Redirection URLs extracted from User Story")
    
    refined_user_story_list = []
    preprocessed_xpath_input_list = []
    
    for index,action_url_dict in enumerate(action_url_dict_list):
        refined_user_story = ""
        preprocessed_xpath_input = {}
        logger.info("Xpath extraction and segregation for User Story Data : {index}".format(index=index + 1))
        for action, value in action_url_dict.items():
            action_type = value["action_type"]
            url = value["url"]
            
            logger.info(f"Action Type : {action_type}")
            logger.info(f"Refined Action : {action}")
            logger.info(f"extracted URL : {url}")
            
            xpath_dict = get_raw_xpath_dictionary(url,action_type)
            seg_xpaths = xpath_segregator(action, xpath_dict)
            
            if action_type == "Login":
                refined_user_story += f"Backgroud : {action} \nredirect to : {url} \n"
            else:
                refined_user_story += f"{action} \nredirect to : {url} \n"
                            
            preprocessed_xpath_input.update(seg_xpaths)

        preprocessed_xpath_input_str = json.dumps(preprocessed_xpath_input).replace('{','{{').replace('}','}}')
        
        refined_user_story_list.append(refined_user_story)
        preprocessed_xpath_input_list.append(preprocessed_xpath_input_str)
        
                
    return preprocessed_xpath_input_list, refined_user_story_list



def classify_instructions(input_text):

    llm_output = call_anthropic_model(
        prompt=ROUTER_PROMPT.format(input_text=input_text)
    )
    
    classified_json = json.loads(repair_json(llm_output))
    
    return classified_json['classified_type'], classified_json['missing_params']



def generate_testcases_from_user_story_or_description(user_input, input_type, dir_name=None):
    
    app = initialize_graph()
    
    if input_type == "Epic Link":
        user_story = get_user_story_from_description(user_input)
    else:
        user_story = user_input
        
    classified_type, missing_params = classify_instructions(input_text=user_story)
    
    if classified_type != "sophisticated instructions":
         return prepare_reply(classified_type, missing_params)
    
    xpath_string_list, refined_user_story_list = preprocessing(user_story)
    
    
    for index,xpath_string in enumerate(xpath_string_list):
        refined_user_story = refined_user_story_list[index]
        
        # arguments to this function can have `dir_name`, different examples in the data table will be stored in <dir_name>_0,<dir_name>_1,<dir_name>_2 etc
        # hardcoded for now       
        dir_name = "mis-tm-sub-task-mgmnt-test-search"    
        dir_path = os.path.join("complete-flow-runs",f"{dir_name}_{index}")
        os.makedirs(dir_path, exist_ok=True)
        
        # can be used for showing this on frontend
        locator_code, step_def_imp_code = generate_test_cases(app,xpath_string,refined_user_story,dir_path)
    

    return "Successfully generated the test cases!"
    
if __name__ == "__main__":

    app = initialize_graph()
    
    
    user_story = """
    Background: User login at https://mymis.geminisolutions.com/Account/Login
    User Types user id : 'webadmin'
    User types password : 'Gemini@1234' and logs in
    redirect to : https://mymis.geminisolutions.com/
    Scenario Outline: Test for adding new asset type on Mymis
    User navigates to manage assets under Asset Allocation
    redirect to : https://mymis.geminisolutions.com/Asset/Manage⁠
    User clicks on Add new asset type
    User gives asset type as "testing123" and Selects yes for Is temporary option and adds it 

    """
    
      
    description_link = ""
    
    if description_link:
        user_story = get_user_story_from_description(description_link)
    
    
    xpath_string_list, refined_user_story_list = preprocessing(user_story)
    
    
    for index,xpath_string in enumerate(xpath_string_list):
        refined_user_story = refined_user_story_list[index]
        
        dir_name = "new-mis -add-new-asset"    
        dir_path = os.path.join("complete-flow-runs",f"{dir_name}_{index}")
        os.makedirs(dir_path, exist_ok=True)
        
        locator_code, step_def_imp_code = generate_test_cases(app,xpath_string,refined_user_story,dir_path)