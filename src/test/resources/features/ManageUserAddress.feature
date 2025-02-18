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
    And click on add address button
    Then verify user is on add address page
    When user enters the new address details
    And click on add address button
    Then verify the address is successfully added

  Scenario: Verify user successfully edits an existing address
    When user click on my account page link
    And click on edit address button
    Then verify user is on edit address page
    When the user updates the address details
    And clicks on the update changes button
    Then verify the address is successfully updated

  Scenario: Verify user successfully deletes a specific address
    When user click on my account page link
    And user navigates to addresses section
    Then verify addresses section is displayed
    When the user clicks on the delete button for the specific address "address.name"
    And click on confirm button
    Then verify the specific address "address.name" is successfully deleted
