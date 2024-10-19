Feature: Task Management on MyMIS
  As a user, I want to log in and manage task details on MyMIS

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button

  Scenario: Add New Task Detail
    Given User navigates to the Manage Task Sub Details page
    And User is redirected to the MyMIS homepage
    When User clicks on the "Add New Task Details" button
    And User enters "testing321" in the task name input field
    And User clicks on the add button
    Then User should be redirected to the Manage Task Sub Detail page