package com.automation.steps;

import com.automation.pages.android.AndroidProductsPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductsPageSteps extends BaseSteps {

    @And("user sets desired filters")
    public void userSetsDesiredFilters() {

    }

    @When("click on the first product")
    public void clickOnTheFirstProduct() {
        productsPage.clickOnFirstProduct();
    }

    @Then("verify the search results are relevant to {string}")
    public void verifyTheSearchResultsAreRelevantTo(String productName) {
        productsPage.verifySearchResultsAreRelevant(productName);
    }

    @Then("verify user is on products page")
    public void verifyUserIsOnProductsPage() {
        Assert.assertTrue(productsPage.isProductPageDisplayed());
    }
}
