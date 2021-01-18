@PopUpWindow
Feature: Check popupwindow page
  Scenario:
    Given User is on Popup Windows page
    When click on launch window button and new window launches
    And enter text on input box and click submit
    And click on Proceed button
    Then User moves to Cookie Handling page