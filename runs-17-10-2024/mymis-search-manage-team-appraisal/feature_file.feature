Feature: Manage Team Appraisal on MyMIS
  As a user, I want to access and manage team appraisal forms

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Access and Filter Team Appraisal Form
    Given User navigates to Manage Team appraisal form under appraisal management
    Then User should be redirected to the Manage Team Appraisal page
    When User selects appraisal cycle "April 2022" from dropdown
    And User selects location "Canan Tower" from dropdown
    And User selects Vertical "Gemini solutions" from dropdown
    And User selects Department "Human Resource" from dropdown
    And User clicks search button
    Then User should see filtered results for team appraisal