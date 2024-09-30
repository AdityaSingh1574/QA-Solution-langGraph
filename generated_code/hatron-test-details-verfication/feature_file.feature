Feature: Hartron TestControl Verify Test Details Screen In Test Management

Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

Scenario: Verify Test Details Screen In Test Management
    Given user is on TestControl screen
    When user clicks on the first Test to get test details
    Then the test details screen should be displayed
    And the test URL should be printed