Feature: Competency Form Navigation and Search on MyMIS
  As a user, I want to navigate to the competency form and perform a search

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Navigate to Competency Form and Perform Search
    Given User is on the MyMIS homepage
    When User navigates to competency form under appraisal management
    Then User should be redirected to the Competency Form page
    When User selects appraisal cycle "April 2022" from dropdown
    And User selects location "Canan Tower" from dropdown
    And User selects Vertical "Gemini solutions" from dropdown
    And User selects Designation "Senior Software Engineer L2" from dropdown
    And User selects Designation "Senior Software Engineer L1" from dropdown
    And User clicks search button
    Then User should see the search results