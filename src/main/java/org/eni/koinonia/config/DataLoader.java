package org.eni.koinonia.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.repository.TranscriptRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Profile("!production")
@Component
public class DataLoader implements CommandLineRunner {
  public final TranscriptRepository transcriptRepository;
  public final ObjectMapper objectMapper;

  public DataLoader(TranscriptRepository transcriptRepository, ObjectMapper objectMapper) {
    this.transcriptRepository = transcriptRepository;
    this.objectMapper = objectMapper;
  }
  
  @Override
  public void run (String... args) throws Exception {
    System.out.println("Started seeding data");
    if (transcriptRepository.count() < 3) {
      try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/transcript.json")) {
        List<Transcript> transcripts = objectMapper.readValue(inputStream, new TypeReference<List<Transcript>>(){});
        
        transcriptRepository.saveAll(transcripts);
      } catch (IOException e) {
        throw new RuntimeException("Error seeding data: " + e.getMessage());
      }    
    } else {
      System.out.println("Data already present");
    }
    
    System.out.println("Data seeding completed");
  }
}
