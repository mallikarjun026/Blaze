package com.blaze.hooks;

import com.blaze.scenario.ScenarioDetails;
import com.blaze.utlilities.ReadExcell;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Collection;

public class Hooks {
    ScenarioDetails sd=null;

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.printf("this will execute before every scenario");
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.printf("this will execute after every scenario");
        System.out.println("scenario currently executing : "+scenario.getName());
        Collection<String> tags= scenario.getSourceTagNames();
        sd=ScenarioDetails.getScenarioDetailsInstance();
        sd.setScenarioName(scenario.getName());
        String temp=null;
        for(String singletag:tags)
        {
            if(singletag.startsWith("@Test_Id")){
                temp=singletag.split("@Test_Id")[1];
                sd.setTestID(temp);
            }
        }

        System.out.println("Test id : "+sd.getTestID());
        sd.setScenarioData(ReadExcell.returnTestDataMap("TEST_ID",sd.getTestID()));

    }


}
