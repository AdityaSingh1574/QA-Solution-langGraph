import requests
from requests.auth import HTTPBasicAuth
import json
import re
from dotenv import load_dotenv
import os
from logger import logger

load_dotenv()

# Cache to store ticket details to avoid hitting the same ticket multiple times
ticket_cache = {}

# Set to track visited tickets and avoid infinite recursion
visited_tickets = set()

# Dictionary to hold the hierarchy flowchart in JSON format
ticket_hierarchy = {}

def validate_jira_credentials(jira_base_url, email, api_token):
    """
    Validates Jira credentials by attempting to fetch user information.
    Args:
        jira_base_url (str): The base URL of the Jira instance.
        email (str): The Jira username (email).
        api_token (str): The API token for Jira.
    Returns:
        bool: True if the credentials are valid, otherwise False.
    """
    jira_api_url = f"{jira_base_url}/rest/api/2/myself"
    response = requests.get(
        jira_api_url,
        auth=HTTPBasicAuth(email, api_token),
        headers={'Content-Type': 'application/json'}
    )

    try:
        # Try to parse the JSON response
        response_data = response.json()

        if response.status_code == 200:
            return {"status" :  200, "message" : "Jira Login Successful!"}
        else:
            return {"status" : 400 ,"message" : f"Invalid Jira credentials: {response.status_code} - {response_data.get('errorMessages', 'Unknown error')}"}
    except requests.exceptions.JSONDecodeError:
        # Handle the case where the response is not JSON
        {"status" : 400 , "message" : f"Invalid response from Jira when validating credentials. Status Code: {response.status_code}, Response Text: {check_html_content(response.text)}"}



def check_html_content(data):
    """
    Check if the input data is of HTML type.
    
    Args:
        data (str): Input data to be checked.
        
    Returns:
        str: Returns the HTML content if it's HTML; otherwise, returns the input string.
    """
    # Strip whitespace and check for common HTML characteristics
    # stripped_data = data.strip()
    
    # Check for the presence of common HTML tags
    stripped_data = data.strip()
    if data.strip().startswith('<!DOCTYPE html>') or re.search(r'<[^>]+>', stripped_data):  # Checks for any HTML-like tags
        return 'The site may be unavailable or the URL is incorrect.'  # Return the HTML content
    else:
        return str(data)  # Return the input data as a string


def validate_jira_ticket_access(ticket_key, jira_base_url, email, api_token):
    """
    Validates if the user has access to the Jira ticket (epic link) and checks if the ticket belongs to the given base URL.
    Args:
        ticket_key (str): The Jira ticket key (e.g., 'COM-1258').
        jira_base_url (str): The base URL of the Jira instance.
        email (str): The Jira username (email).
        api_token (str): The API token for Jira.
    Returns:
        bool: True if the user has access and the ticket is valid, otherwise False.
    """
    jira_api_url = f"{jira_base_url}/rest/api/2/issue/{ticket_key}"
    response = requests.get(
        jira_api_url,
        auth=HTTPBasicAuth(email, api_token),
        headers={'Content-Type': 'application/json'}
    )

    try:
        # Try to parse the JSON response
        response_data = response.json()

        if response.status_code == 200:
            # Additional check to ensure the ticket is part of the given Jira base URL
            if jira_base_url not in response_data.get('self', ''):
                return {"status" : 400, "message" : f"The ticket {ticket_key} does not belong to the Jira base URL: {jira_base_url}"}
            return {"status" : 200, "message" : "user has access to ticket"}
        else:
            return {"status": 400, "message" :f"Access denied to ticket {ticket_key}: {response.status_code} - {response_data.get('errorMessages', 'Unknown error')}"}
    except requests.exceptions.JSONDecodeError:
        # Handle the case where the response is not JSON
        return {"status" : 400 , "message": f"Invalid response from Jira when validating ticket access. Status Code: {response.status_code}, Response Text: {response.text}"}



def extract_ticket_key_from_url(jira_url):
    """
    Extracts the Jira ticket key from a Jira issue URL.
    Args:
        jira_url (str): The Jira issue URL.
    Returns:
        str: The ticket key, or None if the URL format is invalid.
    """
    match = re.search(r'/browse/([A-Z]+-\d+)', jira_url)
    if match:
        return {"status" : 200 , "message" : match.group(1)}
    else:
        return {"status" : 400, "message" : "Invalid Jira URL format."}

def get_ticket_data(ticket_key, jira_base_url, email, api_token):
    """
    Fetches Jira ticket data from the Jira API and caches the result.
    Args:
        ticket_key (str): The Jira ticket key (e.g., 'COM-1258').
        jira_base_url (str): The base URL of the Jira instance.
        email (str): The Jira username (email).
        api_token (str): The API token for Jira.
    Returns:
        dict: The JSON data of the Jira ticket, or None if the request fails.
    """
    if ticket_key in ticket_cache:
        return ticket_cache[ticket_key]

    jira_api_url = f"{jira_base_url}/rest/api/2/issue/{ticket_key}"

    response = requests.get(
        jira_api_url,
        auth=HTTPBasicAuth(email, api_token),
        headers={'Content-Type': 'application/json'}
    )

    try:
        ticket_data = response.json()
        ticket_cache[ticket_key] = ticket_data
        return ticket_data
    except requests.exceptions.JSONDecodeError:
        return {"status" : 400 ,"message" : f"Failed to retrieve data for ticket {ticket_key}: Status Code {response.status_code}, Response Text: {response.text}"}

def collect_ticket_information(ticket_key, jira_base_url, email, api_token, parent_ticket=None):
    """
    Recursively collects detailed information for a Jira ticket and its linked issues.
    Args:
        ticket_key (str): The Jira ticket key.
        jira_base_url (str): The base URL of the Jira instance.
        email (str): The Jira username (email).
        api_token (str): The API token for Jira.
        parent_ticket (str, optional): The parent ticket to avoid circular references.
    Returns:
        list: A list containing dictionaries of ticket information.
    """
    if ticket_key in visited_tickets:
        return []

    visited_tickets.add(ticket_key)

    ticket_data = get_ticket_data(ticket_key, jira_base_url, email, api_token)
    if not ticket_data:
        return []

    ticket_info = {'key': ticket_key}

    # Extracting the relevant fields from the ticket
    ticket_info['summary'] = ticket_data['fields'].get('summary', 'No summary available')
    ticket_info['description'] = ticket_data['fields'].get('description', 'No description available')
    ticket_info['status'] = ticket_data['fields'].get('status', {}).get('name', 'No status available')

    # Replace 'customfield_10000' with the actual custom field ID for acceptance criteria if necessary
    ticket_info['acceptance_criteria'] = ticket_data['fields'].get('customfield_10000', 'No acceptance criteria available')

    # Extracting and storing comments if they exist
    comments = ticket_data['fields'].get('comment', {}).get('comments', [])
    ticket_info['comments'] = [comment['body'] for comment in comments] if comments else []

    # Processing linked issues to build the hierarchy
    issue_links = ticket_data['fields'].get('issuelinks', [])
    linked_issues = []

    for link in issue_links:
        if 'inwardIssue' in link:
            linked_issue_key = link['inwardIssue']['key']
            if linked_issue_key != parent_ticket:  # Avoid circular reference to the parent ticket
                linked_issues.append(linked_issue_key)
        elif 'outwardIssue' in link:
            linked_issue_key = link['outwardIssue']['key']
            if linked_issue_key != parent_ticket:
                linked_issues.append(linked_issue_key)

    if linked_issues:
        ticket_hierarchy[ticket_key] = linked_issues

    # Recursively collect information for linked tickets
    linked_tickets_info = []
    for linked_issue_key in linked_issues:
        linked_tickets_info.extend(collect_ticket_information(linked_issue_key, jira_base_url, email, api_token, parent_ticket=ticket_key))

    return [ticket_info] + linked_tickets_info


def convert_ticket_details_as_string(ticket_details):
    
    ticket_details_string = ""
    
    for ticket in ticket_details:
        ticket_details_string += f"Issue Key: {ticket['key']} \n"
        ticket_details_string += f"Summary: {ticket['summary']} \n"
        ticket_details_string += f"Description: {ticket['description']} \n"
        ticket_details_string += f"Status: {ticket['status']} \n"
        ticket_details_string += f"Acceptance Criteria: {ticket['acceptance_criteria']} \n"
        if ticket['comments']:
            ticket_details_string += "Comments: \n"
            for comment in ticket['comments']:
                ticket_details_string += f"- {comment} \n"
        ticket_details_string += "------------\n"

    with open("description_txt.txt", "w") as f:
        f.write(ticket_details_string)
    
    return ticket_details_string
    
def get_jira_description(jira_url :str)->str:
    
    email = os.getenv("GEMINI_EMAIL_JIRA")
    api_token = os.getenv("JIRA_API_TOKEN")
    
    # Extracting ticket key from the URL
    
    extracted_tkt_info = extract_ticket_key_from_url(jira_url)
    
    if extracted_tkt_info["status"] == 400:
        return extracted_tkt_info["message"]

    ticket_key = extracted_tkt_info["message"]
    # Extracting Jira base URL from the provided Jira link
    jira_base_url = re.match(r"(https://[^/]+)", jira_url).group(1)

    # Step 1: Validate Jira credentials
    validation_info = validate_jira_credentials(jira_base_url, email, api_token)
    
    if validation_info["status"] == 400:
        return validation_info['message']

    # Step 2: Validate access to the given Jira ticket (epic link)
    validation_access_info = validate_jira_ticket_access(ticket_key, jira_base_url, email, api_token)
    if validation_access_info["status"] == 400:
        return validation_access_info["message"]

    # Step 3: Collecting ticket information recursively for the ticket and its linked issues
    ticket_details = collect_ticket_information(ticket_key, jira_base_url, email, api_token)

    return convert_ticket_details_as_string(ticket_details)


