Feature: Task Management on MIS Portal
  As a user, I want to log in and manage task details

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@1234"
    And User clicks on the login button

  Scenario: Add New Task Detail
    Given User navigates to manage task sub details under task management
    And User is redirected to the MIS homepage
    When User clicks on add new task details
    And User enters task name as "testing321"
    And User clicks on the add button
    Then User should be redirected to the task sub detail page