@android @web
Feature: Validate Sort Functionality for Products

  Background:
    Given user open application or website
    Then verify user is on home page of application or website

  Scenario: Sort products from low to high
    When user search for a product "product.name.secondary"
    And user click on search button
    Then verify user is on products page
    When user selects price low to high from the sort dropdown
    Then verify the products are sorted from low to high price

  Scenario: Sort products from high to low
    When user search for a product "product.name.secondary"
    And user click on search button
    Then verify user is on products page
    When user selects price high to low from the sort dropdown
    Then verify the products are sorted from high to low price