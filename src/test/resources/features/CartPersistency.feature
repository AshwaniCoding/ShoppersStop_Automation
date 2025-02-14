@android @web
Feature: Validate Cart Persistence Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website

  Scenario: Verify cart items persist after logging out and logging in
    When user click on my account page link
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website
    When user search for a product "product.name"
    And click on the first product
    Then verify user is on product details page
    When user adds a product to the cart
    And user navigate to my cart page
    Then verify user is on my cart page
    And verify product is added to cart
    When user navigate to home page
    And user click on my account page link
    And click on logout button
    Then verify user is successfully logged out the application
    When user log in again with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website
    When user navigate to my cart page
    Then verify the product added to the cart is still present after login

  Scenario: Verify cart is cleared after removing all items
    When user adds multiple products to the cart
    And user navigate to my cart page
    Then verify user is on my cart page
    When user removes all items from the cart
    Then verify the cart is empty