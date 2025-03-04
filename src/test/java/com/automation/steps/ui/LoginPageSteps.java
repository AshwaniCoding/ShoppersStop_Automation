package com.automation.steps.ui;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps extends BaseSteps {

    @When("user login with a valid phone or email {string}")
    public void userLoginWithAValidPhoneOrEmail(String phoneOrEmail) {
        if (phoneOrEmail.equals("phone.or.email")) {
            phoneOrEmail = ConfigReader.getConfigValue(phoneOrEmail);
        }
        loginPage.loginWithPhoneOrEmail(phoneOrEmail);
    }

    @Then("verify user receives an error message indicating an invalid email or phone number")
    public void verifyUserReceivesAnErrorMessageIndicatingAnInvalidEmailOrPhoneNumber() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @When("user log in again with a valid phone or email {string}")
    public void userLogInAgainWithAValidPhoneOrEmail(String phoneOrEmail) {
        loginPage.loginWithPhoneOrEmail(ConfigReader.getConfigValue(phoneOrEmail));
    }
}
