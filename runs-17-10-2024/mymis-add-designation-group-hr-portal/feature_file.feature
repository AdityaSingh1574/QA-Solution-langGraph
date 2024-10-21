Feature: Manage Designation in HR Portal
  As a user, I want to add a new designation group in the HR Portal

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the dashboard

  Scenario: Add New Designation Group
    Given User navigates to Manage designation under HR Portal
    And User is redirected to the Manage Designation page
    When User clicks 'Add' button
    And User enters designation group title as "test1233" in input field
    And User clicks save button
    Then The new designation group should be added successfully