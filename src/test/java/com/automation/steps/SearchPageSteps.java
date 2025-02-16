package com.automation.steps;

import io.cucumber.java.en.And;

public class SearchPageSteps extends BaseSteps {

    @And("clicks the search button")
    public void clicksTheSearchButton() {
        homePage.clickOnSearchButton();

    }

}
