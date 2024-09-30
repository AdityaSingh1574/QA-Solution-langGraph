Feature: User Card Mapping on https://mymis.geminisolutions.com/
  As a user, I want to search for and verify user cards in the Access Card Management system

  Scenario: Search for Akshi Khattar's card
    Given the user is logged into the MIS system
    When user navigates to "Access Card Management" and then "User Card Mapping"
    And user enters "Akshi Khattar" in the search bar
    Then the system should display search results
    And the first result's name field should contain "Akshi Khattar"
    And user verifies that the search function is working correctly for "Akshi Khattar"