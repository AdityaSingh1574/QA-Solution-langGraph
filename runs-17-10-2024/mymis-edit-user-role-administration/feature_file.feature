Feature: User Role Management on MIS Portal
  As an administrator
  I want to manage user roles
  So that I can control access permissions

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MIS homepage

  Scenario: Edit User Role
    Given User navigates to the User Role section under Administrations
    And User should be redirected to the User Role page
    When User selects the user "123 User" to edit
    And User selects "MIS Administrator" from the role dropdown
    And User clicks on the update button
    Then The user role should be updated successfully