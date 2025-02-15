package com.automation.steps;

import com.automation.pages.android.AndroidProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPageSteps {
    AndroidProductsPage androidProductsPage = new AndroidProductsPage();
    @And("user sets desired filters")
    public void userSetsDesiredFilters() {
        androidProductsPage.chooseFilters();
    }

    @And("click on the first product")
    public void clickOnTheFirstProduct() {
    }

    @When("user adds multiple products to the cart")
    public void userAddsMultipleProductsToTheCart() {
    }

    @Then("verify the search results are relevant to {string}")
    public void verifyTheSearchResultsAreRelevantTo(String productName) {
        androidProductsPage.verifySearchResultsAreRelevant(productName);
    }
}
