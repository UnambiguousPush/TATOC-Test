
@DragAround
Feature: Check Drag Around page
  Scenario:
    Given User is on Drag Around page
    When Perform Drag and Drop Action
    And Click proceed button
    Then User moves to Popup Windows Page