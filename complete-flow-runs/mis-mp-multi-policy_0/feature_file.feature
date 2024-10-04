Feature: Manage Policies on MIS Portal
  As a user, I want to log in and manage policies on the MIS portal

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@123"
    And User clicks login button
    Then User should be redirected to the homepage

  Scenario: Deactivate and Delete Policy
    Given User navigates to manage policy page
    When User clicks on view policy
    And User clicks on deactivate policy
    And User confirms deactivation by clicking yes
    And User clicks on delete policy
    And User confirms deletion by clicking yes
    Then User should be redirected to the manage policy page