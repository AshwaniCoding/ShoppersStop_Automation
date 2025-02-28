@api
Feature: Validate Get Booking Endpoint

  Scenario: Verify user can retrieve all booking IDs
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200
    And verify response body has field "bookingid"

  Scenario: Verify user can retrieve booking details by ID
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200
    And store the "[0].bookingid" into "stored.booking.id"

    Given user wants to call "/booking/{id}" end point
    And set header "Content-Type" to "application/json"
    And set path parameter "id" to "stored.booking.id"
    When user performs get call
    Then verify status code is 200
    And verify response body has field "firstname"

  Scenario Outline: Verify user is able to retrieve booking IDs using filters
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    And set query parameter "<field.name>" to "<field.value>"
    When user performs get call
    Then verify status code is 200
    And store the "[0].bookingid" into "stored.booking.id"

    Given user wants to call "/booking/{id}" end point
    And set header "Content-Type" to "application/json"
    And set path parameter "id" to "stored.booking.id"
    When user performs get call
    Then verify status code is 200
    And verify the "<field.name>" in the response body is "<field.value>"

    Examples:
      | field.name  | field.value |
      | firstname   | Josh        |
      | depositpaid | true        |

