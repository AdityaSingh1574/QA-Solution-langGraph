Feature: Hartron TestControl Sorting Functionality
  As a user, I want to verify the sorting functionality of the TestControl screen

  Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

  Scenario: Verify Sorting of TestControl Records by Name
    Given user is on TestControl screen
    When user clicks on Name section
    Then the records should be sorted in ascending order by Name
    And user should verify the sorting by printing the first 3 Names