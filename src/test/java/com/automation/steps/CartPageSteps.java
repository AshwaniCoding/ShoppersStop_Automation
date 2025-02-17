package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartPageSteps extends BaseSteps {

    @Then("verify the product added to the cart is still present after login")
    public void verifyTheProductAddedToTheCartIsStillPresentAfterLogin() {
        Assert.assertTrue(cartPage.isProductPresentInCart());
    }

    @Then("verify product is added to cart")
    public void verifyProductIsAddedToCart() {
        Assert.assertTrue(cartPage.isProductPresentInCart());
    }

    @Then("verify user is on my cart page")
    public void verifyUserIsOnMyCartPage() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @Then("verify the cart is empty")
    public void verifyTheCartIsEmpty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @When("user removes all items from the cart")
    public void userRemovesAllItemsFromTheCart() {
        cartPage.removeAllItems();
    }

}
