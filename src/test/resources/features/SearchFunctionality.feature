@android @web
Feature: Validate Search Functionality for Products

  Background:
    Given user open application or website
    Then verify user is on home page of application or website

  Scenario Outline: Test search functionality for products
    When user search for a product "<product.name>"
    And clicks the search button
    Then verify the search results are relevant to "<product.name>"

    Examples:
      | product.name |
      | T Shirt      |
      | Watch        |