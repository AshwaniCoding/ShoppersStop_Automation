@android @web
Feature: Validate Add, Edit and Update Address Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website
    When user click on my account page link
    And user click on login button
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website

  Scenario: Verify user successfully adds a new address
    When user click on my account page link
    And click on my profile link
    Then verify user is on my profile page
    When user click on add address link
    Then verify user is on add address section
    When user enters the new address details
    And click on add address button
    Then verify the address is successfully added

  Scenario: Verify user successfully edit specific address
    When user click on my account page link
    And click on my profile link
    Then verify user is on my profile page
    When click on edit address link for the specific address "update.address.name"
    Then verify user is on edit address section
    When user update the address details
    And click on the update changes button
    Then verify the address is successfully updated

  Scenario: Verify user successfully deletes a specific address
    When user click on my account page link
    And click on my profile link
    Then verify user is on my profile page
    When user click on the delete link for the specific address "delete.address.name"
    And click on confirm button
    Then verify the specific address "delete.address.name" is successfully deleted
