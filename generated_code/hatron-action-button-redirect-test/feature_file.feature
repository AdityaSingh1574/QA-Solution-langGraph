Feature: Hartron TestControl Navigation
  As a user of the Hartron TestControl system
  I want to navigate to different screens from the Actions menu
  So that I can access various functionalities of the system

  Scenario: Navigate to Candidate(s) Report
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Candidate Report" exists in action menu by clicking on it
    And verify if user is navigated to "Candidate(s) Report"

  Scenario: Navigate to Evaluate Candidate
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Evaluate Candidate" exists in action menu by clicking on it
    And verify if user is navigated to "Evaluate Candidate"

  Scenario: Navigate to Test Summary
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Test Summary" exists in action menu by clicking on it
    And verify if user is navigated to "Test Summary"