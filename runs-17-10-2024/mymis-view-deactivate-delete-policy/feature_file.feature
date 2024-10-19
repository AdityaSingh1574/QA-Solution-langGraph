Feature: Manage Policies on MIS Portal
  As a user, I want to manage policies on the MIS portal

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button

  Scenario: Deactivate and Delete Policy
    Given User navigates to manage policy
    And User is redirected to the MIS homepage
    When User clicks on view policy
    And User clicks on deactivate policy
    And User clicks confirm yes
    And User clicks on delete policy
    And User clicks confirm yes
    Then User is redirected to the Manage Policy page