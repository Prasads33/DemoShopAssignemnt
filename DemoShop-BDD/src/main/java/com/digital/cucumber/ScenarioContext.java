package com.digital.cucumber;

import java.util.HashMap;
import java.util.Map;

import com.answer.enums.Data;

public class ScenarioContext {
  private final Map<String, Object> scenarioContext;

  public ScenarioContext() {
    scenarioContext = new HashMap<>();
  }

  public void setContext(Data key, Object value) {
    scenarioContext.put(key.toString(), value);
  }

  public Object getContext(Data key) {
    return scenarioContext.get(key.toString());
  }

  public Boolean isContains(Data key) {
    return scenarioContext.containsKey(key.toString());
  }
}
