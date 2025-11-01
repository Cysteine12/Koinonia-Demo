package org.eni.koinonia.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// requires adding the "configuration processor" dependencies
// @ConfigurationProperties(value = "app")
public record KoinoniaProperties(
  String name,
  String desc
) {}
