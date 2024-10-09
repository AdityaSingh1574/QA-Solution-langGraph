ROUTER_PROMPT = """
You will be given a piece of text and input which can be either a greeting message, simple instructions or sophisticated set of instructions to perform an action on a webpage.
Your task is to classify the text either as `greetings` or `simple instructions` or `sophisticated instructions` and also mention what was the input text missing from being a `sophisticated instruction`, you need to return a JSON which will have the following schema:
{{
    "classified_type" : <classification type>,
    "missing_params" : <parameters missing from input text for being a `sophisticated instruction`>
}} 

the following is the piece of text between `---TEXT-START---` and `---TEXT-END---`
---TEXT-START---
{input_text}
---TEXT-END---

You can use the following points to complete the classification task:
1. The input text can be classified as `sophisticated text` only if it contains actions to be done on a webpage of a website and URLs on which the user gets redirected while the instructions are performed on the website, for this kind of the instructions the attribute `missing_params` will be assigned as `NULL`.
2. The input text can be classified as `simple instructions` in which either only actions (or with just the initial URL) or only redirection URLs with minimal actions (without much information about web elements) are given, for these kind of input text the attribute `missing_params` will either have `redirection URLs` or `webpage actions` which ever is not present in the input text. Consider the following rules for classifying the input text as `simple instructions`:
    2.a. if the input text only contains the URL which is required to be visited for completing a background process like login or sign-in or any other kind initial step which needs to be performed before the main action on any other webpage then classify it as `simple instructions`.
    2.b. if the input text only contains a bunch of URLs with minimal information about the actions to be performed on a web page and little or no information about web elements which needs to be interacted while performing the actions then classify it as `simple instructions`.
3. The input text will be classified as `greeting` if the given text is none of the above or appears to be like a greeting or a message which is not like an instruction or just a simple query about anything out of context. The `missing_params` attribute will have the value `ALL` as it does not have anything related to a `sophisticated instruction` type of input text, use the same logic to classify the input text as `greeting`.

Important instructions:
1. return only the JSON as the described schema and nothing else


You can use the following example for performing this classification task:

Input text:
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline: Test for adding new asset type on Mymis
User navigates to manage assets under Asset Allocation
redirect to : https://mymis.geminisolutions.com/Asset/Manage⁠
User clicks on Add new asset type
User gives asset type as "testing123" and Selects yes for Is temporary option and adds it 

output JSON:
{{
    "classified_type" : "sophisticated instructions",
    "missing_params" : "NULL"
}} 
Justification:
1. The input text contains both the actions to be performed on the webpages as well as the URLs on which the user will get redirected when action is performed on it.

Input text:
Background: User Selects Email option for login on https://hartron.geminisolutions.com
User Types Email : 'sivapuja.pasupulati@geminisolutions.com'
User types password : 'Siva@123' and clicks on Login button
User clicks on the hanmburger button
User Clicks on Tests dropdown
user selects Test controls 
Scenario: Hartron TestControl Verify Export Test Data Functionality
Given user is on TestControl screen
When click on Export test data button
And verify if download button exists

output JSON:
{{
    "classified_type" : "simple instructions",
    "missing_params" : "redirection URLs"
}} 

Justification:
1. the input text only contains the actions to be performed on a website, contains only one URL which is of the login page but not of the landing page and the page on which the actions of clicking and verifying it needs to be performed. 

Input text:

Background: User Selects Email option for login at https://athena-hartron-dev.geminisolutions.com/login and logs in
redirect to : https://athena-hartron-dev.geminisolutions.com/ and goes to Test controls
redirect to : https://athena-hartron-dev.geminisolutions.com/athena/admin/tests/test-control
Scenario Outline: Hartron TestControl Verify if User Navigated To "<Screen Name>":
User clicks on Actions and verifies if "<Action Data>"
Examples:
|Screen Name        | Action Data         |
|Candidate(s) Report| Candidate Report    |

output JSON:
{{
    "classified_type" : "simple instructions",
    "missing_params" : "webpage actions"
}} 
Justification:
1. the input text only contains the webpage URLs with very minimal webpage actions which cannot be inferred properly as it does not contain any information about what web elements would be included in the actions to be performed. 

Input text:
Hi, my name is Andrew, how are you? 
OR
Hi how are you doing ?
OR
What did the elephant have for the dinner ? 
OR 
whats the percentage of test cases real ?

output JSON:
{{
    "classified_type" : "greeting",
    "missing_params" : "ALL" 
}} 

Justification:
1. the input texts mentioned are either a greeting or a vague questions or a question which is not an instruction which has the properties of a `sophisticated instruction` as it does not have the action or the redirection URLs.  
"""