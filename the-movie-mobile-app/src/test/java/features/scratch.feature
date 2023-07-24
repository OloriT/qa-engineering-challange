#Author: oloritaiwo@gmail.com


@appium
Feature: filter movies based on year or popularity


  Scenario: Verify user can filter movies based on year or popularity
    Given i launch the app
  When i search for a filter button and enter a search parameter either by year or popularity
    Then i validate it returns valid search result