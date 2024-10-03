Feature: Access Card Management on https://mymis.geminisolutions.com

Background:
  Given User is on the login page
  When User enters user id 'webadmin' in the username field
  And User enters password 'Gemini@123' in the password field
  And User clicks on the login button
  Then User should be redirected to the homepage

Scenario: Manage Access Cardg and Navigate Pages
  Given User is on the homepae
  When User navigates to 'Access Card Management'
  And User clicks on 'Manage Access Card'
  Then User should be redirected to the Access Card Management page
  When User selects '25' from the record selection dropdown
  And User clicks on the 'Next' button
  And User clicks on the 'Previous' button
  Then User should remain on the Access Card Management page