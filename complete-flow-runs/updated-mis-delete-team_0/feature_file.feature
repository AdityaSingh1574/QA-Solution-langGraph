Feature: Team Management on MyMIS
  As a user, I want to manage teams on the MyMIS platform

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Delete a Team
    Given User navigates to team info under team management
    And User is redirected to the team management page
    When User clicks view to view team
    And User clicks delete
    And User confirms the deletion
    Then User should be redirected to the team information page