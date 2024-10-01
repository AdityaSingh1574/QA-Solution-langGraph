from utils.llm_call import call_anthropic_model,call_aws_bedrock_llm
from json_repair import repair_json
import json
import os
import time
# TODO: need to test llama-3-170b for this task



ACTION_REDIRECTION_LINK = """
You will be given a set of instructions as an input, these are the instructions directing to perform an action on a website, the instructions follow a pattern of performing action on webpage and then getting redirected to another page after performing a certain action on the webpage, along with this the instructions shall also contain the url of the landing page and urls of the all the pages to which we are redirected to.

Your task is to identify and segregate the actions performed on webpage and the URL responsible for redirecting from that webpage to another, return the 
extracted action against URL AS JSON, with action performed against URL of the webpage.


The followings is the task description given between separators `---TASK-DESCRIPTION---` and `---TASK-DESCRIPTION---`
---TASK-DESCRIPTION---
{task_description}
---TASK-DESCRIPTION---

You need to follow the below instructions for completing the task:
1. First go through the task description and understand where all redirection is taking place, in the task description it is specifically mentioned when and where the redirection is taking place.
2. Identify the actions taking on different webpages, you can segregate the actions taking place on different webpages by keeping a note of actions taking place before every redirection
3. While specifying the actions precisely include the action (eg- clicked, typed etc) and the name of the element in which action is performed (eg- button name, search bar name etc).
5. The keywords mentioned in between the brackets < and > are variables keep them as it is while specifying in actions. 
6. Once the actions and the URLs are identified, then arrange the webpage actions against the URLs for that webpage

Important Instructions:
1. The actions must be mapped to the webpage URL on which the actions are taking place
2. Return only JSON and nothing else, the json will have the following format
{{
    <webpage-actions-1> : <URL-of-webpage-1>,
    <webpage-actions-2> : <URL-of-webpage-2>
}}   

You can use the following example for understanding the same:

input task description:

Scenario Outline: Testing Manage Access Card at Search functionality at https://mymis.geminisolutions.com
When user navigates on "Access Card Management" and then "Manage Access Card"
User gets redirected to "Manage Access Card" page at https://mymis.geminisolutions.com/AccessCard/Manage
And searching a "<Card Number>"card by typing "<Card Number>" in the search input
Then Verify search function is "<Card Number>" working
Examples:
| Card Number |
| 125552356   |


The JSON output to be returned will be
{{
    "Navigation to `Access Card Management` and then click `Manage access card`" : "https://mymis.geminisolutions.com"
    "search by Typing `<Card Number>` as search input" : "https://mymis.geminisolutions.com/AccessCard/Manage"
}}
"""


VARIABLE_NAME_REPLACE_PROMPT = """
You will be given a base JSON which will contain variables enclosed between `<` and `>`, along with this you will be given a task description along with the table which contains the values of the variable.
Your task is to extend the JSON such that the variables are replaced values mentioned in the table of the initial description. Extend the JSON as a list of JSONs and return me the list of JSONs in which each JSON corresponds to the variable replaced with actual value for all the values in the table.

the Following is the task description given between `---DESCRIPTION-START---` and `---DESCRIPTION-END---`

---DESCRIPTION-START---
{task_description}
---DESCRIPTION-END---

the following is the JSON given between `---JSON-START---` and `---JSON-END---`

---JSON-START---
{json}
---JSON-END---

You must use the follow the below instructions in order to complete the given task:
1. the task description must be ignored and the table containing the values must be considered
2. only the variables must be replaced with the values given in the table
3. If more than 1 JSON is being formed then return a list of JSONs containing variables replaced by values form tables
4. If no table is present in the description then return the JSON as it is.

Important instructions
1. Return only the List of JSONs and nothing else
"""


def redirection_url_finder(task_description):
    
    base_json_extract_prompt = ACTION_REDIRECTION_LINK.format(task_description=task_description)
    
    base_json_str = call_anthropic_model(
        prompt=base_json_extract_prompt
    )
    
    base_json_str = repair_json(base_json_str)
    base_json = json.loads(base_json_str)
    
    print("base json : \n",
        json.dumps(base_json, indent=4)
    )
    
    base_json_extend_prompt = VARIABLE_NAME_REPLACE_PROMPT.format(task_description=task_description,json=base_json_str)
    
    extended_json_list_str = call_anthropic_model(
        prompt=base_json_extend_prompt
    )
    
    
    print(extended_json_list_str)
    
    
    extended_json_list_str = repair_json(extended_json_list_str)
    extended_json_list = json.loads(extended_json_list_str)
    
    print("Extended JSON : \n",
        json.dumps(extended_json_list, indent=4)
    )
    
    return extended_json_list