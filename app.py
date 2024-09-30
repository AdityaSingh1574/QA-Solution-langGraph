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
from azure_summarizer import get_work_description

config_list = [ {
        "model": "claude-3-5-sonnet",
        "base_url": "http://localhost:4000",  #litellm compatible endpoint
        "api_type": "open_ai",
        "api_key": "NULL", # just a placeholder
        "price" : [0,0]
    }]


cahce_seed = random.randint(1,10000)
assistant = autogen.AssistantAgent(
    name="assistant",
    llm_config={
        "cache_seed": cahce_seed,  # seed for caching and reproducibility
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
    
    WORK_ITEM_TO_FF = f"""
    

    Given detailed descriptions of web development tasks, convert each description into a scenario outline for testing the user interactions on the specified website. Follow these guidelines:

    The detailed description is given between `---DESCRIPTION-START---` and `---DESCRIPTION-END---`

    ---DESCRIPTION-START---
     {work_items_str}
    ---DESCRIPTION-END---

    
    1. Identify the Website URL: Extract and highlight the website URL if mentioned, and use it as the base context for all scenarios.
    2. Identify the overall action that has to be completed using the description1
    2. Outline the User Journey: The descriptions must be consolidated into one summary containing all the necessary steps that need to be followed to complete the overall task that has to be completed, the steps must be neither too less nor too more.
    3. Specify Actual Names and Identifiers:
    - Clearly name any buttons, links, or placeholders mentioned in the description. Use quotes to denote the exact labels or text on these UI elements.
    - If specific items are to be interacted with (like 'Noir Jacket' or 'Grey Jacket'), use these exact names in the scenario outline.
    4. Include Examples for Multiple Cases: If the task involves multiple items or variations, include a table of examples at the end of the scenario. Each row should represent a different case, clearly listing any relevant specifics like item names.
    5. Return only the summarization with the tasks, ignore adding anything additional like additional checks, etc 
    
    **Example Input**:
    "Implement and test the user interaction on the landing page of https://sauce-demo.myshopify.com/ to ensure that when a user clicks on an item name (e.g., Noir Jacket, Grey Jacket), they are redirected to the respective product page. This involves adjusting the UI to make item names clickable and ensuring that the redirect functionality is correctly set up. Acceptance Criteria: Clicking on an item name on the landing page redirects to the product page. Ensure compatibility with major browsers (Chrome, Firefox, Safari). UI elements should be accessible and responsive."

    **Example Output**:
    Scenario outline: Perform item selection on https://sauce-demo.myshopify.com/
    Given user is on the landing page of website https://sauce-demo.myshopify.com/
    When user clicks on the <item-name> on the landing page
    Then user is redirected to the product page
    And ensure the page is compatible with major browsers like Chrome, Firefox, Safari
    And UI elements are accessible and responsive
    Examples:
    | item-name   |
    | Noir Jacket |
    | Grey Jacket |

    Apply these steps to convert detailed task descriptions into concise, structured scenario outlines for testing.
    """
    user_story_from_description = call_anthropic_model(
        prompt=WORK_ITEM_TO_FF
    )
    
    return user_story_from_description
    



def decide_entry_point(messages, config) -> str:

    entry_point = config["configurable"]['entry_point']
    logger.info(f"Start Node Decided : {entry_point}")

    return entry_point



def get_file_names_json(file_type, text):
    
    
    
    GET_FILE_NAME_PROMPT = """
    The text contains information about a {file_type} files to be saved
    The text is given between `---FILE-SAVER-TEXT---` and `---FILE-SAVER-TEXT---`
    ---FILE-SAVER-TEXT---
    {text}
    ---FILE-SAVER-TEXT---
    
    Your task is to extract the python code present in the text and return it as JSON in the following format:
    There can only be 2 types of text which can be present in the context which is either code for locators file or code for step-definition and implementation file
    {{
      'locator' : <python code of the locator file extracted>  
    }}
    If the file type is step-definition and implementation then return an output something like this
    {{
      'step_definition' : <python code of the step-definition file extracted>, 
      'implementation_file' : <python code of the implementation file extracted> 
    }}
    
    Important Instructions:
    1. Return only the JSON containing the codes of the file and nothing else
    """
    
    final_prompt = GET_FILE_NAME_PROMPT.format(file_type=file_type,text=text)
    
    
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
    
    file_json = get_file_names_json(file_type, last_message_autogen)
    
    
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
    
    LOCATOR_FILE_GEN_PROMPT=  """
        The following is a JSON between `---XPATH-START---` and `---XPATH-END---` which contains Xpaths for elements in a website
        ---XPATH-START---
        {xpath_string}
        ---XPATH-END---
        
        Assuming the above given xpaths are accurate and your task is to generate a simple locator file for the above given xpaths

        Important instructions
        1. Just generate the locator file and nothing else, there is no need for verification using python script
        2. Ensure all relevant import statements are present in the code
    """
    
    final_locator_prompt = LOCATOR_FILE_GEN_PROMPT.format(xpath_string=xpath_string)
    
    logger.info("Locator Node : Instructions Generated for code generation")
    
    return {"role" : "human" , "content" : final_locator_prompt}
def user_story_converter(messages, config):
    
    
    xpath_string = config["configurable"]["x_path_string"]
    user_story = config["configurable"]["user_story_string"]
    
    
    
    USER_STORY_CONVERSION_PROMPT="""
    Your task is to create a gherkin syntax which includes all the scenarios possible for the given feature.Consider the given below notes for the task.
    1. go through the given text between the separators `---USER-STORY-START---` and `---USER-STORY-END---`
    2. the placeholders are given between < and > and need to be filled with the values given in the  `Examples` section    
    3. the `Examples` section contains the values to be filled in the placeholders
    4. fill the values in the placeholders for each value given in the  `Examples` section
    5. generate a gherkin syntax for each example 

    The following is the user-story:
    ---USER-STORY-START---
    {user_story}
    ---USER-STORY-END---

    Important instructions
    1. Do not return anything other than the gherkin syntax

    the following is an example of how this can be done 

    Sample Input:
    URL: https://www.amazon.in/ 

    Feature: Add Books in the cart from Amazon

    Scenario Outline: Search <SearchOption> From Amazon website
    Given user Search <SearchOption> in the Search Box
    And user add First <SearchOption> in the cart
    When user add item to the cart
    Examples:
    | SearchOption |
    | Book         |
    | Shoes        |

    The output for the above will be as follows:

    Feature: Add Items to Cart on https://www.amazon.in
    As a user, I want to search for various items on Amazon and add them to my cart

    Scenario: Search and Add Book to Cart
        Given user is on the Amazon homepage
        When user searches for 'Book' in the search box
        And user selects the first 'Book' from the search results
        And user clicks on 'Add to Cart' button
        Then the 'Book' should be added to the user's cart
        And the cart count should increase by 1

    Scenario: Search and Add Shoes to Cart
        Given user is on the Amazon homepage
        When user searches for 'Shoes' in the search box
        And user selects the first 'Shoes' from the search results
        And user selects the desired size and color
        And user clicks on 'Add to Cart' button
        Then the 'Shoes' should be added to the user's cart
        And the cart count should increase by 1

    """

    final_prompt = USER_STORY_CONVERSION_PROMPT.format(user_story=user_story)
    
    
    llm_output = call_anthropic_model(
        prompt=final_prompt
    )
    
    
    feature_file_text = llm_output
    
    logger.info("Feature file text generated and Saved in current directory")
    with open('feature_file.feature', 'w') as f:
        f.write(feature_file_text)
    
    PYTHON_CODE_GEN_PROMPT = """
    ---FEATURE-FILE-START---
    {feature_file_text}

    ---FEATURE-FILE-END---

    the feature file is given between `---FEATURE-FILE-START---` and `---FEATURE-FILE-END---`
    Your task will be to implement the step definition file using the above given feature file text in PYTHON

    You can use the following instructions for generating step definition and implementation files
    1. Go through and understand the text of the feature file to comprehend the steps that need to be implemented.
    2. Step definition file will contain the Python code that defines the steps for the feature file text 
    3. the implementation file will contain the actual implementation of the test case / feature file containing the imports from step definition file.
    4. Divide feature file big task into small steps / tasks and implement the functions for getting the steps done
    5. Implement all the functions in the implementation and step definition files for completing the task
    
    use the following as locators as Xpaths for implementing the step definition file for accessing the element 
    The Xpaths are given between `---XPATH-START---` and `---XPATH-END---`

    ---XPATH-START---
    {xpath_string}
    ---XPATH-END---

    Important instructions:
    1. Save the code for the implementation and step definition files using a simple python script, do not use terminal for writing in files.
    2. The Xpaths given are accurate hence do not generate on your own
    3. Do not use chromedriver.exe for accessing the browser instead use WebDriverManager library for the same. 
    4. Include waiting time if the code needs to redirect to some other page and a wait time is required for successful code execution
    """
    
    final_prompt = PYTHON_CODE_GEN_PROMPT.format(feature_file_text=feature_file_text, xpath_string=xpath_string)

    logger.info("User Story to Feature File Node : Instructions ready for code Generation")
    return {"role" : "human", "content" : final_prompt}    
    

def code_translate_bro(messages_history, config):
    
    
    logger.info(f"Code translation started for : {config['configurable']['entry_point']}")
    
    TRANSLATION_PROMPT = """Translate the following code between `---PYTHON-CODE-START---` and `---PYTHON-CODE-END---` from PYTHON to JAVA
    ---PYTHON-CODE-START---
    {python_code}
    ---PYTHON-CODE-END---
    Return only the JAVA code between separators `---JAVA-CODE---` and `---JAVA-CODE---`
    Important instructions
    1. Do not return anything other than the JAVA code with the separators
    """

    python_code = messages_history[-1]
    
    final_prompt = TRANSLATION_PROMPT.format(python_code=python_code)
    
    if config['configurable']['entry_point'] == 'step_imp':
        with open("feature_file.feature", 'r') as f:
            feature_file_text = f.read()
    
        with open("Locators.java", 'r') as f:
            locator_file_text = f.read()
    
        
        
        TRANSLATION_PROMPT = """
        ---FEATURE-FILE-START---
        {feature_file_text}
        ---FEATURE-FILE-END---

        the feature file is given between `---FEATURE-FILE-START---` and `---FEATURE-FILE-END---`
        Your task will be to implement the step definition file using the above given feature file text in JAVA

        You can use the following instructions for generating step definition and implementation files
        1. Go through and understand the text of the feature file to comprehend the steps that need to be implemented.
        2. Step definition file will contain the Python code that defines the steps for the feature file text 
        3. the implementation file will contain the actual implementation of the test case / feature file containing the imports from step definition file.
        4. Divide feature file big task into small steps / tasks and implement the functions for getting the steps done
        5. Implement all the functions in the implementation and step definition files for completing the task

        use the following locator files text  for implementing the step definition file for accessing the element 
        The Xpaths are given between `---LOCATOR-FILE-START---` and `---LOCATOR-FILE-END---`

        ---LOCATOR-FILE-START---
        {locator_file_text}
        ---LOCATOR-FILE-END---

y
        The following can be used as an example for a step definition file
        package stepdefinitions;
        import implementation.Implementation;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.When;
        import io.cucumber.java.en.Then;

        public class StepDefinition {{
            public Implementation implementation = new Implementation();

            @Given("the user is on the home page")
            public void launchUrl(){{
                implementation.launchUrl(url);
            }}

            @When("the user clicks on login button")
                public void userClicksOnLoginButton() {{
                    implementation.clickOnLoginButton();
            }}

            @Then("username and password fields should appear")
                public void verifyLoginWindowAppears() {{
                    implementation.verifyLoginElements();
            }}

            @Then("close the browser")
            public void closeBrowser(){{
                implementation.closeBrowser();
            }}
        }}

        Important instructions:
        1. Save the code for the implementation and step definition files using a simple python script, do not use terminal for writing in files.
        2. The Xpaths given are accurate hence do not generate on your own
        3. Do not use chromedriver.exe for accessing the browser instead use WebDriverManager library for the same. 
        4. Include waiting time if the code needs to redirect to some other page and a wait time is required for successful code execution
        5. Ensure the step definition file contains launchUrl and closeBrowser methods.
        6. Keep the JAVA code for implementation file between separators `---IMPLEMENTATION-FILE-START---` and `---IMPLEMENTATION-FILE-END---`
        7. Keep the JAVA code for step-definition file between separators `---STEP-DEFINITION-FILE-START---` and `---STEP-DEFINITION-FILE-END---`
        8. Return only the JAVA code with the separators and nothing else.
        9. include the package lines: package stepdefinitions and package implementations in relevant file codes
        10. The class names have to be strictly the names : StepDefinition and Implementation in relevant file codes
        """
        final_prompt = TRANSLATION_PROMPT.format(locator_file_text=locator_file_text, feature_file_text=feature_file_text)
    
    
    
    
    llm_output = call_anthropic_model(
        prompt=final_prompt
    )
    
    logger.info(f"Code Translation complete for : {config['configurable']['entry_point']}")
    
    java_code = llm_output
    
    
    if config['configurable']['entry_point'] == "locator":
        extracted_code_locator = extract_text_between_markers(java_code, "---JAVA-CODE---", "---JAVA-CODE---") 
        with open("Locators.java", "w") as f:
            f.write(extracted_code_locator)    
    else:    
        extracted_code_std = extract_text_between_markers(java_code, "---STEP-DEFINITION-FILE-START---", "---STEP-DEFINITION-FILE-END---")
        extracted_code_imp = extract_text_between_markers(java_code, "---IMPLEMENTATION-FILE-START---", "---IMPLEMENTATION-FILE-END---")

        
        with open("StepDefinition.java", "w") as f:
            f.write(extracted_code_std)
        
        with open("Implementation.java", "w") as f:
            f.write(extracted_code_imp)
    
    
    return {"role" : "ai", "content" : java_code}





def display_graph(app):
        
    try:
        display(Image(app.get_graph().draw_mermaid_png()))
    except Exception:
        # This requires some extra dependencies and is optional
        pass
    
    


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

def generate_test_cases(app,xpath_string, user_story):
    # 4. Invoke the app

    locator_config = {"configurable": {"thread_id": "1", "entry_point" : "locator" , "x_path_string" : xpath_string} }
    step_def_imp_config =  {"configurable": {"thread_id": "2", "entry_point" : "step_imp", "x_path_string": xpath_string, "user_story_string" : user_story}}
    
    
    locator_code = generate_code_for_file(app, locator_config)
    
    step_def_imp_code =  generate_code_for_file(app, step_def_imp_config)
    
    return locator_code , step_def_imp_code




def extract_text_between_markers(input_text, start_marker, end_marker):

    # Finding the start and end indices of the markers
    start_index = input_text.find(start_marker) + len(start_marker)
    end_index = input_text.find(end_marker, start_index)

    # If either marker is not found, return an empty string
    if start_index == -1 or end_index == -1:
        return ""

    # Extracting the text between the markers
    return input_text[start_index:end_index].strip()



if __name__ == "__main__":

    app = initialize_graph()

    xpath_string = """
    {
    "user name input"  : "/html/body/div[1]/div[1]/div/form/div[3]/input",
    "password input" : "/html/body/div[1]/div[1]/div/form/div[4]/input",
    "sign in button" : "/html/body/div[1]/div[1]/div/form/div[5]/div[2]/input",
    "Access card management dropdown" : "/html/body/nav/div/div[1]/ul/li[14]/span",
    "User card Management" : "/html/body/nav/div/div[1]/ul/li[14]/ul/li[2]/a",
    "entry selection drop down" : "/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[1]/label/select",
    "selected entry 25 option" : "/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[1]/label/select/option[2]",
    "next button" : "/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[5]/ul/li[9]/a",
    "previous button" : "/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[5]/ul/li[1]/a"
    }
    """
    
    user_story = """
    Scenario Out
line: Manage Access Card : Verify paging functionality
    When user navigates on "Access Card Management" and then "Manage Access Card"
    And Verify Entries  changes to "<noOfRecords>" number of entries by selecting "<noOfRecords>" from the dropdown 
    And Verify Next "Next" Button works
    And Verify Previous "Previous" works
    Examples:
      | noOfRecords |
      | 25          |
    """
    
    epic_link = ""
    
    if epic_link:
        user_story = get_user_story_from_description(epic_link)
    
    
    print(user_story)
    
    
    locator_text, step_def_text = generate_test_cases(app,xpath_string,user_story)
    
   
    