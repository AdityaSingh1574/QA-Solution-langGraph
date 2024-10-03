# from manual_testing_extractor import task_cut_return_json, test
# from redirection_url_finder import redirection_url_finder
# from json_repair import repair_json
import json
from app import preprocessing
if __name__ == "__main__":
    
    td=""" 
    Background: User login at https://mymis.geminisolutions.com/Account/Login
    User Types user id : 'webadmin'
    User types password : 'Gemini@123' and logs in
    redirect to : https://mymis.geminisolutions.com/
    Search Outline : User test export, copy and print button
    When User click on export button
    And User click on Copy option
    And User click on Excel option
    And User verifies if Excel "<filename>" got downloaded
    And User click on Print button
    And User verifies if Print"<filename>" works
    Examples:
    | filename          |
    | Access Cards      |
    """
    
    xpaths, refined_user_story = preprocessing(td)
    
    print("\nthe following are the xpaths: ")
    
    print(xpaths)
    
    print("\nthe following is the refined used story : \n")
    
    print(refined_user_story)
    
    
    
    
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