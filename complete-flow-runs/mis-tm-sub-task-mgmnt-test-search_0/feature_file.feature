Feature: Task Management on MIS Portal
  As a user, I want to manage team tasks on the MIS portal

  Background: User Authentication
    Given user is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When user enters user id "webadmin" in the username field
    And user enters password "Gemini@123" in the password field
    And user clicks on the login button
    Then user should be redirected to the MIS homepage

  Scenario: Manage Team Tasks
    Given user is on the MIS homepage
    When user navigates to "Manage team task" under task management
    Then user should be redirected to the Manage Task Team page
    When user changes entries to 25
    And user enters "testing 123" in the search input field
    And user presses enter
    Then the search results should be displayed