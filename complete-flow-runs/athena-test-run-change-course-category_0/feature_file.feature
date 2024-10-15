Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com/login
  As an admin user, I want to manage courses, batches, and assign learners

  Background: User Authentication
    Given User is on the login page
    When User enters email 'test123@gmail.com' in the email input field
    And User enters password 'test@123' in the password input field
    And User clicks on the 'sign in' button
    Then User should be logged in successfully

  Scenario: Assign Learners to a Batch
    Given User is on the dashboard page
    When User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    And User clicks on the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page

    When User expands the 'Category' dropdown
    And User selects 'EC' from the Category dropdown
    And User expands the 'selected category' dropdown
    And User selects 'QA' from the selected category dropdown
    Then User should see records filtered by category 'EC' and subcategory 'QA'

    And User should see the assigned learners count