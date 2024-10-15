import os
import re
import json
import time
import validators
import hashlib
from bs4 import BeautifulSoup
from selenium import webdriver
from collections import OrderedDict
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.firefox.options import Options
from webdriver_manager.firefox import GeckoDriverManager
from logger import logger
import time


def create_filename_from_hash(url):
    return hashlib.md5(url.encode('utf-8')).hexdigest() + '.json'
 


def login_user_applications(application_name):
    if application_name == "Gembook":
        pass
 
 
def create_filename_from_url(url):
    """This method creates a human readable name from the given URL."""
    file_name = re.sub(r"^https?://(www\.)?", "", url)
    file_name = re.sub(r"\.(com|in|io|org|net|gov|edu|uk|co\.\w+)(/|$)", "", file_name)
    file_name = re.sub(r'[\/\?%*:|"<>=]|&.*', "", file_name)
    return file_name + ".json"
 

 
def open_url(url, action_type):
    """This method launch the given URL in headless mode to fetch page object."""
    html_doc = None
    
    # TODO : if action_type == 'Login' then dont login else bypass login
 
    # Use Selenium to load the page with JavaScript execution
    firefox_options = Options()
    # firefox_options.add_argument("--headless")
    service = FirefoxService(GeckoDriverManager().install())
 
    driver = webdriver.Firefox(service=service, options=firefox_options)
 
    driver.get(url)

    time.sleep(30)
    
    logger.warning("WAITING FOR MANUAL LOGIN")
    
    driver.get(url)
    time.sleep(8)
    logger.info("Waiting for Page to Load completely")
    
    driver.maximize_window()
 
    # Wait until the page is fully loaded
    timer = 0
    message = False
    while not(message) and timer < 10:
        message = driver.execute_script("""
            document.addEventListener("DOMContentLoaded", function(e) {
            console.log("page has loaded");
            return "page has loaded";  // Return message
            });
            return document.readyState === 'complete'; // Check initial readyState
        """)
 
        time.sleep(2)
        timer += 1
 
    html_doc = driver.page_source
    logger.info("Source Code extracted successfully")
 
    driver.quit()
    return html_doc
 
 
def create_xpaths_from_page_source(html_doc):
    """This method identifies elements required for the xpath."""
    soup = BeautifulSoup(html_doc, "html.parser")
 
    # List of tags to parse
    tags = ["a", "button", "span", "div", "input", "li", "label", "textarea"]
    high_priority_tags = ["a", "button"]
 
    # Create an ordered dictionary to store xpaths
    xpath_dictionary = OrderedDict()
 
    for tag in tags:
        all_elements = soup.find_all(tag)
        index = 1
 
        for element in all_elements:
            # Create xpaths for high-priority tags
            if tag in high_priority_tags:
                xpath = select_xpath_attribute(element)
                if xpath:
                    element_name = key_name(element, index)
                    xpath_dictionary[element_name] = xpath
            else:
                ancestors = [ancestor.name for ancestor in element.find_parents()]
 
                if (
                    not any(parent in ancestors for parent in high_priority_tags)
                    and not element.find()
                ):
                    xpath = select_xpath_attribute(element)
                    if xpath:
                        node = key_name(element, index)
                        xpath_dictionary[node] = xpath
 
            index += 1
 
    return xpath_dictionary
 
 
def select_xpath_attribute(element):
    """This method selects attribute to make the xpath."""
    tag = element.name
 
    if element.get("id"):
        attr_value = element.get("id")
        xpath = f"//{tag}[@id='{attr_value}']"
    elif element.get("href"):
        attr_value = element.get("href")
        xpath = f"//{tag}[@href='{attr_value}']"
    elif element.get("src"):
        attr_value = element.get("src")
        xpath = f"//{tag}[@src='{attr_value}']"
    elif element.get("aria-label"):
        attr_value = element.get("aria-label")
        xpath = f"//{tag}[@aria-label='{attr_value}']"
    elif element.get("title"):
        attr_value = element.get("title")
        xpath = f"//{tag}[@title='{attr_value}']"
    elif element.string and str(element.string).strip():
        xpath = f"//{tag}[contains(text(), '{str(element.string).strip()}')]"
    elif element.get("name"):
        attr_value = element.get("name")
        xpath = f"//{tag}[@name='{attr_value}']"
    elif element.get("value"):
        attr_value = element.get("value")
        xpath = f"//{tag}[@value='{attr_value}']"
    elif element.get("class"):
        attr_value = " ".join(element.get("class"))
        xpath = f"//{tag}[@class='{attr_value}']"
    elif element.get("type"):
        attr_value = element.get("type")
        xpath = f"//{tag}[@type='{attr_value}']"
    else:
        xpath = None
 
    return xpath
 
 
def key_name(element, index):
    """This method creates names for the xpaths."""
    key = None
 
    if element.string and str(element.string).strip():
        key = snake_case_convertor(element.string)
    elif element.get("aria-label"):
        key = snake_case_convertor(element.get("aria-label"))
    elif element.get("placeholder"):
        key = snake_case_convertor(element.get("placeholder"))
    elif element.get("onclick"):
        key = snake_case_convertor(element.get("onclick"))
    elif element.get("formcontrolname"):
        key = snake_case_convertor(element.get("formcontrolname"))
 
    # Some elements will appear without any name. These elements are named using string
    # 'delete_this_node_37' so that these elements can be identified later and deleted.
    if element.name == "a":
        key = key + "_link" if key else "delete_this_element_37" + str(index)
    else:
        key = key + "_" + element.name if key else "delete_this_element_37" + str(index)
 
    return key
 
 
def clean_generated_xpaths(xpath_dictionary, user_input):
    """This method filters final keys and values that will be generated to the user."""
    # Create a list of keys to delete
    keys_to_delete = [
        key
        for key in xpath_dictionary.keys()
        if key.startswith("delete_this_element_37")
    ]
 
    # Remove the keys from the dictionary
    for key in keys_to_delete:
        del xpath_dictionary[key]
 
    current_folder = os.path.dirname(os.path.abspath(__file__))
    if validators.url(user_input):
        file_name = create_filename_from_url(user_input)
    else:
        file_name = create_filename_from_hash(user_input)
 
    locator_file = os.path.join(current_folder, file_name)
 
    all_xpaths = [value for value in xpath_dictionary.values() if value]
    unique_xpaths = list(OrderedDict.fromkeys(all_xpaths))
 
    for xpath in unique_xpaths:
        index = 0
        for key, value in xpath_dictionary.items():
            if xpath == value and all_xpaths.count(xpath) > 1:
                index += 1
                xpath_dictionary[key] = f"({xpath})[{index}]"
 
    return xpath_dictionary
 
    # Write xpaths to the file
    # with open(locator_file, "w", encoding="utf-8") as file:
    #     json.dump(xpath_dictionary, file, indent=4)
 
 
def snake_case_convertor(raw_string):
    """This method converts any string to snake case format"""
    if not isinstance(raw_string, str):
        raw_string = str(raw_string)
 
    words = "".join(
        char.lower()
        for char in raw_string.strip()
        if char.isalnum() or char == "_" or char == " "
    )
 
    return words.replace(" ", "_")
 
 
 
 
def get_raw_xpath_dictionary(url:str,action_type:str)->dict:
    filename = create_filename_from_url(url)
    cache_path = os.path.join('xpath_cache', filename)

    logger.info(f"cache file name : {filename}")
    
    # Check if cached data exists
    if os.path.exists(cache_path):
        logger.info(f"Loading cached data for {url}") 
        with open(cache_path, 'r') as file:
            return json.load(file)
    # If no cache, fetch and save the data
    logger.info(f"Fetching data for {url}")  
    
    is_url = validators.url(url)
    
    # validators checks for invalid URL
    if is_url:
        html_doc = open_url(url, action_type)
    else:
        html_doc = url
    
    data = create_xpaths_from_page_source(html_doc)
    data = clean_generated_xpaths(data, url)
    os.makedirs('xpath_cache', exist_ok=True)  
    with open(cache_path, 'w') as file:
        json.dump(data, file,indent=4)
    
    return data
 
 

#################################### Code execution starts here #############################

# if __name__ == "__main__":
#     url = input("Enter the URL: ").strip()
    
#     # If user enters an URL, then launch the URL in browser to fetch the DOM structure
#     # else pasre the DOM structure directly
    
#     is_url = validators.url(url)
    
#     # validators checks for invalid URL
#     if is_url:
#         html_doc = open_url(url)
#     else:
#         html_doc = url
    
#     # Generate xpaths
#     xpath_dictionary = create_xpaths_from_page_source(html_doc)
    
#     # Clean and write the xpaths to a JSON file
#     clean_generated_xpaths(xpath_dictionary)
#     print("Xpath file generated successfully.")