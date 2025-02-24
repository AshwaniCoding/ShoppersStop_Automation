@api
Feature: Validate Booking Details Endpoint

  Background:
    Given user wants to call "/booking/{id}" end point
    And set header "Content-Type" to "application/json"

  Scenario: Verify user can retrieve all booking IDs
    When user performs get call
    Then verify status code is 200
    And verify response body has field "bookingid"

  Scenario: Verify user can retrieve booking details by ID
    And set path parameter "id" to "540"
    When user performs get call
    Then verify status code is 200
    And verify response body has field "firstname"

  Scenario Outline: Verify user is able to retrieve booking IDs using filters
    And set query parameter "<field.name>" to "<field.value>"
    When user performs get call
    Then verify status code is 200
    And store the "[0].bookingid" into "store.booking.id"
    Given user wants to call "/booking/{id}" end point
    And set path parameter "id" to "store.booking.id"
    When user performs get call
    Then verify status code is 200
    And verify response body includes booking IDs where the "<field.name>" is "<field.value>"

    Examples:
      | field.name  | field.value |
      | firstname   | Josh        |
      | depositpaid | true        |

