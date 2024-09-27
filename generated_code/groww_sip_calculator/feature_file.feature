Feature: SIP Calculator on Groww
  As a user
  I want to use the SIP calculator on Groww's website
  So that I can estimate my investment returns

  Scenario: Calculate future values with valid inputs
    Given user is on Groww's SIP calculator webpage
    When the user enters "5000" into the "Monthly investment" field
    And the user enters "10" into the "Time period" field
    And the user enters "12" into the "Expected return rate (p.a)" field
    Then the future values such as Investment amount, Est. returns, and Total value of the investment are displayed