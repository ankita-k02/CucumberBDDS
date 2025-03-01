package com.utility;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features/GreenKartDemo.feature", // Path to feature files
        glue = {"classpath:StepDefinations","com.utility"}, // Package containing step definitions
        plugin = {
                "pretty", // Prints readable output in console
                "html:target/cucumber-reports/cucumber-html-report.html", // Generates HTML report
                "json:target/cucumber-reports/cucumber-report.json", // Generates JSON report
        },
        monochrome = true // Makes console output readable
//        tags = "@Regression" // Run tests with specific tags
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
