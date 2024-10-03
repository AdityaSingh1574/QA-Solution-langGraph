


WORK_ITEM_TO_FF_AZURE_DESC = """
    
    You will be given detailed descriptions of development tasks, convert each description into a scenario outline for testing the user interactions on the specified website. 

    The detailed description is given between `---DESCRIPTION-START---` and `---DESCRIPTION-END---`

    ---DESCRIPTION-START---
     {work_items_str}
    ---DESCRIPTION-END---

    You need to follow the below instructions for completing the task:
    1. Identify the Website URL: Extract and highlight the website URL if mentioned, and use it as the base context for all scenarios.
    2. Identify the overall action that has to be completed using the description1
    2. Outline the User Journey: The descriptions must be consolidated into one summary containing all the necessary steps that need to be followed to complete the overall task that has to be completed, the steps must be neither too less nor too more.
    3. Specify Actual Names and Identifiers:
    - Clearly name any buttons, links, or placeholders mentioned in the description. Use quotes to denote the exact labels or text on these UI elements.
    - If specific items are to be interacted with (like 'Noir Jacket' or 'Grey Jacket'), use these exact names in the scenario outline.
    4. Include Examples for Multiple Cases: If the task involves multiple items or variations, include a table of examples at the end of the scenario. Each row should represent a different case, clearly listing any relevant specifics like item names.
    5. Return only the summarization with the tasks, ignore adding anything additional like additional checks, etc 
    
    **Example Input**:
    "Implement and test the user interaction on the landing page of https://sauce-demo.myshopify.com/ to ensure that when a user clicks on an item name (e.g., Noir Jacket : https://sauce-demo.myshopify.com/collections/frontpage/products/noir-jacket ), they are redirected to the respective product page. This involves adjusting the UI to make item names clickable and ensuring that the redirect functionality is correctly set up. Acceptance Criteria: Clicking on an item name on the landing page redirects to the product page. Ensure compatibility with major browsers (Chrome, Firefox, Safari). UI elements should be accessible and responsive."

    **Example Output**:
    Scenario outline: Perform item selection on https://sauce-demo.myshopify.com/
    Given user is on the landing page of website https://sauce-demo.myshopify.com/
    When user clicks on the 'Noir Jacket' on the landing page
    Then user is redirected to the product page : https://sauce-demo.myshopify.com/collections/frontpage/products/noir-jacket


    Apply these steps to convert detailed task descriptions into concise, structured scenario outlines for testing.
    """


USER_STORY_CONVERSION_PROMPT="""
You will be given a set of instructions for completing an action or a set of actions on a website, the description shall contain actions performed on web elements, whose names will be mentioned in the description
Your task is to create a feature file in gherkin syntax which will be used for performing Automation testing on the website by performing these actions on different web pages.    

The following is the TASK-DESCRIPTION given between `---TASK-DESCRIPTION-START---` and `---TASK-DESCRIPTION-END---`:
---TASK-DESCRIPTION-START---
{user_story}
---TASK-DESCRIPTION-END---

You need to follow the below instruction for completing the task:
1. go through the given task description between the separators `---TASK-DESCRIPTION-START---` and `---TASK-DESCRIPTION-END---`
2. Identify the names of the elements in each of the instructions and the particular actions associated with each of the elements
3. Break the instructions in a way that for each line in the feature file one action and one element is covered
4. for every broken down instruction convert the instruction into gherkin syntax 
5. Include only the first URL given in the instructions,  for the rest which infer redirection from one webpage to another include a line in gherkn syntax which infers about redirection. 

Important instructions
1. Do not return anything other than the gherkin syntax
2. Make use of the word `User` for specifying user in the feature file
3. If the actions specify log-in/authentication and then performing other actions the segregate the authentication part in Background part of feature file
4. If no Examples are given the return the gherkin syntax for whatever value is given

The following is an example of how this can be done 

Sample Input:
URL: https://www.amazon.in/ 

Feature: Add Books in the cart from Amazon

Scenario Outline: Search 'book' From Amazon website
Given user Search 'book' in the Search Box
And user add First 'book' in the cart
When user add item to the cart


The output for the above will be as follows:

Feature: Add Items to Cart on https://www.amazon.in
As a user, I want to search for various items on Amazon and add them to my cart

Scenario: Search and Add Book to Cart
    Given user is on the Amazon homepage
    When user searches for 'Book' in the search box
    And user selects the first 'Book' from the search results
    And user clicks on 'Add to Cart' button
    Then the 'Book' should be added to the user's cart
"""
