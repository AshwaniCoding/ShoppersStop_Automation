@android @web
Feature: Validate Cart Persistence Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website
    When user click on my account page link
    And user click on login button
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website
    When user search for a product "product.name"
    And user click on search button
    Then verify user is on products page
    When click on the first product
    Then verify user is on product details page
    When user adds a product to the cart
    Then verify a message "Product added to your cart successfully" is displayed

  Scenario: Verify cart items persist after logging out and logging in
    When user navigates to my cart page
    Then verify user is on my cart page
    And verify product is added to cart
    When user navigate to home page
    And user click on my account page link
    And click on logout button
    Then verify user is successfully logged out the application
    When user click on my account page link
    And user click on login button
    And user log in again with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website
    When user navigates to my cart page
    Then verify the product added to the cart is still present after login

  Scenario: Verify cart is cleared after removing all items
    When user navigates to my cart page
    Then verify user is on my cart page
    When user removes all items from the cart
    Then verify the cart is empty