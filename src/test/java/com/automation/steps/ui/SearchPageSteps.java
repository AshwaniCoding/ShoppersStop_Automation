package com.automation.steps.ui;

import io.cucumber.java.en.And;

public class SearchPageSteps extends BaseSteps {

    @And("clicks the search button")
    public void clicksTheSearchButton() {
        homePage.clickOnSearchBtn();

    }

}
