Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com/login
  As an admin user, I want to manage courses, batches, and assign learners

  Background:
    Given User is on the login page
    When User enters email 'test123@gmail.com' in the email input field
    And User enters password 'test@123' in the password input field
    And User clicks on the 'sign in' button

  Scenario: Assign Learners to a Batch and Filter by Status
    Given User is on the user dashboard
    When User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the batches page
    When User clicks on the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the assigned learners count
    And User expands the 'Status' dropdown
    And User selects 'Assigned' from the Status dropdown
    Then User should see records filtered by status 'Assigned'