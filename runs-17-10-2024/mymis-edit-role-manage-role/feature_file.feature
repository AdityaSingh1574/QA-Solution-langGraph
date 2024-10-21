Feature: Manage Roles on MyMIS
  As an administrator, I want to update existing roles in the system

  Background:
    Given User is on the MyMIS login page at "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button

  Scenario: Update an existing role
    Given User navigates to manage role under Administrations
    And User is redirected to the MyMIS homepage
    When User selects the role "test123"
    And User changes the name to "test124"
    And User clicks update role button
    Then User should be redirected to the Manage Role page