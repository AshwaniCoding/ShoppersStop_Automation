package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    @Before("@web or @android")
    public void setUpForWebOrAndroid() {
        ConfigReader.initReader();
        DriverManager.createDriver();
    }

    @Before("@api")
    public void setUpForAPI() {
        ConfigReader.initReader();
        RestAssured.baseURI = ConfigReader.getConfigValue("api.url");
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After("@web or @android")
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }
}
