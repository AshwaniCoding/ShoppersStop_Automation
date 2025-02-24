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
}
