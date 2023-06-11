package com.blaze.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = {"src/test/resources/features/sample.feature"},
        glue = {"com.blaze"},
        dryRun = false,
        tags = "@demo",
        plugin = { "pretty", "json:target/cucumber/Cucumber.json",
                "junit:target/cucumber/Cucumber.xml",
                //"html:target/cucumber/reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests {

}