Feature: Access Card Management on https://mymis.geminisolutions.com/
  As an administrator, I want to manage access cards in the MIS system

  Background: Login to MIS
    Given Login to MIS with Username 'webadmin' and password 'Gemini@123'
    When Click on Signin button
    Then User should be navigated to MIS homepage

  @regression @AccessCard @reg
  Scenario: Manage Access Card - Add New Access Card with number 915502354
    When user navigates on "Access Card Management" and then "Manage Access Card"
    And User adds new "915502354" Access card by clicking on the "add new card" button
    And User types the card number "915502354"
    And User toggles the temporary card option
    And User clicks the Add button
    Then Verify Card Added successfully
    And The new card "915502354" should appear in the list of access cards