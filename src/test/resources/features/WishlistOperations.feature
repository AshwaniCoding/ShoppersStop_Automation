@android @web
Feature: Add Items to Wishlist Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website
    When user click on my account page link
    And user login with a valid phone or email "phone.or.email"
    And enter the one time password
    Then verify user is successfully logged in the application or website

  Scenario: Verify user can add product to the wishlist
    When user search for a product "product.name"
    Then clicks the search button
    And click on the first product
    Then verify user is on product details page
    When user clicks on the add to wishlist button
    Then verify a confirmation message "Product added to the wishlist." is displayed
    When user navigates to wishlist page
    Then verify the product appears in the wishlist

  Scenario: Verify product is removed from wishlist when clicked twice
    When user search for a product "product.name"
    Then clicks the search button
    And click on the first product
    Then verify user is on product details page
    When user clicks on the add to wishlist button
    Then verify a confirmation message "Product added to the wishlist." is displayed
    When user navigates to wishlist page
    Then verify the product appears in the wishlist
    When user navigates to the previous page
    And user clicks on the add to wishlist button again
    Then verify a message "Removed from your Wishlist" is displayed
    When user navigates to wishlist page
    Then verify the product is removed from the wishlist

