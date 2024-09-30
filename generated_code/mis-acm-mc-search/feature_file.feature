Feature: Access Card Management on https://mymis.geminisolutions.com/
  As a user, I want to manage access cards and use the search functionality

  Background: Login to MIS
    Given the user is on the MIS login page
    When the user enters username 'webadmin' and password 'Gemini@123'
    And the user clicks on the Signin button
    Then the user should be navigated to the MIS homepage

  Scenario: Manage Access Card - Search functionality for card number 125552356
    Given the user is on the MIS homepage
    When the user navigates to "Access Card Management" and then "Manage Access Card"
    Then the user is redirected to the "Manage Access Card" page
    When the user searches for card number "125552356" in the search input
    Then the search function should display results for card number "125552356"
    And the search results should accurately match the entered card number "125552356"