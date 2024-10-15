Feature: Task Management on MyMIS
  As a user, I want to manage team tasks on the MyMIS platform

  Background: User Authentication
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Manage Team Tasks
    Given User is on the MyMIS homepage
    When User navigates to "Manage team task" under task management
    Then User should be redirected to the Manage Task Team page
    When User changes entries to 25
    And User enters "testing 123" in the search input
    Then The search results should be displayed