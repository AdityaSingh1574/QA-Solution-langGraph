Feature: Hartron TestControl Course Filtering
  As a user of the TestControl screen
  I want to filter courses
  So that I can view specific course details

Scenario: Filter TestControl Course for HTET
  Given user is on TestControl screen
  When filter course values by clicking on the coures drop down and selecting HTET
  Then verify if records are filtered based on total records by printing the records count in the counter

Scenario: Filter TestControl Course for HSSC
  Given user is on TestControl screen
  When filter course values by clicking on the coures drop down and selecting HSSC
  Then verify if records are filtered based on total records by printing the records count in the counter

Scenario: Filter TestControl Course for HPSC
  Given user is on TestControl screen
  When filter course values by clicking on the coures drop down and selecting HPSC
  Then verify if records are filtered based on total records by printing the records count in the counter