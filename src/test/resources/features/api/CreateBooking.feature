@api
Feature: Validate Create Booking Endpoint

  Background:
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"

  Scenario: Verify user can successfully create a new booking with valid data
    And set request body from file "create_booking.json"
    When user performs post call
    Then verify status code is 200
    And verify response body has field "bookingid"
    And verify the "booking.firstname" in the response body is "Ashwani"
