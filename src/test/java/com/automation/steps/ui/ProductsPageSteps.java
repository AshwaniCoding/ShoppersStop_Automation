package com.automation.steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductsPageSteps extends BaseSteps {

    @And("user sets desired filters")
    public void userSetsDesiredFilters() {
    }

    @When("user click on the first product")
    public void userClickOnTheFirstProduct() {
        productsPage.clickOnTheFirstProduct();
    }

    @Then("verify the search results are relevant to {string}")
    public void verifyTheSearchResultsAreRelevantTo(String productName) {
        // It should be boolean because we are verifying so check the method and implement again
        // Also remove the method verifySearchResultsAreRelevant
        // Implement the correct logic
        //productsPage.verifySearchResultsAreRelevant(productName);
        Assert.assertTrue(productsPage.isSearchResultsAreRelevant(productName));
    }

    @Then("verify user is on products page")
    public void verifyUserIsOnProductsPage() {
        Assert.assertTrue(productsPage.isProductPageDisplayed());
    }

    @When("user selects price low to high from the sort dropdown")
    public void userSelectsPriceLowToHighFromTheSortDropdown() {
        productsPage.selectLowToHighSort();
    }

    @Then("verify the products are sorted from low to high price")
    public void verifyTheProductsAreSortedFromLowToHighPrice() {
        productsPage.isPriceSortedFromLowToHigh();
    }

    @When("user selects price high to low from the sort dropdown")
    public void userSelectsPriceHighToLowFromTheSortDropdown() {
        productsPage.selectHighToLowSort();
    }

    @Then("verify the products are sorted from high to low price")
    public void verifyTheProductsAreSortedFromHighToLowPrice() {
        productsPage.isPriceSortedFromHighToLow();
    }

    @When("user apply filter by brand with value {string}")
    public void userApplyFilterByBrandWithValue(String filterBrandName) {
        productsPage.applyFilterByBrandWithValue(filterBrandName);
    }

    @Then("verify user get results with only products from the specified brand {string}")
    public void verifyUserGetResultsWithOnlyProductsFromTheSpecifiedBrand(String filterBrandName) {
        productsPage.isBrandFilterAppliedOnProducts(filterBrandName);
    }

    @When("user apply filter by gender with value {string}")
    public void userApplyFilterByGenderWithValue(String filterGender) {
        productsPage.applyFilterByGenderWithValue(filterGender);
    }

    @Then("verify user get results with only products from the specified gender {string}")
    public void verifyUserGetResultsWithOnlyProductsFromTheSpecifiedGender(String filterGender) {
        productsPage.isGenderFilterAppliedOnProducts(filterGender);
    }

    @When("user selects the price range filter {string}")
    public void userSelectsThePriceRangeFilter(String priceRange) {
        productsPage.applyFilterByPriceRange(priceRange);
    }

    @Then("verify user get results with only products priced between {string}")
    public void verifyUserGetResultsWithOnlyProductsPricedBetween(String priceRange) {
        productsPage.isPriceFilterAppliedOnProducts(priceRange);
    }
}
