package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.utils.ConfigReader;
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
        Assert.assertTrue(homePage.isUserLoggedOut());
    }

    @When("user navigates to my cart page")
    public void userNavigatesToMyCartPage() {
        productDetailsPage.clickOnCartLink();
    }

    @When("user navigate to home page")
    public void userNavigateToHomePage() {
        homePage.clickOnHomePageLink();
    }

    @When("user search for a product {string}")
    public void userSearchForAProduct(String productName) {
        if (productName.equals("product.name")) {
            productName = ConfigReader.getConfigValue(productName);
        }
        homePage.searchForProduct(productName);
    }

    @And("user click on search button")
    public void userClickOnSearchButton() {
        homePage.clickOnSearchBtn();
    }

    @When("user navigates to wishlist page")
    public void userNavigatesToWishlistPage() {
    }

    @When("user navigates to the previous page")
    public void userNavigatesToThePreviousPage() {
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        homePage.clickOnLoginBtn();
        myAccountPage.clickOnLoginBtn();
    }
}
