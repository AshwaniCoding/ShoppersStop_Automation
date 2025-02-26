package com.automation.steps.common;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    @Before("@web or @android")
    public void setUpForWebOrAndroid() {
        try {
            updateReportPath(System.getProperty("platform"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigReader.initReader();
        DriverManager.createDriver();
    }

    @Before("@api")
    public void setUpForAPI() {
        try {
            updateReportPath("api");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigReader.initReader();
        RestAssured.baseURI = ConfigReader.getConfigValue("api.url");
        RestAssured.useRelaxedHTTPSValidation();
    }

    public void updateReportPath(String folderName) throws Exception {
        FileInputStream inputStream = new FileInputStream("src/test/resources/extent.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        // Generate dynamic path for the report based on timestamp
        String reportPath = "ExtentReport/" + folderName + "/report.html";

        // Set the new report path in the properties
        properties.setProperty("extent.reporter.spark.out", reportPath);


        FileOutputStream outputStream = new FileOutputStream("src/test/resources/extent.properties");
        properties.store(outputStream, null);
        outputStream.close();
    }

    @After("@web or @android")
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }
}
