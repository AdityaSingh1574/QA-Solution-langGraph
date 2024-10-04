import random
import random
import json
import os
import json
from logger import logger
from langgraph.graph import END, MessageGraph,START
from IPython.display import Image, display
from langgraph.checkpoint.memory import MemorySaver
from utils.llm_call import call_anthropic_model
from json_repair import repair_json
import autogen
from autogen.coding import LocalCommandLineCodeExecutor
from utils.azure_summarizer import get_work_description
from utils.redirection_url_finder import redirection_url_finder
from utils.xpath_generator import get_raw_xpath_dictionary
from utils.xpath_segregation import xpath_segregator
from utils.general_utils import extract_text_between_markers
from configs.autogen_config import config_list
from json_repair import repair_json
from prompts.feature_file_generation import WORK_ITEM_TO_FF_AZURE_DESC, USER_STORY_CONVERSION_PROMPT
from prompts.helpers import GET_FILE_CODE_PROMPT
from prompts.testing_files_generation import LOCATOR_FILE_GEN_PROMPT, PYTHON_CODE_GEN_PROMPT
from prompts.translation import TRANSLATION_PROMPT_LOCATORS,TRANSLATION_PROMPT_STD_IMP

assistant = autogen.AssistantAgent(
    name="assistant",
    llm_config={
        "cache_seed": None,  # seed for caching and reproducibility
        "config_list": config_list,  # a list of OpenAI API configurations
        "temperature": 0.5,  # temperature for sampling
    },  # configuration for autogen's enhanced inference API which is compatible with OpenAI API
)

# create a UserProxyAgent instance named "user_proxy"
user_proxy = autogen.UserProxyAgent(
    name="user_proxy",
    human_input_mode="NEVER",
    max_consecutive_auto_reply=10,
    is_termination_msg=lambda x: x.get("content", "").rstrip().endswith("TERMINATE"),
    code_execution_config={
        # the executor to run the generated code
        "executor": LocalCommandLineCodeExecutor(work_dir="coding"),
    },
)



def get_user_story_from_description(epic_link):
    
    work_item_map, _ = get_work_description(epic_link)
    
    work_items_str = json.dumps(work_item_map, indent=4).replace('{', '{{').replace('}', '}}')

    logger.info("Descriptions and relations received from a")
    
    user_story_from_description = call_anthropic_model(
        prompt=WORK_ITEM_TO_FF_AZURE_DESC.format(work_items_str=work_items_str)
    )
    
    return user_story_from_description
    



def decide_entry_point(messages, config) -> str:

    entry_point = config["configurable"]['entry_point']
    logger.info(f"Start Node Decided : {entry_point}")

    return entry_point



def get_file_code_json(file_type, text):
        
    final_prompt = GET_FILE_CODE_PROMPT.format(file_type=file_type,text=text)
    
    
    llm_output = call_anthropic_model(
      prompt=final_prompt
    )
    logger.info("File content extracted from LLMs")
    
    final_json = json.loads(repair_json(llm_output))
    
    return final_json


def autogen_code_executor(messages,config):

    logger.info("Code Execution and auto correction started")
    
    if config['configurable']['entry_point'] == "step_imp":
        file_type = "Locator"
    else:
        file_type = "Step Definition and Implementation"
    
    instructions_to_autogen = messages[-1].content
    
    chat_res = user_proxy.initiate_chat(
    assistant,
    message=instructions_to_autogen,
    summary_method="reflection_with_llm",
    )
    
    logger.info("Completed code Generation in PYTHON")
    
    last_message_autogen = chat_res.chat_history[-1]['content']
    
    file_json = get_file_code_json(file_type, last_message_autogen)
    
    
    final_content = "Step-definition file"
    if config['configurable']['entry_point'] == "step_imp":
        if isinstance(file_json,dict):
            if 'step_definition' in file_json and 'implementation_file' in file_json:
                final_content = f"""
                ---STEP-DEFINITION-FILE-CODE----
                {file_json['step_definition']}
                ---STEP-DEFINITION-FILE-CODE----
                
                ---IMPLEMENTATION-FILE-CODE---
                {file_json['implementation_file']}
                ---IMPLEMENTATION-FILE-CODE---
                """
    else:
        final_content = f"""
        ---LOCATOR-FILE-CODE---
        {file_json['locator']}
        ---LOCATOR-FILE-CODE---
        """
    logger.info("Generated code ready for translation into JAVA")
    return {"role" : "ai" , "content" : final_content}
    

def locators_file_node(messages,config):
    
    xpath_string = config["configurable"]["x_path_string"]
    
    
    final_locator_prompt = LOCATOR_FILE_GEN_PROMPT.format(xpath_string=xpath_string)
    
    logger.info("Locator Node : Instructions Generated for code generation")
    
    return {"role" : "human" , "content" : final_locator_prompt}
def user_story_converter(messages, config):
    
    
    xpath_string = config["configurable"]["x_path_string"]
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
    
    
    
    final_prompt = PYTHON_CODE_GEN_PROMPT.format(feature_file_text=feature_file_text, xpath_string=xpath_string)

    logger.info("User Story to Feature File Node : Instructions ready for code Generation")
    return {"role" : "human", "content" : final_prompt}    
    

def code_translate_bro(messages_history, config):
    
    
    logger.info(f"Code translation started for : {config['configurable']['entry_point']}")
    
    

    python_code = messages_history[-1]
    
    final_prompt = TRANSLATION_PROMPT_LOCATORS.format(python_code=python_code)
    
    dir_path = config['configurable']['dir_path']
    
    if config['configurable']['entry_point'] == 'step_imp':
        with open(f"{dir_path}//feature_file.feature", 'r') as f:
            feature_file_text = f.read()
    
        with open(f"{dir_path}//Locators.java", 'r') as f:
            locator_file_text = f.read()

        final_prompt = TRANSLATION_PROMPT_STD_IMP.format(locator_file_text=locator_file_text, feature_file_text=feature_file_text)
    

    llm_output = call_anthropic_model(
        prompt=final_prompt
    )
    
    logger.info(f"Code Translation complete for : {config['configurable']['entry_point']}")
    
    java_code = llm_output
    
    dir_path = config['configurable']['dir_path'] 
    
    if config['configurable']['entry_point'] == "locator":
        extracted_code_locator = extract_text_between_markers(java_code, "---JAVA-CODE---", "---JAVA-CODE---") 
        with open(f"{dir_path}//Locators.java", "w") as f:
            f.write(extracted_code_locator)    
    else:    
        extracted_code_std = extract_text_between_markers(java_code, "---STEP-DEFINITION-FILE-START---", "---STEP-DEFINITION-FILE-END---")
        extracted_code_imp = extract_text_between_markers(java_code, "---IMPLEMENTATION-FILE-START---", "---IMPLEMENTATION-FILE-END---")

        
        with open(f"{dir_path}//StepDefinition.java", "w") as f:
            f.write(extracted_code_std)
        
        with open(f"{dir_path}//Implementation.java", "w") as f:
            f.write(extracted_code_imp)
    
    
    return {"role" : "ai", "content" : java_code}


def initialize_graph():
    
    # 2. Initialize the code interpreter tool
        
    logger.info("Initializing Graph...")
    memory = MemorySaver()

    workflow = MessageGraph()


    workflow.add_node("Locator_Node", locators_file_node)
    workflow.add_node("Step_Def_Imp_Node", user_story_converter)
    workflow.add_node("autogen_code_executor", autogen_code_executor)
    workflow.add_node("Code_Translator_Agent",code_translate_bro)

    workflow.add_conditional_edges(
        START,
        decide_entry_point,
        {"locator" : "Locator_Node", "step_imp" : "Step_Def_Imp_Node"}
    )

    workflow.add_edge("Step_Def_Imp_Node","autogen_code_executor")
    workflow.add_edge("Locator_Node", "autogen_code_executor")
    workflow.add_edge("autogen_code_executor", "Code_Translator_Agent")
    workflow.add_edge("Code_Translator_Agent", END)


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


if __name__ == "__main__":

    app = initialize_graph()
    
    user_story="""
User visits https://www.walmart.com/  and searches for "bag".
Redirected to: https://www.walmart.com/search?q=bag 
User selects the first bag and is redirected to:
https://www.walmart.com/ip/Daisy-Rose-Tote-Shoulder-Bag-and-Matching-Clutch-for-Women-PU-Vegan-Leather-Handbag-for-Travel-Work-and-School-Cream-Box/403008624?classType=VARIANT&adsRedirect=true 
User clicks "Add to Cart" and moves to the cart, redirected to:
https://www.walmart.com/pac?id=403008624&ip=49.98&qt=1&g=FC&oId=526D690D7EDD4C83B8DC7938D8E873D0&fahs=f&facp=f&faacc=f&fshs=f&fscp=f&fsacc=f&cat=5438&po=&csid=101015017 
User clicks "View Cart", redirected to:
https://www.walmart.com/cart 

"""
    epic_link = ""
    
    if epic_link:
        user_story = get_user_story_from_description(epic_link)
    
    
    xpath_string_list, refined_user_story_list = preprocessing(user_story)
    
    
    for index,xpath_string in enumerate(xpath_string_list):
        refined_user_story = refined_user_story_list[index]
        
        dir_name = "walmart"    
        dir_path = os.path.join("complete-flow-runs",f"{dir_name}_{index}")
        os.makedirs(dir_path, exist_ok=True)
        
        locator_code, step_def_imp_code = generate_test_cases(app,xpath_string,refined_user_story,dir_path)