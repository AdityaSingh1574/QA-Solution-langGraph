Feature: Manage Courses and Batches on https://dev-athena.geminisolutions.com
  As an admin user, I want to manage courses, batches, and assign/unassign learners

  Background:
    Given User is on the login page
    When User types 'test123@gmail.com' in the email field
    And User types 'test@123' in the password field
    And User clicks the sign in button

  Scenario: Unassign a Learner from a Batch
    Given User is on the user dashboard
    When User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the batches page
    When User clicks the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the current assigned learners count
    And User unassigns the learner with email 'egwuyrx@gmail.com'
    And User clicks the 'unassign selected' button
    And User confirms by clicking the 'Yes' button
    Then User should validate the count after unassigning