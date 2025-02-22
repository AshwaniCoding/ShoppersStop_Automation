@android @web
Feature: Validate Product Details Page Functionality

  Background:
    Given user open application or website
    Then verify user is on home page of application or website
    When user search for a product "product.name.primary"
    And user click on search button
    Then verify user is on products page

  Scenario: Verify product name and price are visible
    When user click on the first product
    Then verify user is on product details page
    And verify product name and price are visible

  Scenario: Verify product details are available
    When user click on the first product
    Then verify user is on product details page
    And verify product details are available
