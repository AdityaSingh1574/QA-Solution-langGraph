# from manual_testing_extractor import task_cut_return_json, test
# from redirection_url_finder import redirection_url_finder
# from json_repair import repair_json
# import json
# from app import preprocessing
# from utils.xpath_generator import give_cache_file_name
from utils.llm_call import call_anthropic_model
from  prompts.initial_router import ROUTER_PROMPT
from json_repair import repair_json
import json
from utils.llm_call import call_anthropic_model
from user_stories import user_stories, dir_names
from app import generate_testcases_from_user_story_or_description

if __name__ == "__main__":
    

    # text = ""
    # for index, user_story in enumerate(user_stories):
    #     text + f"{dir_names[index]} \n {user_story}"
    #     text += "\n"
    
    # print(text)
        
    # with open("user_stories.txt", "w") as f:
    #     f.write(text)
    
    # if len(user_stories) == len(dir_names):
    #     print("true")
    
    
    
    for index, user_story in enumerate(user_stories):
        
        # prompt = f"""
        # Generate a folder name for the following user story, use the name of the website for the start, the actions for the middle and end
        
        # {user_story}
        
        # Use the following example to complete the task:
        
        # input user story: 
            
        # Background: User login at https://mymis.geminisolutions.com/Account/Login
        # User Types user id : 'webadmin'
        # User types password : 'Gemini@123' and logs in
        # redirect to : https://mymis.geminisolutions.com/
        # Scenario Outline : Test adding client 
        # user navigates to client management under ec-dc management
        # redirect to : https://mymis.geminisolutions.com/EcDcHierarchy/ManageClient
        # user adds the client and fills the information client name, address, city and country and adds it 

        # Output folder name:
        
        # `mis-add-client-ec-dc`
        
        # Important instructions
        # 1. Return only the file name nothing else 
        
        # """
        
        # print(
        #     call_anthropic_model(prompt=prompt)
        # )
        
        
        dir_name = dir_names[index]
        print(
            generate_testcases_from_user_story_or_description(user_story, "user story", dir_name)
        )
    
    
#     input_text = """
#     Background: User login at https://mymis.geminisolutions.com/Account/Login
#     User Types user id : 'webadmin'
#     User types password : 'Gemini@123' and logs in
#     redirect to : https://mymis.geminisolutions.com/
#     Scenario Outline : Test adding client 
#     user navigates to client management under ec-dc management
#     redirect to : https://mymis.geminisolutions.com/EcDcHierarchy/ManageClient
#     user adds the client and fills the information client name, address, city and country and adds it
#     """
    
    
#     llm_output = call_anthropic_model(
#         prompt=ROUTER_PROMPT.format(input_text=input_text)
#     )
    
    
#     json_extracted = repair_json(llm_output)
    
#     print(json.loads(json_extracted))
    
    # with open("input.txt", "r") as f:
    #     sachin_text = f.read()
    
    # llm_output = call_anthropic_model(pro mpt=sachin_text)
    
    
    # with open("sachin_test_output.txt", "w") as f:
    #     f.write(llm_output)
    
        
    # urls = ["https://athena-hartron-dev.geminisolutions.com/login", "https://athena-hartron-dev.geminisolutions.com/", "https://athena-hartron-dev.geminisolutions.com/athena/admin/tests/test-control"]
    
    
    # for url in urls:
    #     print(give_cache_file_name(url))
    #     print("----------------------")
    
    # PRE-PROCESSING STEP
    # td=""" 
    # Background: User login at https://mymis.geminisolutions.com/Account/Login
    # User Types user id : 'webadmin'
    # User types password : 'Gemini@123' and logs in
    # redirect to : https://mymis.geminisolutions.com/
    # Search Outline : User test export, copy and print button
    # When User click on export button
    # And User click on Copy option
    # And User click on Excel option
    # And User verifies if Excel "<filename>" got downloaded
    # And User click on Print button
    # And User verifies if Print"<filename>" works
    # Examples:
    # | filename          |
    # | Access Cards      |
    # """
    
    # xpaths, refined_user_story = preprocessing(td)
    
    # print("\nthe following are the xpaths: ")
    
    # print(xpaths)
    
    # print("\nthe following is the refined used story : \n")
    
    # print(refined_user_story)
    
    
    
    
    # 
    # task_cut_return_json()
    
    # json_sample = """
    # Here's a randomly generated sample JSON object that could represent a user profile in a simple system:
    # [
    #         {
    # "id": "A123",
    # "name": "John Doe",
    # "email": "johndoe@example.com",
    # "isActive": true,
    # "roles": ["user", "admin"],
    # "profile": {
    #     "age": 30,
    #     "gender": "male",
    #     "address": {
    #     "street": "123 Elm St",
    #     "city": "Springfield",
    #     "state": "IL",
    #     "zip": "62704"
    #     }
    # },
    # "registrationDate": "2022-01-15T14:35:00Z",
    # "lastLogin": "2024-09-30T09:25:00Z"
    #     },
    #     {
    # "id": "A123",
    # "name": "John Doe",
    # "email": "johndoe@example.com",
    # "isActive": true,
    # "roles": ["user", "admin"],
    # "profile": {
    #     "age": 30,
    #     "gender": "male",
    #     "address": {
    #     "street": "123323 python street",
    #     "city": "Springfield",
    #     "state": "IL",
    #     "zip": "1245"
    #     }
    # },
    # "registrationDate": "2022-10-15T14:35:00Z",
    # "lastLogin": "2024-10-30T09:25:00Z"
    #     }
    # ]

    # the above is a sample json
    # """
    
    # print(type(repair_json(json_sample)))