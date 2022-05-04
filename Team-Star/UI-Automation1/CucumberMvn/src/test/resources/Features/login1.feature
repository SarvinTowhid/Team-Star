#Author
Feature: Login to Facebook

  Scenario: Login is successful with valid credential
    Given user is on login page
    When user enter usrename
    And user enter password
    Then clicks on login button
    And I capture page title
    Then I close the browser
