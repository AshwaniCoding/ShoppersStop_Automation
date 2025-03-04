package com.automation.steps.ui;

import io.cucumber.java.en.Then;

public class WishlistPageSteps extends BaseSteps {

    @Then("verify the product appears in the wishlist")
    public void verifyTheProductAppearsInTheWishlist() {
        wishlistPage.verifyTheProductAppearsInTheWishlist();
    }

    @Then("verify the product is removed from the wishlist")
    public void verifyTheProductIsRemovedFromTheWishlist() {
        wishlistPage.verifyTheProductIsRemovedFromTheWishlist();
    }
}
