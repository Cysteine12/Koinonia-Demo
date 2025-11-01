package org.eni.koinonia.controller;

import java.util.Map;

import org.eni.koinonia.config.KoinoniaProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
  @Value("${app.name: Default Name}")
  private String appName;

  @Value("${app.desc: This is the config environment}")
  private String desc;

  // private final KoinoniaProperties properties;

  // public IndexController (KoinoniaProperties properties) {
  //   this.properties = properties;
  // }
  
  @GetMapping
  public String index() {
    return "Welcome to " + appName + ". " + desc + "..";
  }

  // @GetMapping("/status")
  // public Map<String, String> status() {
  //   return Map.of("app", properties.name(), "description", properties.desc());
  // }
}
