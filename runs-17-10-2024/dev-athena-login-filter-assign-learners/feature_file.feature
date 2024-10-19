Feature: Manage Courses and Assign Learners on https://dev-athena.geminisolutions.com/login
  As an admin user, I want to manage courses, batches, and assign learners

  Background: User Authentication
    Given User is on the login page
    When User enters email 'test1234@gmail.com'
    And User enters password 'test@123'
    And User clicks on 'sign in' button

  Scenario: Assign Learners to a Batch
    Given User is on the user dashboard
    When User selects 'Manage Courses' from the sidebar
    And User selects 'Batches' from the sidebar
    Then User should be redirected to the batches page
    When User clicks on the actions icon for the 'dummy' record
    And User selects 'Assign Learners' from the actions dropdown
    Then User should be redirected to the assign learners page
    When User gets the assigned learners count
    And User expands the 'Category' dropdown
    And User selects 'EC' from the Category dropdown
    And User expands the 'selected category' dropdown
    And User selects 'QA' from the selected category dropdown
    Then User should see records filtered by category 'EC' and subcategory 'QA'