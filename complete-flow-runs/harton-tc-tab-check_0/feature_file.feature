Feature: Login and Navigate to Exam Template Management on Athena Hartron
  As a user, I want to log in and navigate to the Exam Template Management screen

  Background:
    Given User is on the login page "https://athena-hartron-dev.geminisolutions.com/login"
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    Then User should be redirected to the dashboard

  Scenario: Navigate to Exam Template Management
    Given User is on the dashboard
    When User navigates to test controls under tests
    Then User should be redirected to the test controls page
    When User verifies if on HSC Examination screen
    And User navigates to Exam Template Management
    Then User should be redirected to the Exam Template Management screen
    And User verifies if on Exam Template Management screen