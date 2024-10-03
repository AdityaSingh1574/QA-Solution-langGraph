import os
import json
import validators
from bs4 import BeautifulSoup
from selenium import webdriver
from colorama import Fore, Style
from collections import OrderedDict
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.firefox.options import Options
from webdriver_manager.firefox import GeckoDriverManager

import time
from selenium.webdriver.support import expected_conditions as EC

def open_url(url):
    html_doc = None

    # Use Selenium to load the page with JavaScript execution
    firefox_options = Options()
    # firefox_options.add_argument("--headless")
    service = FirefoxService(GeckoDriverManager().install())

    driver = webdriver.Firefox(service=service, options=firefox_options)

    # the below code allows the user to login with credentials
    
    driver.get(url)
    #  Inject a JavaScript alert to prompt the user for manual login
    # TODO : Fix this >> alert is not being displayed    
    
    driver.get(url)
    # time.sleep(10)
    
    
    driver.maximize_window()

    # Wait until the page is fully loaded
    WebDriverWait(driver, 60).until(
        lambda d: d.execute_script("return document.readyState") == "complete"
    )

    html_doc = driver.page_source
    driver.quit()
    print("HTML extracted successfully")
    return html_doc


def create_xpaths_from_page_source(html_doc):
    soup = BeautifulSoup(html_doc, "html.parser")

    # List of tags to parse
    tags = ["button", "span", "div", "input", "li", "label", "a"]
    high_priority_tags = ["button", "a"]

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
    key = None

    if element.string and str(element.string).strip():
        key = snake_case_convertor(element.string)
    elif element.get("aria-label"):
        key = snake_case_convertor(element.get("aria-label"))
    elif element.get("placeholder"):
        key = snake_case_convertor(element.get("placeholder"))

    if element.name == "a":
        key = key + "_link" if key else "delete_this_node_37" + str(index)
    else:
        key = key + "_" + element.name if key else "delete_this_node_37" + str(index)

    return key


def clean_generated_xpaths(xpath_dictionary):
    # Create a list of keys to delete
    keys_to_delete = [
        key for key in xpath_dictionary.keys() if key.startswith("delete_this_node_37")
    ]

    # Remove the keys from the dictionary
    for key in keys_to_delete:
        del xpath_dictionary[key]

    all_xpaths = [value for value in xpath_dictionary.values() if value]
    unique_xpaths = list(OrderedDict.fromkeys(all_xpaths))

    for xpath in unique_xpaths:
        index = 0
        for key, value in xpath_dictionary.items():
            if xpath == value and all_xpaths.count(xpath) > 1:
                index += 1
                xpath_dictionary[key] = f"({xpath})[{index}]"

    
    return xpath_dictionary


def snake_case_convertor(raw_string):
    if not isinstance(raw_string, str):
        raw_string = str(raw_string)

    words = "".join(
        char.lower()
        for char in raw_string.strip()
        if char.isalnum() or char == "_" or char == " "
    )

    return words.replace(" ", "_")

def get_raw_xpath_dictionary(url):

    html_doc = open_url(url)

    # Generate xpaths
    xpath_dictionary = create_xpaths_from_page_source(html_doc)

    # Clean and write the xpaths to a JSON file
    xpath_dict = clean_generated_xpaths(xpath_dictionary)
    
    with open("extracted_xpaths.json","w") as f:
        json.dump(xpath_dict, f, indent=4)
    
    return xpath_dict