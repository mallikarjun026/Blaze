Feature: Login to HRM Application

  Background:
    Given user loads data "./DataFiles/TestData.xlsx"
    Given user launches url "https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm" on browser "chrome"
  @demo @Test_Id_Login
Scenario: Login with valid credentials

    When users enters text "#DataOne" using locator type "name" and value "firstname"
    And user waits for "20" seconds
