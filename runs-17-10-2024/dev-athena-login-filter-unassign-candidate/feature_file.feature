Feature: Manage Courses and Batches on https://dev-athena.geminisolutions.com
  As an admin user, I want to manage courses, batches, and assign learners

  Background:
    Given User is on the login page
    When User enters email 'test1234@gmail.com' and password 'test@123'
    And User clicks on the sign in button
    Then User should be logged in successfully

  Scenario: Assign and Unassign Learners to a Batch
    Given User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the user dashboard page
    When User clicks on the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User expands the 'Category' dropdown
    And User selects 'EC' from the Category dropdown
    And User expands the 'selected category' dropdown
    And User selects 'QA' from the selected category dropdown
    Then User should see the assigned learners count
    When User unassigns a learner from the filtered list
    Then User should see the updated assigned learners count