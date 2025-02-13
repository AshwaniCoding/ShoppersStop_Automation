package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomeSteps extends BaseSteps{


    AndroidHomePage androidHomePage = new AndroidHomePage();

    @Given("user open application")
    public void userOpenApplication() {
        //Have to change the method name cause website doesnt have a 'DontAllow' button
        androidHomePage.isHomePageDisplayed();
    }

    @Then("user searches for {string}")
    public void userSearchesFor(String item) {
        androidHomePage.searchFor(item);
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        androidHomePage.isHomePageDisplayed();
    }

    @When("user login with a valid phone or email {string}")
    public void userLoginWithAValidPhoneOrEmail(String arg0) {

    }

    @And("enter the one time password")
    public void enterTheOneTimePassword() {

    }

    @Then("verify user is successfully logged in the application")
    public void verifyUserIsSuccessfullyLoggedInTheApplication() {

    }

}
