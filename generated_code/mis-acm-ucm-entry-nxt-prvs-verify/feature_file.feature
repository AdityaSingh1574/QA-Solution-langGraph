Feature: Manage Access Card on https://mymis.geminisolutions.com/
  As a user, I want to verify the paging functionality in the Access Card Management section

  Scenario: Verify paging functionality with 25 records per page
    Given user is on the MIS homepage
    When user navigates to "Access Card Management" and then "Manage Access Card"
    And user selects "25" from the number of entries dropdown
    Then the number of entries displayed should change to 25
    When user clicks on the "Next" button
    Then the next page of records should be displayed
    When user clicks on the "Previous" button
    Then the previous page of records should be displayed