package com.ensemble.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensemble.db.entity.Transcript;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
	

}
