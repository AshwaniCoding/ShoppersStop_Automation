package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsSteps extends BaseSteps {
    @Then("verify user is on product details page")
    public void verifyUserIsOnProductDetailsPage() {
    }

    @When("user adds a product to the cart")
    public void userAddsAProductToTheCart() {
    }

    @When("user clicks on the add to wishlist button")
    public void userClicksOnTheAddToWishlistButton() {

    }

    @Then("verify a confirmation message {string} is displayed")
    public void verifyAConfirmationMessageIsDisplayed(String confirmationMessage) {
    }

    @And("user clicks on the add to wishlist button again")
    public void userClicksOnTheAddToWishlistButtonAgain() {

    }

    @Then("verify a message {string} is displayed")
    public void verifyAMessageIsDisplayed(String confirmationMessage) {
    }
}
