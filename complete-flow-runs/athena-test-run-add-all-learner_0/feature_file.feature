Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com
  As an admin user, I want to manage courses, batches, and assign learners

  Background: User Authentication
    Given User is on the login page
    When User types email 'test123@gmail.com'
    And User types password 'test@123'
    And User clicks 'Sign In' button

  Scenario: Assign Learners to a Batch
    Given User is on the user dashboard
    When User selects 'Manage Courses' from sidebar
    And User selects 'Batches' from sidebar
    Then User should be redirected to the batches page
    When User clicks actions icon of record 'dummy'
    And User selects 'Assign Learners' from actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the initial assigned learners count
    And User selects an unassigned learner from current page
    And User goes to the next page
    And User selects an unassigned learner
    And User clicks 'Assign Selected' button
    And User confirms assignment by clicking 'Yes' button
    Then User should validate the count after assigning learners from multiple pages