
@FrameDungeon
Feature: Check FrameDungeon page
  Scenario:
    Given User is on FrameDungeon page
    When Repaint Box 2 till Box 1 and Box 2 have the same colour
    And Click on proceed button
    Then User moves to Drag Around Page