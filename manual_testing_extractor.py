import requests
from bs4 import BeautifulSoup
from utils.llm_call import call_anthropic_model
import re
import json
from urllib.parse import urlparse
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time



def is_url(s):
    parsed = urlparse(s)
    # A basic criterion for a valid URL is that it should have a scheme and a netloc
    return bool(parsed.scheme) and bool(parsed.netloc)



def fetch_all_links_with_login_prompt(url):
    # Setup WebDriver
    driver = webdriver.Chrome()  # Ensure ChromeDriver is in your PATH
    
    driver.get(url)
    # Inject a JavaScript alert to prompt the user for manual login
    # TODO : Fix this >> alert is not being displayed    
    driver.execute_script("alert('Please log in within 20 seconds after closing this alert.');")
    # Wait for the user to close the alert
    WebDriverWait(driver, 15).until(EC.alert_is_present(), "Waiting for alert to be closed by the user.")
    alert = driver.switch_to.alert
    alert.accept()
    
    # Allow 20 seconds for the user to manually enter credentials and log in
    time.sleep(20)
    # Navigate to the target URL
    driver.get(url)
    time.sleep(30)  # Allow some time for the page to load fully

    # Dictionary to hold various elements and their URLs
    elements_urls = {}
    
    html_source = driver.page_source
     
    soup = BeautifulSoup(html_source, 'html.parser')
    anchors = soup.find_all('a')
    for index,anchor in enumerate(anchors):
        href = anchor.get('href')
        text = anchor.get_text(strip=True)
        if text and href:
            elements_urls[text] = href    
    
    # Extracting URLs from iframes
    iframes = soup.find_all('iframe')
    for index,iframe in enumerate(iframes):
        src = iframe.get('src')
        if src:
            elements_urls[iframe.get('name', 'Unnamed iframe')] = src

    # Extracting URLs from images that might be linked
    images = soup.find_all('img')
    for index,img in enumerate(images):
        src = img.get('src')
        if src:
            if is_url(src) or src.startswith('/'):
                elements_urls[f"{img.get('alt', 'Unnamed image')} Image"] = src

    # Extracting URLs from buttons that might act as links
    buttons = soup.find_all('button')
    for index,button in enumerate(buttons):
        onclick = button.get('onclick')
        if onclick:
            if is_url(onclick) or onclick.startswith('/'):
                button_text = button.get_text(strip=True) or 'Unnamed button'
                elements_urls[f"{button_text} button"] = onclick
    
    
    driver.quit()
    return elements_urls

VARIABLE_NAME_REPLACE_PROMPT = """
You will be given a base JSON which will contain vatiables enclosed between `<` and `>`, along with this you will be given a task description along with the table which contains the values of the variable.
Your task is to extend the JSON such that the variables are replaced values mentioned in the table of the initial description. Extend the JSON as a list of JSONs and return me the list of JSONs in which each JSON corresponds to the variable replaced with actual value for all the values in the table.

the Following is the task description given between `---DESCRIPTION-START---` and `---DESCRIPTION-END---`

---DESCRIPTION-START---
{task_description}
---DESCRIPTION-END---

the following is the JSON given between `---JSON-START---` and `---JSON-END---`

---JSON-START---
{json}
---JSON-END---

You must use the follow the below insctructions in order to complete the given task:
1. the task description must be ignored and the table containing the values must be considered
2. only the variables must be replaced with the values given in the table
3. If more than 1 JSON is being formed then return a list of JSONs containing variables replaced by values form tables

Important instructions
1. Return only the List of JSONs and nothing else
2. The list must contain the 
"""



# webpage vs action extractor
WEBPAGE_ACTION_EXTRACTOR_PROMPT="""
You will be given a set of instructions to visit a website and perform some actions, this may include different actions like clicking an element, searching for keyword, etc which may then invoke redirection from one webpage to another. 
Your task is to create a JSON with the name of the webpage against the action performed on the webpage which invokes redirection from the current webpage to another one.
the Following is the task description given between `---DESCRIPTION-START---` and `---DESCRIPTION-END---`

---DESCRIPTION-START---
{task_description}
---DESCRIPTION-END---

You can follow the below steps for completing the task:
1. First go through the task description and identify the actions through which the redirection from one page to another page is taking place.
2. Give the webpage key an intuitive name
3. Give the action an intuitive name which must also contain the name of the element on which the action was performed, the name of the element in which the action is performed must be highlighted by single quotes, if the name of the element was between `<` and `>` then enclose it between < and >
4. the webpage vs action must be in order with respect to the tasks mentioned in the task description

Important instructions:
1. The Key vs Value pairs must be in order with respect to the task description
2. Consider redirection from one webpage to another only if it is specifically mentioned.
3. Return only the JSON in response and nothing else.


You can use the following as an example which follows the above instructions as a reference.

Scenario outline : perform Add to cart action on https://sauce-demo.myshopify.com/
Given user is on the landing page of website https://sauce-demo.myshopify.com/

Input task description:

Scenario : Add to Cart the item <item-name>
User Clicks on the <item-name> on the landing page
User is redirected to product page
User clicks on "Add to Cart" for the product selected
User Clicks on the Cart icon on the page
User is redirected to a cart page 
User prints the name of the first item in the cart page
|item-name	|
|Noir jacket	|
|Grey jacket	|
	

Output JSON:

{{
  "Landing Page": "Click on '<item-name>'",
  "Product Page": "Click on 'Add to Cart'",
  "Cart Page": "Print first item name"
}}

"""


def extract_urls(text):
    # Regex pattern to find URLs that start with 'https://' or 'www'
    pattern = r'https?://\S+|www\.\S+'
    urls = re.findall(pattern, text)
    return urls



REDIRECT_URL_GETTER_PROMPT="""
You will be given a JSON conataining the names of the elements against URLs, pathhs or may be functions, these elements correspond to a webpage on which one out of these elements needs to be clicked for navigating to the next webpage after performing an action (which will also be given).
Your task will be to identify which action best matches the action specified to redirect from current webpage to next and return the URL corresponding to the action.

the action responsible for redirecting from one webpage to another is given between `---RESPONSIBLE-ACTION---` and `---RESPONSIBLE-ACTION---`

---RESPONSIBLE-ACTION---
{resp_action}
---RESPONSIBLE-ACTION---


The following is the element vs URL dictionary in which the action needs to be identified and URL needs to be returned, given between `---ELEMENT-URL-DICT---` and `---ELEMENT-URL-DICT---`

---ELEMENT-URL-DICT---
{element_url_dict}
---ELEMENT-URL-DICT---

To Complete the given task you must follow the below instructions:
1. Read the responsible action and identify if name of an element is assosiated with it, like a name of button, a link etc
2. Go through the dictionary and identify the one element name which best matches the name of the element identified in the previous step and get the corresponding URL, if you are not able to find the URL then extracted URL is None
3. If the end of the URL has an extentsion of an image or a file then ignore it.
4. Return the extracted URL as JSON with the following schema
    {{
        "redirect_url" : <extracted URL> 
    }}
5. Return only the JSON and nothing else.
"""


def get_redirect_url(web_page_url, action_on_webpage, base_url):
    
    element_url_json = fetch_all_links_with_login_prompt(web_page_url)
    
    element_url_json_str = json.dumps(element_url_json, indent=4).replace('{', '{{').replace('}', '}}')
    
    final_prompt = REDIRECT_URL_GETTER_PROMPT.format(element_url_dict=element_url_json_str, resp_action=action_on_webpage)
       
    redirect_url = call_anthropic_model(
        prompt=final_prompt
    )
    
    
    if redirect_url.startswith('/'):
        redirect_url = f"{base_url}/{redirect_url}"
        
    
    return redirect_url


# def test(): 
    
#     redirect_url = get_redirect_url("https://mymis.geminisolutions.com/","click on Refferal report","https://mymis.geminisolutions.com/")

#     print(redirect_url)
    
    # print(
    #     json.dumps(
    #         fetch_all_links_with_login_prompt("https://sauce-demo.myshopify.com/"),
    #         indent=4
    #     )
    # )
    
    
def test():
    
    task_desc = """"
    URL: https://mymis.geminisolutions.com/
    Scenario Outline:User Card Mapping :Mapped Cards : Export Options
    When user navigates on "Access Card Management" and then "User Card Mapping"
    When User click on export button
    And User click on Copy option
    And User click on Excel option
    And User verifies if Excel "<filename>" got downloaded
    And User click on Print button
    And User verifies if Print"<filename>" works
    Examples:
    | filename          |
    | confidential      |

    """
    
    print(task_cut_return_json(task_desc))

def task_cut_return_json(task_description):


    final_instructions = WEBPAGE_ACTION_EXTRACTOR_PROMPT.format(task_description=task_description)
    
    generated_JSON_str = call_anthropic_model(
        prompt=final_instructions
    )
    
    print(f"Base JSON : \n  {generated_JSON_str}")
    
    # the dictionaries will maintain the order as python version > 3.7
    base_json = json.loads(generated_JSON_str) 
    
    gen_json_str = generated_JSON_str.replace('{', '{{').replace('}', '}}')

    prompt_for_action = VARIABLE_NAME_REPLACE_PROMPT.format(task_description=task_description, json=gen_json_str)
    
    final_jsons_str = call_anthropic_model(
        prompt=prompt_for_action
    )

    print(f"JSON list with examples : {final_jsons_str}")
    # put this inside a function
    first_url = extract_urls(task_description)[0]
    
    print(f"URL extracted : {first_url}")
    
    url_json = {}
    
    for key,value in base_json.items():
        
        if first_url:
            url_json[key] = first_url
            first_url = None
        else:
            url_json[key] = None
            
            
    final_jsons = json.loads(final_jsons_str)

    print(
        json.dumps(final_jsons, indent=4)
    )
    
    web_page_list = list(url_json.keys())
    total_webpages_base = len(web_page_list)
    
    final_response = []
    
    for action_json in final_jsons: 
        url_json_cpy = url_json 
        for index, (web_page, action_element) in enumerate(action_json.items()):
            
            if index < total_webpages_base - 1:
            
                web_page_url = url_json_cpy[web_page]
                
                #  function which returns the url for the action_element for web_page    
                redirect_url_json = get_redirect_url(web_page_url, action_element, web_page_url)
                
                redirect_url_json = json.loads(redirect_url_json)
                
                next_web_page = web_page_list[index + 1]
                
                url_json_cpy[next_web_page] = redirect_url_json['redirect_url']
        
        final_response.append(url_json_cpy)
    
    
    with open("final_res.json", "w") as f:
        json.dump(final_response, f, indent=4)
    
    
    return final_response
            
        