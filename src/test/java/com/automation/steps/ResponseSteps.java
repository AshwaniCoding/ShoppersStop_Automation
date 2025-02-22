package com.automation.steps;

import com.automation.utils.RestAssuredManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {
    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredManager.getStatusCode());
    }

    @And("verify response body has field {string}")
    public void verifyResponseBodyHasField(String jsonPath) {
        Assert.assertTrue(RestAssuredManager.isFieldAvailable(jsonPath));
    }

    @And("verify response body has not field {string}")
    public void verifyResponseBodyHasNotField(String jsonPath) {
        Assert.assertFalse(RestAssuredManager.isFieldAvailable(jsonPath));
    }
}
