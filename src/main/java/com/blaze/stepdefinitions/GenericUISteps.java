package com.blaze.stepdefinitions;

import com.blaze.Helper;
import com.blaze.manager.BrowserManager;
import com.blaze.scenario.ScenarioDetails;
import com.blaze.utlilities.ReadExcell;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class GenericUISteps extends Helper {
    ScenarioDetails sd=null;

    @Given("user loads data {string}")
    public void user_loads_data(String dataSheetPath) {
        ReadExcell.setDataSheetPath(dataSheetPath);
    }
    @Given("user launches url {string} on browser {string}")
    public void user_launches_url_on_browser(String url,String browser) {

        BrowserManager.getInstance().initializeWebdriver(browser);
        BrowserManager.getInstance().getDriver().get(url);


    }
    @When("users enters text {string} using locator type {string} and value {string}")
    public void users_enters_text_using_locator_type_and_value(String value, String locatorType, String attributeValue) {
        try {
            sd= ScenarioDetails.getScenarioDetailsInstance();
            Map<String, String> data=sd.getScenarioData();
            if(value.startsWith("#")) {
                value = data.get(value);
            }
            WebElement element=returnWebElement(locatorType,attributeValue);
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("some exception occurred "+e.getMessage());
        }

    }
}
