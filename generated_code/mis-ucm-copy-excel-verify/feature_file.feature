Feature: User Card Mapping - Mapped Cards Export Options on https://mymis.geminisolutions.com/
  As a user, I want to export and print user card mapping information

  Scenario: Export and Print User Card Mapping
    Given user is on the MIS homepage
    When user navigates on "Access Card Management" and then "User Card Mapping"
    And User click on export button
    And User click on Copy option
    Then the user card mapping data should be copied to clipboard
    When User click on Excel option
    Then User verifies if Excel "User Card Mapping" got downloaded
    When User click on Print button
    Then User verifies if Print "User Card Mapping" works