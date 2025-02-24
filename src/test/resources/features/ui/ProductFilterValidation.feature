@android @web
Feature: Validate Filter Functionality for Search

  Background:
    Given user open application or website
    Then verify user is on home page of application or website

  Scenario: Verify user can apply filter by brand
    When user search for a product "product-name"
    And user click on search button
    Then verify user is on products page
    When user apply filter by brand with value "filter.brand.name"
    Then verify user get results with only products from the specified brand "filter.brand.name"

  Scenario: Verify user can apply filter by gender
    When user search for a product "product-name"
    And user click on search button
    Then verify user is on products page
    When user apply filter by gender with value "filter.gender"
    Then verify user get results with only products from the specified gender "filter.gender"

  Scenario: Verify user can filter products by price range
    When user search for a product "product-name"
    And user click on search button
    Then verify user is on products page
    When user selects the price range filter "₹500-1000"
    Then verify user get results with only products priced between "₹500-1000"




