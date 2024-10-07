Feature: Task Management on MIS Portal
  As a user, I want to manage team tasks on the MIS portal

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@1234"
    And User clicks the login button

  Scenario: Manage Team Tasks
    Given User navigates to "Manage team task" under task management
    And User is redirected to the MIS homepage
    When User navigates to the Manage Task Team page
    And User changes the entries to 25
    And User searches for "testing 123"
    And User presses enter
    Then User should see the search results for "testing 123"