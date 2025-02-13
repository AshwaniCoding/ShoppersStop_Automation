Feature: Validate Login Functionality

  Scenario: Verify user can login with valid credentials
    Given user open application
    Then verify user is on home page
    When user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application