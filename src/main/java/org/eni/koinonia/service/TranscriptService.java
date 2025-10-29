package org.eni.koinonia.service;

import java.util.List;

import org.eni.koinonia.dto.TranscriptDto;
import org.eni.koinonia.mapper.TranscriptMapper;
import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.model.TranscriptType;
import org.eni.koinonia.repository.TranscriptRepository;
import org.eni.koinonia.utils.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TranscriptService {
  private final TranscriptRepository transcriptRepository;
  private final TranscriptMapper transcriptMapper;

  public TranscriptService (TranscriptRepository transcriptRepository, TranscriptMapper transcriptMapper) {
    this.transcriptRepository = transcriptRepository;
    this.transcriptMapper = transcriptMapper;
  }

  public List<Transcript> findAll () {
    return transcriptRepository.findAll();
  }

  public Transcript findById (Long id) {
    return transcriptRepository.findById(id).orElseThrow(() -> new NotFoundException("Transcript not found"));
  }

  public List<Transcript> findByType(TranscriptType type) {
    return transcriptRepository.findByType(type);
  }

  public Transcript save (TranscriptDto dto) {
    return transcriptRepository.save(transcriptMapper.toEntity(dto));
  }

  public Transcript updateById (Long id, TranscriptDto dto) {
    return transcriptRepository.findById(id)
      .map(t -> {
        return transcriptRepository.save(transcriptMapper.toEntity(dto));
      })
      .orElseThrow(() -> new NotFoundException("Transcript not found"));
  }

  public void deleteById(Long id) {
    if (!transcriptRepository.existsById(id)) {
      throw new NotFoundException("Transcript not found");
    }

    transcriptRepository.deleteById(id);
  }
}
