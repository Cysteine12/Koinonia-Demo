package org.eni.koinonia.model;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transcripts")
public class Transcript {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;
  
  @Column(nullable = false, unique = true)
  private String audioUrl;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TranscriptType type;

  @Column(nullable = false)
  private LocalDateTime taughtAt;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Transcript() {}

  public Transcript(String title, String content, String audioUrl, TranscriptType type, LocalDateTime taughtAt) {
    this.title = title;
    this.content = content;
    this.audioUrl = audioUrl;
    this.type = type;
    this.taughtAt = taughtAt;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

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

  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

  public LocalDateTime getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
