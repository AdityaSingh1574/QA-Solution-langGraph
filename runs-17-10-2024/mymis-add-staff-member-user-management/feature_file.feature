Feature: Staff Member Management on MIS Portal
  As a user, I want to add a new staff member to the system

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MIS homepage

  Scenario: Add a New Staff Member
    Given User navigates to the Manage Staff Member page
    When User clicks on the "Add new staff member" button
    And User enters "test123" in the name field
    And User enters "234354565" in the phone number field
    And User clicks on the location dropdown
    And User selects "Canan tower" from the location dropdown
    And User clicks on the save button
    Then User should be redirected to the Manage Staff Member page