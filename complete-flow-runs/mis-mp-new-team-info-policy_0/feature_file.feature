Feature: Team Management on MIS Portal
  As a user, I want to log in and create a new team

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@123"
    And User clicks on the login button
    Then User should be redirected to the MIS homepage

  Scenario: Create a New Team
    Given User navigates to team info under team management
    Then User should be redirected to the Team Information page
    When User enters team name as "testing123"
    And User selects weak start day as "Tuesday" from the dropdown
    And User selects department as "data science" from the dropdown
    And User selects team head as "123 user" from the dropdown
    And User clicks on the save button
    Then The new team should be created successfully