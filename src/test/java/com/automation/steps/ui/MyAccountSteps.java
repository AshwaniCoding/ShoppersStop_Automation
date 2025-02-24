package com.automation.steps.ui;

import io.cucumber.java.en.And;

public class MyAccountSteps extends BaseSteps{
    @And("click on logout button")
    public void clickOnLogoutButton() {
        myAccountPage.clickOnLogoutButton();
    }

    @And("click on my profile link")
    public void clickOnMyProfileLink() {
        myAccountPage.clickOnMyProfileLink();
    }
}
