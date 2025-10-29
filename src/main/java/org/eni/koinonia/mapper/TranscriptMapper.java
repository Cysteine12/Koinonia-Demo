package org.eni.koinonia.mapper;

import org.eni.koinonia.dto.TranscriptDto;
import org.eni.koinonia.model.Transcript;
import org.springframework.stereotype.Component;

@Component
public class TranscriptMapper {
  public Transcript toEntity (TranscriptDto dto) {
    Transcript transcript = new Transcript();

    transcript.setTitle(dto.getTitle());
    transcript.setContent(dto.getContent());
    transcript.setAudioUrl(dto.getAudioUrl());
    transcript.setTaughtAt(dto.getTaughtAt());
    transcript.setType(dto.getType());
    return transcript;
  }
}
