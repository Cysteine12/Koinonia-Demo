package org.eni.koinonia.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.model.TranscriptType;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

// @Repository
public class TranscriptInMemoryRepository {
  private final List<Transcript> transcripts = new ArrayList<>();

  public TranscriptInMemoryRepository() {
  }

  public List<Transcript> findAll() {
    return transcripts;
  }

  public Optional<Transcript> findById(Long id) {
    return transcripts.stream().filter(t -> t.getId().equals(id)).findFirst();
  }

  public boolean existsById(Long id) {
    // return transcripts.stream().filter(transcript -> transcript.getId().equals(id)).count() == 1;
    return transcripts.stream().anyMatch(t -> t.getId().equals(id));
  }

  public boolean save(Transcript transcript) {
    return transcripts.add(transcript);
  }

  public void update(Long id, Transcript transcript) {
    transcripts.removeIf(t -> t.getId().equals(id));
    transcripts.add(transcript);
  }

  public void delete(Long id) {
    transcripts.removeIf(t -> t.getId().equals(id));
  }

  // @PostConstruct
  // private void init() {
  //   Transcript transcript = new Transcript(
  //     1,
  //     "The Doctrine of Resurrection",
  //     "This is the sermon content",
  //     "https://koinonia.org/2g3eg3678",
  //     TranscriptType.SUNDAY_SERVICE,
  //     null,
  //     null,
  //     null
  //   );

  //   transcripts.add(transcript);
  // }
}
