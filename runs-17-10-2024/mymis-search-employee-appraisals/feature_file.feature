Feature: Employee Appraisal Management on https://mymis.geminisolutions.com/Account/Login
  As a user, I want to manage employee appraisals

  Background:
    Given User is on the login page
    When User enters user id as 'webadmin'
    And User enters password as 'Gemini@1234'
    And User clicks on the login button
    Then User should be redirected to the dashboard

  Scenario: Search for Employee Appraisals
    Given User navigates to Employee appraisal under appraisal management
    Then User should be redirected to the appraisal management page
    When User selects appraisal cycle as 'April 2021' from the dropdown
    And User leaves appraisal status as default
    And User leaves Dc manager as default
    And User selects Dc chair as 'Akshi Khattar' from the dropdown
    And User clicks on the search button
    Then User should be redirected to the Employees Appraisal page