Feature: Access Card Management on https://mymis.geminisolutions.com/
  As a user, I want to manage access cards and verify paging functionality

  Background: Login to MIS
    Given Login to MIS with Username 'webadmin' and password 'Gemini@123'
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Manage Access Card - Verify paging functionality with 25 records
    When user navigates on "Access Card Management" and then "Manage Access Card"
    And Verify Entries changes to "25" number of entries by selecting "25" records from record selection drop down
    And Verify Next "Next" Button works
    And Verify Previous "Previous" works
    Then the page should display 25 records
    And user should be able to navigate through pages using Next and Previous buttons