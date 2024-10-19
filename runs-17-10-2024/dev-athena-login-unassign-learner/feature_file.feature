Feature: Manage Courses and Batches on https://dev-athena.geminisolutions.com
  As an admin user, I want to manage courses and batches, including assigning and unassigning learners

  Background:
    Given User is on the login page
    When User enters email 'test1234@gmail.com' in the email input field
    And User enters password 'test@123' in the password input field
    And User clicks on the sign in button
    Then User should be redirected to the user dashboard

  Scenario: Unassign a Learner from a Batch
    Given User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the batches page
    When User clicks on the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the current assigned learners count
    And User unassigns the learner with email 'egwuyrx@gmail.com'
    And User clicks on the 'unassign selected' button
    And User confirms the unassignment by clicking the 'Yes' button
    Then User should validate the count after unassigning