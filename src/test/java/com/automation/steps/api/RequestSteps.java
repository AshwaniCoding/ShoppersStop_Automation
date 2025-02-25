package com.automation.steps.api;

import com.automation.pojo.CreateTokenPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredManager;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        RestAssuredManager.clear();
        RestAssuredManager.setEndPoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
        if (value.contains("auth.token")) {
            value = "token=" + ConfigReader.getConfigValue("auth.token");
        }
        RestAssuredManager.setHeader(key, value);
    }

    @And("set request body from file {string}")
    public void setRequestBodyFromFile(String fileName) {
        RestAssuredManager.setBody(fileName);
    }

    @When("user performs post call")
    public void userPerformsPostCall() {
        RestAssuredManager.post();
    }


    @And("set the request body from file {string} with {string} and {string}")
    public void setTheRequestBodyFromFileWithAnd(String fileName, String username, String password) throws JsonProcessingException, NoSuchFieldException, IllegalAccessException {

        String content = RestAssuredManager.getDataFromJsonFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateTokenPojo pojo = objectMapper.readValue(content, CreateTokenPojo.class);

        pojo.setUsername(username);
        pojo.setPassword(password);

        System.out.println(">>>>>>>>>>>Pojo: " + pojo);
        RestAssuredManager.setBody(pojo);

    }

    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredManager.get();
    }

    @And("set path parameter {string} to {string}")
    public void setPathParameterTo(String pathParam, String value) {
        RestAssuredManager.setPathParameter(pathParam, ConfigReader.getConfigValue(value));
    }

    @And("set query parameter {string} to {string}")
    public void setQueryParameterTo(String parameter, String value) {
        RestAssuredManager.setQueryParameter(parameter, value);
    }

    @When("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredManager.put();
    }

    @When("user performs patch call")
    public void userPerformsPatchCall() {
        RestAssuredManager.patch();
    }

    @When("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredManager.delete();
    }
}
