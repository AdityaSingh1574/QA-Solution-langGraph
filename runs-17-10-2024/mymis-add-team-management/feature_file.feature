Feature: Team Management on MIS Portal
  As a user, I want to log in and create a new team

  Background:
    Given user is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When user enters user id "webadmin"
    And user enters password "Gemini@1234"
    And user clicks on the login button
    Then user should be redirected to the MIS homepage

  Scenario: Create a New Team
    Given user navigates to team info under team management
    Then user should be redirected to the Team Information page
    When user enters team name as "testing123"
    And user selects weak start day as "Tuesday" from the dropdown
    And user selects department as "data science" from the dropdown
    And user selects team head as "123 user" from the dropdown
    And user clicks on the save button
    Then the new team should be created successfully