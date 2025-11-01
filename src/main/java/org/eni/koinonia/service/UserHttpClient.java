package org.eni.koinonia.service;

import java.util.List;

import org.eni.koinonia.model.Transcript;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface UserHttpClient {
  @GetExchange("/users")
  List<Transcript> findAll();

  @GetExchange("/users/{id}")
   Transcript findById(@PathVariable Long id);
}
