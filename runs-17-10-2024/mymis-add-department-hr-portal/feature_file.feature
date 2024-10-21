Feature: Manage Departments in HR Portal
  As a user, I want to log in and add a new department

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@1234"
    And User clicks on the login button
    Then User should be redirected to the homepage

  Scenario: Add a New Department
    Given User navigates to Manage department/teams under HR Portal
    When User clicks on 'Add Department' button
    And User enters department name as "test1233"
    And User enters department description as "test1233"
    And User clicks on department head dropdown
    And User selects "123 User" from the dropdown
    And User clicks on division name dropdown
    And User selects "Seekhley" from the dropdown
    And User clicks on 'Add' button
    Then User should be redirected to the Manage Department page