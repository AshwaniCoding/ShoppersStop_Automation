@android @web
Feature: Add Items to Wishlist Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website
    When user click on my account page link
    And user click on login button
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website

  Scenario: Verify user can add product to the wishlist
    When user search for a product "product.name.primary"
    And clicks the search button
    Then verify user is on products page
    When user click on the first product
    Then verify user is on product details page
    When user clicks on the add to wishlist button
    And user navigates to wishlist page
    Then verify the product appears in the wishlist

  Scenario: Verify product is removed from wishlist when clicked twice
    When user search for a product "product.name.secondary"
    And clicks the search button
    Then verify user is on products page
    When user click on the first product
    Then verify user is on product details page
    When user clicks on the add to wishlist button
    And user navigates to wishlist page
    Then verify the product appears in the wishlist
    When user navigates to the previous page
    And user clicks on the add to wishlist button again
    And user navigates to wishlist page
    Then verify the product is removed from the wishlist