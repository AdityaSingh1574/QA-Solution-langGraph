Feature: Leave Management on MyMIS
  As a user, I want to update leave management for an employee

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@123"
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Apply for Leave for an Employee
    Given User is on the MyMIS homepage
    When User navigates to update on leave management
    Then User should be redirected to the Leave Management Update page
    When User selects the first option from Financial year dropdown
    And User selects employee status as Active
    And User searches for employee "123 User"
    And User selects employee "123 User"
    And User clicks on "Apply on leave" button
    Then User should be redirected to the Leave Application page