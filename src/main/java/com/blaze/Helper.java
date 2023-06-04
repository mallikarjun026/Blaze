package com.blaze;

import com.blaze.manager.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    public WebElement returnWebElement(String locatorType,String locatorValue) throws Exception {
        WebDriver driver= BrowserManager.getInstance().getDriver();
        WebElement element=null;
        if(locatorType.equalsIgnoreCase("id"))
        {
            element=driver.findElement(By.id("locatorValue"));
        }
        else if(locatorType.equalsIgnoreCase("class"))
        {
            element=driver.findElement(By.className("locatorValue"));
        }
        else if(locatorType.equalsIgnoreCase("xpath"))
        {
            element=driver.findElement(By.xpath("locatorValue"));
        }
        else{
            throw new Exception("invalid locator type");
        }
        return  element;
    }
}
