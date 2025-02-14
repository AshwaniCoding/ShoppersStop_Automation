@android @web
Feature: Validate Login Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website

  Scenario: Verify user can login with valid credentials
    When user click on my account page link
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website

  Scenario Outline: Verify user cannot login with invalid credentials
    When user click on my account page link
    And user login with a valid phone or email "<phone-or-email>"
    Then verify user receives an error message indicating an invalid email or phone number

    Examples:
      | phone-or-email |
      | 1111111111     |
      | 2222222222     |