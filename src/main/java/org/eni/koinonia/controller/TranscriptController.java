package org.eni.koinonia.controller;

import java.util.List;

import org.eni.koinonia.dto.TranscriptDto;
import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.model.TranscriptType;
import org.eni.koinonia.service.TranscriptService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transcripts")
@CrossOrigin
public class TranscriptController {
  private final TranscriptService transcriptService;

  // @Autowired
  public TranscriptController(TranscriptService transcriptService) {  
    this.transcriptService = transcriptService;
  }
  
  @GetMapping
  public List<Transcript> getTranscripts() {
    return transcriptService.findAll();
  }

  @GetMapping("/type/{type}")
  public List<Transcript> getTranscriptsByType(@PathVariable TranscriptType type) {
    return transcriptService.findByType(type);
  }

  @GetMapping("/{id}")
  public Transcript getTranscript(@PathVariable Long id) {
    return transcriptService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createTranscript(@Valid @RequestBody TranscriptDto dto) {
    transcriptService.save(dto);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateTranscript(@PathVariable Long id, @Valid @RequestBody TranscriptDto dto){
    transcriptService.updateById(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTrancript(@PathVariable Long id) {
    transcriptService.deleteById(id);
  }
}
