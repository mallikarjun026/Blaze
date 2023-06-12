package com.blaze.stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.blaze.manager.BrowserManager;
import com.blaze.scenario.ScenarioDetails;
import com.blaze.utlilities.ReadExcell;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GenericUISteps extends Helper {
    ScenarioDetails sd=null;

    @Given("user loads data {string}")
    public void user_loads_data(String dataSheetPath) {
        ReadExcell.setDataSheetPath(dataSheetPath);
        sd=ScenarioDetails.getScenarioDetailsInstance();
        sd.setScenarioData(ReadExcell.returnTestDataMap("TestCase",sd.getTestID()));
    }
    @Given("user launches url {string} on browser {string}")
    public void user_launches_url_on_browser(String url,String browser) {

        BrowserManager.getInstance().initializeWebdriver(browser);
        WebDriver driver=BrowserManager.getInstance().getDriver();
        if(driver==null)
        {
            System.out.println("driver is null");
        }
        else {
            System.out.println("driver is not null");
        }
        driver.get(url);


    }
    @When("users enters text {string} using locator type {string} and value {string}")
    public void users_enters_text_using_locator_type_and_value(String value, String locatorType, String attributeValue) {
        try {
            value=returnDataForCurrentScenario(value);
            WebElement element=returnWebElement(locatorType,attributeValue);
            element.clear();

            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("some exception occurred "+e.getMessage());
        }
        ExtentCucumberAdapter.addTestStepLog("TEXT ENTERED : "+ value);
    }

    @When("user waits for {string} seconds")
    public void user_waits_for_seconds(String string) {
        int intvalue= Integer.parseInt(string);
        System.out.println("waiting for "+intvalue +" seconds..");
        try {
            Thread.sleep(intvalue*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user clicks on element using locator type {string} and value {string}")
    public void user_clicks_on_element_using_locator_type_and_value(String locatorType, String attributeValue) {
        try {
            WebElement element=returnWebElement(locatorType,attributeValue);
            element.click();
        } catch (Exception e) {
            Assert.fail("some exception occurred "+e.getMessage());
        }
    }
}
