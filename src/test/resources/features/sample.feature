Feature: Login to HRM Application

  Background:
    Given user loads data "./DataFiles/TestData.xlsx"
    Given user launches url "https://www.google.com/" on browser "chrome"

  @demo @Test_Id_Login
Scenario: Login with valid credentials

    When users enters text "#DataOne" using locator type "id" and value "name"
