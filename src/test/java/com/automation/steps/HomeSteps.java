package com.automation.steps;

import com.automation.pages.android.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeSteps extends BaseSteps{
    HomePage homePage = new HomePage();
    @Given("user open application")
    public void userOpenApplication() {
        homePage.clickOnDontAllow();

    }


    @Then("user searches for {string}")
    public void userSearchesFor(String item) {
        homePage.searchFor(item);
    }
}
