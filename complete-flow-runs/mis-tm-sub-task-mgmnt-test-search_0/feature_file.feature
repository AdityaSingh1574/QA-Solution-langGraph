Feature: Task Management on MIS Portal
  As a user, I want to manage team tasks on the MIS portal

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@123" in the password field
    And User clicks on the login button

  Scenario: Manage Team Tasks
    Given User is redirected to the MIS homepage
    When User navigates to "Manage team task" under task management
    Then User is redirected to the Manage Task Team page
    When User changes entries to 25
    And User enters "testing 123" in the search input field
    And User presses enter
    Then User should see the filtered results for "testing 123"