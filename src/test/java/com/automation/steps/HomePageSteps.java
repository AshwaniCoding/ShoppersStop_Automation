package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class HomePageSteps extends BaseSteps {


    @Given("user open application or website")
    public void userOpenApplicationOrWebsite() {
        homePage.openApplication();
    }

    @Then("user searches for {string}")
    public void userSearchesFor(String item) {

    }

    @Then("verify user is on home page of application or website")
    public void verifyUserIsOnHomePageOfApplicationOrWebsite() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @And("enter the one time password")
    public void enterTheOneTimePassword() {
        loginPage.enterOneTimePassword();
    }

    @Then("verify user is successfully logged in the application or website")
    public void verifyUserIsSuccessfullyLoggedInTheApplicationOrWebsite() {
        Assert.assertTrue(myAccountPage.isUserLoggedIn());
    }

    @When("user click on my account page link")
    public void userClickOnMyAccountPageLink() {
        homePage.clickOnMyAccountLink();
    }

    @Then("verify user is successfully logged out the application")
    public void verifyUserIsSuccessfullyLoggedOutTheApplication() {

    }

    @When("user navigates to my cart page")
    public void userNavigatesToMyCartPage() {

    }

    @When("user navigate to home page")
    public void userNavigateToHomePage() {

    }

    @When("user search for a product {string}")
    public void userSearchForAProduct(String arg0) {
    }

    @When("user navigates to wishlist page")
    public void userNavigatesToWishlistPage() {
    }

    @When("user navigates to the previous page")
    public void userNavigatesToThePreviousPage() {
    }
}
