Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com
  As an admin user, I want to manage courses, batches, and assign learners

  Background:
    Given User is on the login page
    When User enters email 'test1234@gmail.com' and password 'test@123'
    And User clicks on 'sign in' button

  Scenario: Assign Learner to a Batch
    Given User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the user dashboard page
    When User clicks on the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the current assigned learners count
    And User assigns a learner with email 'egwuyrx@gmail.com'
    And User clicks on 'assign selected' button
    And User confirms assignment by clicking 'Yes' button
    Then User should validate the count after assigning