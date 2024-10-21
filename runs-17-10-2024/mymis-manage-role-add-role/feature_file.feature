Feature: Manage Roles on MyMIS
  As an administrator, I want to log in and add a new role

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button

  Scenario: Add a new role
    Given User navigates to manage role under Administrations
    And User is redirected to the MyMIS homepage
    When User navigates to the Manage Role page
    And User is redirected to the Manage Role page
    And User enters the role name "test123"
    And User clicks add role button
    Then the new role should be added successfully