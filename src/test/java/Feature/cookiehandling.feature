@CookieHandling
Feature: Check Cookie Handling page
  Scenario:
    Given User is on Cookie Handling page
    When Click on Generate Token button
    And Add the Token to the Cookie
    And Click Proceed
    Then User moves to the End page