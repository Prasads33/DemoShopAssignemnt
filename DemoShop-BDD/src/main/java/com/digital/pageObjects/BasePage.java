package com.digital.pageObjects;

import com.digital.cucumber.ScenarioContext;
import com.digital.utils.DataGenerator;

public class BasePage {

  protected final DataGenerator dataGenerator = new DataGenerator();
  protected static ScenarioContext scenarioContext;

  public void setScenarioContext(ScenarioContext scenarioContext) {
    BasePage.scenarioContext = scenarioContext;
  }

  protected boolean isEmptyOrNullString(String str) {
    if (str == null) {
      return false;
    } else return str.equals("null") || str.isEmpty();
  }
}
