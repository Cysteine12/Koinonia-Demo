package org.eni.koinonia.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  @Override
  public void run (String... args) throws Exception {
    System.out.println("This is the data loader");
  }
}
