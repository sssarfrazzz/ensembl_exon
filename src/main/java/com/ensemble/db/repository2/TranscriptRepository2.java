package com.ensemble.db.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensemble.db.entity.Transcript;
/**
 * Repository interface to connect to DB.This Package corresponds to second database connected to project
 * @author sarfraz
 *
 */
@Repository
public interface TranscriptRepository2 extends JpaRepository<Transcript, Integer> {
	

}
