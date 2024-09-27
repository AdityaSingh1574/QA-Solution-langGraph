Feature: Hartron TestControl - HSC Examination and Exam Template Navigation
  As a user, I want to navigate through the TestControl screens to verify HSC Examination and Exam Template Management

  Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

  Scenario: Verify HSC Examination and Exam Template Navigation
    Given user is on TestControl screen
    Then Verify if user is on HSC Examination screen
    When user navigates to Exam Template Management
    Then Verify if user is on Exam Template Management screen