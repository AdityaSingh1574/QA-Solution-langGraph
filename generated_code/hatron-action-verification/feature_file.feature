Feature: Hartron TestControl Navigation
  As a user, I want to navigate to different screens from the TestControl page

  Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

  Scenario: Verify Navigation to Candidate(s) Report
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Candidate Report" exists in action menu by clicking on it
    And verify if user is navigated to "Candidate(s) Report"

  Scenario: Verify Navigation to Evaluate Candidate
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Evaluate Candidate" exists in action menu by clicking on it
    And verify if user is navigated to "Evaluate Candidate"

  Scenario: Verify Navigation to Test Summary
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Test Summary" exists in action menu by clicking on it
    And verify if user is navigated to "Test Summary"