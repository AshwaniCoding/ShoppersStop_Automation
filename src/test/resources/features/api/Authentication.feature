@api
Feature: Validate Auth Token Endpoint

  Background:
    Given user wants to call "/auth" end point
    And set header "Content-Type" to "application/json"

  Scenario: Verify user can get an auth token with valid credentials
    And set request body from file "create_token.json"
    When user performs post call
    Then verify status code is 200
    And verify response body has field "token"
    And verify response schema is "create_token_response_schema.json"

  Scenario Outline: Verify user cannot get an auth token with invalid credentials
    And set the request body from file "create_token.json" with "<username>" and "<password>"
    When user performs post call
    Then verify status code is 200
    And verify response body has not field "token"

    Examples:
      | username | password    |
      | admin    | invalid     |
      | Admin    | password123 |
      | admin    | PASSWORD123 |
      | invalid  | invalid123  |