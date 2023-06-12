package com.blaze.hooks;

import com.blaze.manager.BrowserManager;
import com.blaze.scenario.ScenarioDetails;
import com.blaze.utlilities.ReadExcell;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Hooks {
    ScenarioDetails sd=null;


    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {

         String disableScreenShot= System.getProperty("DISABLE_SCREENSHOT","false");
        if(disableScreenShot.equalsIgnoreCase("false")) {
                WebDriver driver = BrowserManager.getInstance().getDriver();
                if (driver != null) {
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
                    scenario.attach(fileContent, "image/png", "screenshot");
                }
            }//if ends

    }

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("this will execute before every scenario");
        System.out.println("scenario currently executing : "+scenario.getName());
        Collection<String> tags= scenario.getSourceTagNames();
        sd=ScenarioDetails.getScenarioDetailsInstance();
        sd.setScenarioName(scenario.getName());
        String temp=null;
        for(String singletag:tags)
        {
            if(singletag.startsWith("@Test_Id_")){
                temp=singletag.split("@Test_Id_")[1];
                sd.setTestID(temp);
            }
        }

        System.out.println("Test id : "+sd.getTestID());

    }

    @After
    public void afterScenario(Scenario scenario){
        BrowserManager.getInstance().getDriver().close();

    }


}
