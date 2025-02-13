package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomeSteps extends BaseSteps {


    AndroidHomePage androidHomePage = new AndroidHomePage();

    @Given("user open application or website")
    public void userOpenApplicationOrWebsite() {
        //Have to change the method name cause website doesnt have a 'DontAllow' button
        androidHomePage.isHomePageDisplayed();
    }

    @Then("user searches for {string}")
    public void userSearchesFor(String item) {
        androidHomePage.searchFor(item);
    }

    @Then("verify user is on home page of application or website")
    public void verifyUserIsOnHomePageOfApplicationOrWebsite() {
        androidHomePage.isHomePageDisplayed();
    }

    @And("enter the one time password")
    public void enterTheOneTimePassword() {

    }

    @Then("verify user is successfully logged in the application or website")
    public void verifyUserIsSuccessfullyLoggedInTheApplicationOrWebsite() {

    }

    @When("user click on my account page link")
    public void userClickOnMyAccountPageLink() {
        
    }

    @Then("verify user is successfully logged out the application")
    public void verifyUserIsSuccessfullyLoggedOutTheApplication() {

    }

    @When("user navigate to my cart page")
    public void userNavigateToMyCartPage() {

    }

    @When("user navigate to home page")
    public void userNavigateToHomePage() {

    }

    @When("user search for a product {string}")
    public void userSearchForAProduct(String arg0) {
    }
}
