package org.eni.koinonia.controller;

import java.util.List;

import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.service.UserRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  public final UserRestClient userRestClient;

  public UserController(UserRestClient userRestClient) {
    this.userRestClient = userRestClient;
  }

  @GetMapping
  public List<Transcript> getUsers() {
    return userRestClient.findAll();
  }

  @GetMapping("/{id}")
  public Transcript getUser(@PathVariable Long id) {
    return userRestClient.findById(id);
  }
}
