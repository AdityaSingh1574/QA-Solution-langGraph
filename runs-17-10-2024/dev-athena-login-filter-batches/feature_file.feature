Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com/login
  As an admin user, I want to manage courses, assign learners, and filter assigned learners

  Background:
    Given User is on the login page
    When User enters email 'test1234@gmail.com' in the email field
    And User enters password 'test@123' in the password field
    And User clicks the 'sign in' button

  Scenario: Assign Learners to a Course and Filter Assigned Learners
    Given User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    When User clicks the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page

    When User gets the assigned learners count
    And User expands the 'Status' dropdown
    And User selects 'Assigned' from the dropdown
    Then User should see records filtered by status 'Assigned'