package com.automation.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredManager {

    static RequestSpecification requestSpecification = RestAssured.given();
    static Response response;
    static String endPoint;

    public static void setEndPoint(String endPoint) {
        RestAssuredManager.endPoint = endPoint;
    }

    public static void setHeader(String key, String value) {
        requestSpecification.header(key, value);
    }

    public static void setBody(String filePath) {
        requestSpecification.body(getDataFromJsonFile(filePath));
    }

    public static void setBody(Object pojo) {
        try {
            requestSpecification.body(pojo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void get() {
        requestSpecification.log().all();
        response = requestSpecification.get(endPoint);
        response.then().log().all();
    }

    public static void post() {
        requestSpecification.log().all();
        response = requestSpecification.post(endPoint);
        response.then().log().all();
    }

    public static void put() {
        requestSpecification.log().all();
        response = requestSpecification.put(endPoint);
        response.then().log().all();
    }

    public static void delete() {
        requestSpecification.log().all();
        response = requestSpecification.delete(endPoint);
        response.then().log().all();
    }

    public static void patch() {
        requestSpecification.log().all();
        response = requestSpecification.patch(endPoint);
        response.then().log().all();
    }

    public static int getStatusCode() {
        return response.getStatusCode();
    }

    public static String getDataFromJsonFile(String fileName) {

        String body;

        try {
            String jsonFolderPath = "src/test/resources/data/";
            Scanner sc = new Scanner(new FileInputStream(jsonFolderPath + fileName));
            body = sc.useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return body;
    }

    public static Response getResponse() {
        return response;
    }

    public static String getResponseFieldValue(String jsonPath) {

        return response.jsonPath().getString(jsonPath);
    }

    public static boolean isFieldAvailable(String jsonPath) {
        try {
            String value = RestAssuredManager.getResponseFieldValue(jsonPath);
            return value != null && !value.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static void setPathParameter(String parameter, String value) {
        requestSpecification.pathParam(parameter, value);
    }

    public static void setQueryParameter(String parameter, String value) {
        requestSpecification.queryParam(parameter, value);
    }

    public static boolean isFieldAvailableWithValue(String fieldName, String fieldValue) {
        try {
            String value = RestAssuredManager.getResponseFieldValue(fieldName);
            return value.equals(fieldValue);
        } catch (Exception e) {
            return false;
        }
    }

    public static void clear() {
        requestSpecification = RestAssured.given();
    }

    public static Object convertJsonToObjectFromFile(String content, Class<?> aClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(content, aClass);
        } catch (Exception e) {
            return null;
        }
    }
}
