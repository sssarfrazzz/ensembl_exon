package com.ensemble.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensemble.db.entity.ExonTranscript;
import com.ensemble.db.entity.ExonTranscriptId;
/**
 * Repository interface to connect to DB.
 * @author sarfraz
 *
 */
@Repository
public interface ExonTranscriptRepository extends JpaRepository<ExonTranscript, ExonTranscriptId> {
	
	
}
