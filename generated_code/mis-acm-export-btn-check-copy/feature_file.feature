Feature: Manage Access Card Export Options
  As a user
  I want to export access card information in various formats
  So that I can review and analyze the data efficiently

Scenario: Export Access Cards Information
  Given the user is on the "Access Card Management" page
  When user navigates to "Manage Access Card" section
  And User clicks on the export button
  Then User should see export options

  When User clicks on Copy option
  Then the access card information should be copied to clipboard

  When User clicks on Excel option
  Then an Excel file named "Access Cards" should be downloaded
  And User verifies if Excel "Access Cards" file got downloaded successfully