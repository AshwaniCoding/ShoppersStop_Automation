package com.automation.steps.api;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
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

    @And("store the {string} into {string}")
    public void storeTheFromTheResponse(String jsonPath, String key) {
        ConfigReader.setConfigValue(key, RestAssuredManager.getResponseFieldValue(jsonPath));
    }

    @And("verify the {string} in the response body is {string}")
    public void verifyTheInTheResponseBodyIs(String jsonPath, String fieldValue) {
        Assert.assertTrue(RestAssuredManager.isFieldAvailableWithValue(jsonPath, fieldValue));
    }

    @And("verify response schema is {string}")
    public void verifyResponseSchemaIs(String fileName) {
        Response response = RestAssuredManager.getResponse();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data/" + fileName));
    }

    @And("verify response body matches request body")
    public void verifyResponseBodyMatchesRequestBody() {
        Object requestPojo = ConfigReader.getObject("request.pojo");
        Object responsePojo = RestAssuredManager.convertJsonToObjectFromFile(RestAssuredManager.getResponse().asString(), requestPojo.getClass());
        Assert.assertEquals(requestPojo, responsePojo);
    }
}
