Feature: Hartron TestControl Course Filtering
  As a user, I want to filter courses in the TestControl screen
  So that I can view specific course details

  Background:
    Given User Selects Email option for login at https://athena-hartron-dev.geminisolutions.com/login
    And User Types Email : 'sivapuja.pasupulati@geminisolutions.com'
    And User types password : 'Siva@123' and clicks on Login button
    And User clicks on the hanmburger button
    And User Clicks on Tests dropdown
    And user selects Test controls

  Scenario: Filter TestControl by CITS Course
    Given user is on TestControl screen
    When filter course values by clicking on the coures drop down and selecting CITS
    Then verify if records are filtered based on total records by printing the records count in the counter

  Scenario: Filter TestControl by CTS Course
    Given user is on TestControl screen
    When filter course values by clicking on the coures drop down and selecting CTS
    Then verify if records are filtered based on total records by printing the records count in the counter

  Scenario: Filter TestControl by CITS-MMTTS Course
    Given user is on TestControl screen
    When filter course values by clicking on the coures drop down and selecting CITS-MMTTS
    Then verify if records are filtered based on total records by printing the records count in the counter