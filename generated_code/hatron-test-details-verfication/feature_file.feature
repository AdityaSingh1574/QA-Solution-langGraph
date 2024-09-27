Feature: Hartron TestControl - Verify Test Details Screen in Test Management

Scenario: Verify Test Details Screen for First Test
  Given user is on TestControl screen
  When user clicks on the first Test in the list
  Then the test details screen should be displayed
  And the test URL should be printed in the console