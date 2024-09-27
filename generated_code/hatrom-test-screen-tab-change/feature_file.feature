Feature: Hartron TestControl HSC Examination and Exam Template Navigation
  As a user of the Hartron TestControl system
  I want to navigate between HSC Examination and Exam Template Management screens
  So that I can manage examination and template related tasks

Scenario: Verify HSC Examination Screen and Navigate to Exam Template Management
  Given user is on TestControl screen
  When the page loads completely
  Then the user should see the HSC Examination screen
  When the user navigates to Exam Template Management
  Then the user should be on the Exam Template Management screen