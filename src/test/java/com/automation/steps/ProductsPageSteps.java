package com.automation.steps;

import com.automation.pages.android.AndroidProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPageSteps extends BaseSteps{
    @And("user sets desired filters")
    public void userSetsDesiredFilters() {
        productPage.chooseFilters();
    }

    @And("click on the first product")
    public void clickOnTheFirstProduct() {
        productPage.clickOnTheFirstProduct();
    }

    @When("user adds multiple products to the cart")
    public void userAddsMultipleProductsToTheCart() {
    }

    @Then("verify the search results are relevant to {string}")
    public void verifyTheSearchResultsAreRelevantTo(String productName) {
        productPage.verifySearchResultsAreRelevant(productName);
    }
}
