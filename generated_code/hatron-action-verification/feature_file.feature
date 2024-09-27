Feature: Hartron TestControl Action Menu Verification
  As a user of the TestControl screen
  I want to verify the presence of specific actions in the action menu
  So that I can ensure all necessary options are available

  Scenario: Verify Candidate Report in Action Menu
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Candidate Report" exists in action menu by clicking it

  Scenario: Verify Evaluate Candidate in Action Menu
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Evaluate Candidate" exists in action menu by clicking it

  Scenario: Verify Test Summary in Action Menu
    Given user is on TestControl screen
    When click on Actions
    Then verify if "Test Summary" exists in action menu by clicking it