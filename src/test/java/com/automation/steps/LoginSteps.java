package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    @When("user login with a valid phone or email {string}")
    public void userLoginWithAValidPhoneOrEmail(String phoneOrEmail) {

    }

    @Then("verify user receives an error message indicating an invalid email or phone number")
    public void verifyUserReceivesAnErrorMessageIndicatingAnInvalidEmailOrPhoneNumber() {

    }

    @When("user log in again with a valid phone or email {string}")
    public void userLogInAgainWithAValidPhoneOrEmail(String phoneOrEmail) {
    }
}
