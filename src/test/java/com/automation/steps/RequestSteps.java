package com.automation.steps;

import com.automation.pojo.CreateTokenPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredManager;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.lang.reflect.Field;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        RestAssuredManager.clear();
        RestAssuredManager.setEndPoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
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

        Field field;

        field = CreateTokenPojo.class.getDeclaredField("username");
        field.setAccessible(true);
        field.set(pojo, username);
        field = CreateTokenPojo.class.getDeclaredField("password");
        field.setAccessible(true);
        field.set(pojo, password);

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
}
