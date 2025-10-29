package org.eni.koinonia.repository;

import java.util.List;

import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.model.TranscriptType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
  List<Transcript> findByType(TranscriptType type);

  /*
  @Query("""
    SELECT * from transcripts WHERE content LIKE "%" + :content + "%"
  """)
  List<Transcript> searchByContentKeyword(@Param String keyword);
   */
}
