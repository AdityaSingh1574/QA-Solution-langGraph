Feature: User Card Mapping on https://mymis.geminisolutions.com/
  As a user, I want to manage unmapped cards and export their data

  Scenario: Export and Print User Card Mapping Data
    Given user is on the MIS homepage
    When user navigates on "Access Card Management" and then "User Card Mapping"
    And User goes to Unmapped card history
    When User click on export button two
    And User click on Copy option two
    Then the unmapped card data should be copied to clipboard
    When User click on Excel option two
    Then User verifies if Excel "User Card Mapping" got downloaded
    When User click on Print button two
    Then User verifies if Print "User Card Mapping" works