#Author: oloritaiwo@gmail.com


@appium
Feature: proceed from main movie list to details screen


  Scenario: Verify can user proceed from main movie list to details screen
    Given i launch the app
  When i click on a movie to view detail screen
    Then i validate i am able to proceed to and view details page of a movie
