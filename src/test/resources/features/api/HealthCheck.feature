@api
Feature: Validate Health Check Endpoint

  Scenario: Verify user can perform a health check to verify if the API is up
    Given user wants to call "/ping" end point
    When user performs get call
    Then verify status code is 201