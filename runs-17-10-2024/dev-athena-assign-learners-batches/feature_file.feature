Feature: Manage Courses and Assign Learners on Athena Platform
  As an admin user, I want to manage courses and assign learners to batches

  Background:
    Given User is on the login page of https://dev-athena.geminisolutions.com/login
    When User enters email 'test1234@gmail.com' in the email field
    And User enters password 'test@123' in the password field
    And User clicks the sign in button
    Then User should be redirected to the user dashboard

  Scenario: Assign Learners to a Batch
    Given User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the batches page
    When User clicks the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the assigned learners count
    And User selects an unassigned learner from the current page
    And User navigates to the next page
    And User selects another unassigned learner
    And User clicks the 'Assign Selected' button
    And User clicks the 'Yes' button to confirm assignment
    Then User should be redirected to the batches page