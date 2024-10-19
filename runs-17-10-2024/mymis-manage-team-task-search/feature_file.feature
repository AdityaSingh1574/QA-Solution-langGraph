Feature: Task Management on MyMIS
  As a user, I want to manage team tasks on the MyMIS platform

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button

  Scenario: Manage Team Tasks
    Given User navigates to "Manage team task" under task management
    When User changes the entries to 25
    And User searches for "testing 123"
    And User presses enter
    Then User should be redirected to the Manage Task Team page