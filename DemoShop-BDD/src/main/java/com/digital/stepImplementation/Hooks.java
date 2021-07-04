package com.digital.stepImplementation;

import com.digital.cucumber.TestContext;
import com.digital.factory.PropertyManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Hooks extends BaseSteps {
	
	
	
	
  Logger log = LogManager.getLogger(getClass());

  @Given("when user launch the shopping application")
  public void launchApplication() {
    log.info("Login");
    String title = testContext.driverFactory.getDriver().getTitle();
   System.out.println("title--"+title);
    assertEquals(
        "Invalid Page Title",
        "TESTSCRIPTDEMO – Automation Practice",
        testContext.driverFactory.getDriver().getTitle());
  }

  @Before
  public void setup() {
	  
    log.info("************************* Test Execution Started *************************");
    log.info("Setup : Driver initialization & setup");
    System.out.println("-----prasad-------");
    gotoLoginPage();
 
    
  }

  @AfterStep
  public void toDoSomething() {
    if (PropertyManager.getInstance().getPropValue("captureScreen").equalsIgnoreCase("Yes"))
      testContext.getScreenshotUtil().takeScreenshot();
  }

  @After
  public void cleanup() {
    log.info("Cleanup : Driver closer");
    closeBrowser();
    log.info("************************* Test Execution Completed *************************");
  }
}
