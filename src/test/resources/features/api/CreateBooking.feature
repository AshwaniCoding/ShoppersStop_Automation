@api
Feature: Validate Create Booking Endpoint

  Background:
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"

  Scenario: Verify user can successfully create a new booking with valid data
    And set request body from file "create_booking.json" using pojo "CreateBookingRequestPojo"
    When user performs post call
    Then verify status code is 200
    And verify response schema is "create_booking_response_schema.json"
    And verify response body has field "bookingid"
    And store the "bookingid" into "stored.booking.id"
    And verify the "booking.firstname" in the response body is "Ashwani"
    Given user wants to call "/booking/{id}" end point
    And set header "Content-Type" to "application/json"
    And set path parameter "id" to "stored.booking.id"
    When user performs get call
    Then verify status code is 200
    And verify response body matches request body