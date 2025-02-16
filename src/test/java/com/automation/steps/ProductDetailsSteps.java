package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailsSteps extends BaseSteps {
    @Then("verify user is on product details page")
    public void verifyUserIsOnProductDetailsPage() {
        Assert.assertTrue(productDetailsPage.isProductDetailsPageDisplayed());
    }

    @When("user adds a product to the cart")
    public void userAddsAProductToTheCart() {
        productDetailsPage.saveProductName();
        productDetailsPage.clickOnAddToCartBtn();
    }

    @When("user clicks on the add to wishlist button")
    public void userClicksOnTheAddToWishlistButton() {

    }

    @And("user clicks on the add to wishlist button again")
    public void userClicksOnTheAddToWishlistButtonAgain() {

    }

    @Then("verify a message {string} is displayed")
    public void verifyAMessageIsDisplayed(String message) {
        Assert.assertTrue(homePage.isMessageDisplayed(message));
    }

}
