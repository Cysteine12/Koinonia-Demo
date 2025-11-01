package org.eni.koinonia.service;

import java.util.List;

import org.eni.koinonia.model.Transcript;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserRestClient {
  private final RestClient restClient;

  public UserRestClient(RestClient.Builder builder) {
    this.restClient = builder
      .baseUrl("http://localhost:8080/api")
      .build();
  }

  public List<Transcript> findAll() {
    return restClient
      .get()
      .uri("/transcripts")
      .retrieve()
      .body(new ParameterizedTypeReference<>(){});
  }

  public Transcript findById(Long id) {
    return restClient
      .get()
      .uri("/transcripts/{id}", id)
      .retrieve()
      .body(Transcript.class);
  }
}
