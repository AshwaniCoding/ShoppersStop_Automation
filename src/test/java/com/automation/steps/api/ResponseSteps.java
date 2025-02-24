package com.automation.steps.api;

import com.automation.utils.ConfigReader;
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


    @And("verify response body includes booking IDs where the {string} is {string}")
    public void verifyResponseBodyIncludesBookingIDsWhereTheIs(String fieldName, String fieldValue) {
        Assert.assertTrue(RestAssuredManager.isFieldAvailableWithValue(fieldName, fieldValue));
    }

    @And("store the {string} into {string}")
    public void storeTheFromTheResponse(String jsonPath, String key) {
        ConfigReader.setConfigValue(key, RestAssuredManager.getResponseFieldValue(jsonPath));
    }
}
