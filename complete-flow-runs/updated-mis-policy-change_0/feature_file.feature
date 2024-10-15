Feature: Manage Policies on MyMIS
  As a user, I want to log in and manage policies on the MyMIS website

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@123" in the password field
    And User clicks on the login button

  Scenario: Deactivate and Delete a Policy
    Given User is redirected to the homepage
    When User navigates to the Manage Policy page
    Then User is redirected to "https://mymis.geminisolutions.com/Policy/ManagePolicy"
    When User clicks on the view policy button
    And User clicks on the deactivate policy button
    And User confirms by clicking yes
    And User clicks on the delete policy button
    And User confirms by clicking yes