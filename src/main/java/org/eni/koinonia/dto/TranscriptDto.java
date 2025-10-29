package org.eni.koinonia.dto;

import java.time.LocalDateTime;

import org.eni.koinonia.model.TranscriptType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TranscriptDto {
  
  @NotBlank(message = "Title is required")
  private String title;

  @NotBlank(message = "Content is required")
  private String content;

  @NotBlank(message = "Audio URL is required")
  private String audioUrl;

  @NotNull(message = "Transcript type is required")
  private TranscriptType type;

  @NotNull(message = "Date of teaching is required")
  private LocalDateTime taughtAt;

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getContent() { return title; }
  public void setContent(String content) { this.content = content; }

  public String getAudioUrl() { return audioUrl; }
  public void setAudioUrl(String audioUrl) { this.audioUrl = audioUrl; }

  public TranscriptType getType() { return type; }
  public void setType(TranscriptType type) { this.type = type; }

  public LocalDateTime getTaughtAt() { return taughtAt; }
  public void setTaughtAt(LocalDateTime taughtAt) { this.taughtAt = taughtAt; }
}
