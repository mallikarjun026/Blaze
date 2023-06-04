package com.blaze.stepdefinitions;

import com.blaze.manager.BrowserManager;
import com.blaze.scenario.ScenarioDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class Helper {
    ScenarioDetails sd=null;
    public WebElement returnWebElement(String locatorType,String locatorValue) throws Exception {
        WebDriver driver= BrowserManager.getInstance().getDriver();
        WebElement element=null;
        if(locatorType.equalsIgnoreCase("id"))
        {
            element=driver.findElement(By.id(locatorValue));
        }
        else if(locatorType.equalsIgnoreCase("class"))
        {
            element=driver.findElement(By.className(locatorValue));
        }
        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            element=driver.findElement(By.xpath(locatorValue));
        }
        else if(locatorType.equalsIgnoreCase("name"))
        {
            element=driver.findElement(By.name(locatorValue));
        }
        else{
            throw new Exception("invalid locator type");
        }
        return  element;
    }

    public String returnDataForCurrentScenario(String columnName)
    {
        sd= ScenarioDetails.getScenarioDetailsInstance();
        Map<String, String> data=sd.getScenarioData();
        if(columnName.startsWith("#")) {
            columnName = data.get(columnName);
        }
        return columnName;

    }
}
