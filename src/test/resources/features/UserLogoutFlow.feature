@android @web
Feature: Validate Logout Functionality

  Background:
    Given user open application or website
    #Then verify user is on home page of application or website
    When user click on my account page link
    And user click on login button
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    #Then verify user is successfully logged in the application or website

  Scenario: Verify user can logout
    When user click on my account page link
    And click on logout button
    Then verify user is successfully logged out the application
