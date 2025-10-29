package org.eni.koinonia.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexController {
  @Value("${app.name: Default Name}")
  private String appName;

  @Value("${app.env: development}")
  private String env;
  
  @GetMapping
  public String index() {
    return "Welcome to " + appName + ". This is the prod environment.";
  }

  @GetMapping("/status")
  public Map<String, String> status() {
    return Map.of("app", appName, "env", env);
  }
}
