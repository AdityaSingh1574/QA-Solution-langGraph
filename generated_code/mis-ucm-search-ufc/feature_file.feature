Feature: User Card Mapping - Unfinalize Card Mapping on https://mymis.geminisolutions.com/
  As a user, I want to unfinalize card mappings in the Access Card Management system

  Scenario: Unfinalize Card Mapping for user card
    Given the user is logged into the MIS system
    When user navigates on "Access Card Management" and then "User Card Mapping"
    And searching a "user" card by typing the user in the search input
    And user Unfinalize Card Mapping by clicking on additional options and then clicking Unfinalize
    Then Verify Mapping unfinalized
    And the card status should change to 'Unfinalized'
    And the card should be available for re-mapping