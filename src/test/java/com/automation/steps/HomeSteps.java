package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeSteps {
    AndroidHomePage androidHomePage = new AndroidHomePage();
    @Given("user opens application")
    public void userOpensApplication() {
        //Have to change the method name cause website doesnt have a 'DontAllow' button
        androidHomePage.isHomePageDisplayed();

    }


    @Then("user searches for {string}")
    public void userSearchesFor(String item) {
        androidHomePage.searchFor(item);
    }
}
