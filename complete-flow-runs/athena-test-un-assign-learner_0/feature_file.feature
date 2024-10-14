Feature: Manage Courses and Batches on Athena Platform
  As an admin user, I want to manage courses, batches, and assign learners

  Background:
    Given User is on the login page "https://dev-athena.geminisolutions.com/login"
    When User enters email "test123@gmail.com" in the email field
    And User enters password "test@123" in the password field
    And User clicks the sign in button

  Scenario: Assign and Unassign Learners to a Batch
    Given User selects "Manage Courses" from the sidebar
    And User selects "Batches" from the sidebar
    Then User should be redirected to the user dashboard page
    When User clicks the actions icon for the "dummy" record
    And User selects "Assign Learners" from the actions dropdown
    Then User should be redirected to the assign learners page
    When User expands the "Category" dropdown
    And User selects "EC" from the Category dropdown
    And User expands the "selected category" dropdown
    And User selects "QA" from the selected category dropdown
    Then User gets the assigned learners count
    When User unassigns a learner from the filtered list
    Then User validates the count after unassigning