Feature: Manage Scheduler on MyMIS
  As a user, I want to log in and add a new scheduler action

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Add a new scheduler action
    Given User navigates to Manage Scheduler under Administrations
    Then User should be redirected to the Manage Scheduler page
    When User clicks on the Add Scheduler Action button
    And User enters scheduler name in the input field
    And User enters description in the input field
    And User enters function name in the input field
    And User clicks on the final Add button
    Then User should be redirected to the Manage Scheduler page