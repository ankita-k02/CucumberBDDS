package com.utility;
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


public class Hooks {
    @Before
    public void setUp() {
        System.out.println("Starting Test Scenario...");
        DriverManager.setDriver();  // Initialize WebDriver
    }
    
    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "target/screenshots/" + scenario.getName() + "_" + scenario.getStatus() + ".png";
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                scenario.attach(FileUtils.readFileToByteArray(new File(screenshotPath)), "image/png", "Step Screenshot");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario Failed: " + scenario.getName());
        } else {
            System.out.println("Scenario Passed: " + scenario.getName());
        }
        DriverManager.quitDriver();  // Quit WebDriver
    }
}  