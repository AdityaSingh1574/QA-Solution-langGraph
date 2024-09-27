Feature: TestControl Screen Sorting Functionality
  As a user of the TestControl screen
  I want to be able to sort the records by clicking on section names
  So that I can easily organize and view the data

Scenario: Hartron TestControl Click On Section Name Verify Records Are Sorted
  Given user is on TestControl screen
  When click on Name section
  Then verify if section is getting sorted in increasing form by printing first 3 Names