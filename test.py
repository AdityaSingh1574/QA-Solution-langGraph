# from manual_testing_extractor import task_cut_return_json, test
from redirection_url_finder import redirection_url_finder
from json_repair import repair_json
if __name__ == "__main__":
    
    # td="""  
    # Scenario Outline : User searches for "shoes", adds it to card and confirms
    # User is at https://www.myntra.com and searches for "shoes"
    # redirected to : https://www.myntra.com/shoes?rawQuery=shoes
    # User Selects the first shoe 
    # redirected : https://www.myntra.com/sports-shoes/red+tape/red-tape-men-drift-round-toe-mesh-walking-shoes/29869640/buy
    # User clicks on Add to cart and the moves to cart
    # redirected to : https://www.myntra.com/checkout/cart
    # User clicks on place order
    # """
    
    # redirection_url_finder(td)
    
    # task_cut_return_json()
    
    json_sample = """
    Here's a randomly generated sample JSON object that could represent a user profile in a simple system:
    [
            {
    "id": "A123",
    "name": "John Doe",
    "email": "johndoe@example.com",
    "isActive": true,
    "roles": ["user", "admin"],
    "profile": {
        "age": 30,
        "gender": "male",
        "address": {
        "street": "123 Elm St",
        "city": "Springfield",
        "state": "IL",
        "zip": "62704"
        }
    },
    "registrationDate": "2022-01-15T14:35:00Z",
    "lastLogin": "2024-09-30T09:25:00Z"
        },
        {
    "id": "A123",
    "name": "John Doe",
    "email": "johndoe@example.com",
    "isActive": true,
    "roles": ["user", "admin"],
    "profile": {
        "age": 30,
        "gender": "male",
        "address": {
        "street": "123323 python street",
        "city": "Springfield",
        "state": "IL",
        "zip": "1245"
        }
    },
    "registrationDate": "2022-10-15T14:35:00Z",
    "lastLogin": "2024-10-30T09:25:00Z"
        }
    ]

    the above is a sample json
    """
    
    print(type(repair_json(json_sample)))