Feature: Hartron TestControl Search Functionality
  As a user, I want to search for test controls by name or tag to filter the records

  Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

  Scenario: Search TestControl by Core Java course name
    Given user is on TestControl screen
    When enter search text in Search by 'Core Java'
    Then verify if records are filtered by checking the count of courses

  Scenario: Search TestControl by Python course name
    Given user is on TestControl screen
    When enter search text in Search by 'Python'
    Then verify if records are filtered by checking the count of courses