Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com/login
  As an admin user, I want to manage courses, batches, and assign learners

  Background:
    Given User is on the login page
    When User types 'test123@gmail.com' in the email field
    And User types 'test@123' in the password field
    And User clicks the 'sign in' button

  Scenario: Assign Learner to a Batch
    Given User is redirected to the user dashboard
    When User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User is redirected to the batches page
    When User clicks the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User is redirected to the assign learners page
    When User gets the current assigned learners count
    And User assigns a learner with email 'egwuyrx@gmail.com'
    And User clicks the 'assign selected' button
    And User confirms assignment by clicking the 'Yes' button
    Then User validates the count after assigning