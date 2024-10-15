Feature: Team Management on https://mymis.geminisolutions.com
  As a user, I want to log in and create a new team

  Background:
    Given User is on the login page
    When User types user id 'webadmin'
    And User types password 'Gemini@123'
    And User clicks login button

  Scenario: Create a New Team
    Given User navigates to team info under team management
    And User is redirected to the dashboard
    When User enters team name as 'testing123'
    And User selects weak start day as Tuesday
    And User selects department as data science
    And User selects team head as 123 user
    And User clicks save button
    Then User should be redirected to the Team Information page