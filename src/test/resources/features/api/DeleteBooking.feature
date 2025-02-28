@api
Feature: Validate Delete Booking Endpoint

  Background:
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_booking.json"
    When user performs post call
    Then verify status code is 200
    And verify response body has field "bookingid"
    And verify the "booking.firstname" in the response body is "Ashwani"
    And store the "bookingid" into "stored.booking.id"

    Given user wants to call "/auth" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_token.json"
    When user performs post call
    Then verify status code is 200
    And verify response body has field "token"
    And store the "token" into "auth.token"

  Scenario: Verify user can delete a booking by ID
    Given user wants to call "/booking/{id}" end point
    And set header "Content-Type" to "application/json"
    And set header "Cookie" to "token=<auth.token>"
    And set path parameter "id" to "stored.booking.id"
    When user performs delete call
    Then verify status code is 201
    When user performs get call
    Then verify status code is 404
    