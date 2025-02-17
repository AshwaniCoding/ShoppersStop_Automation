package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsSteps extends BaseSteps {
    @Then("verify user is on product details page")
    public void verifyUserIsOnProductDetailsPage() {
        productDetailsPage.verifyUserIsOnProductDetailsPage();

    }

    @When("user adds a product to the cart")
    public void userAddsAProductToTheCart() {
    }

    @When("user clicks on the add to wishlist button")
    public void userClicksOnTheAddToWishlistButton() {
        productDetailsPage.userClicksOnTheAddToWishlistButton();

    }

    @Then("verify a confirmation message {string} is displayed")
    public void verifyAConfirmationMessageIsDisplayed(String confirmationMessage) {
        productDetailsPage.verifyAConfirmationMessageIsDisplayed();
    }

    @And("user clicks on the add to wishlist button again")
    public void userClicksOnTheAddToWishlistButtonAgain() {

    }

    @Then("verify a message {string} is displayed")
    public void verifyAMessageIsDisplayed(String confirmationMessage) {
        productDetailsPage.verifyAMessageIsDisplayed();
    }

    @When("user navigates to wishlist page")
    public void userNavigatesToWishlistPage() {
        productDetailsPage.userNavigatesToWishlistPage();
    }

    @When("user navigates to the previous page")
    public void userNavigatesToThePreviousPage() {
        productDetailsPage.userNavigatesToThePreviousPage();
    }
}
