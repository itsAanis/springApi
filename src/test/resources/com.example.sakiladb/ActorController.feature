Feature: get Actor

  Scenario: request to return actor by Id
    Given an actor with the provided Id 1 exists
    When a get request is made for the actor with ID 1
    Then an Actor is returned