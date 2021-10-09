package com.ensemble.db.repository2;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensemble.db.entity.Exon;
/**
 * Repository interface to connect to DB.This Package corresponds to second database connected to project
 * @author sarfraz
 *
 */
@Repository
public interface ExonRepository2 extends JpaRepository<Exon, Integer> {
	
	@Query(value ="select count(*) from exon e where e.exon_id in (select et.exon_id from exon_transcript et where et.transcript_id = :transcriptId order by et.rank)",nativeQuery=true)
	public Long countAllExons(@Param("transcriptId") Integer transcriptId); 
	
	@Query(value ="select * from exon e where e.exon_id in (select et.exon_id from exon_transcript et where et.transcript_id = :transcriptId order by et.rank)",nativeQuery=true)
	public List<Exon> getAllExons(@Param("transcriptId") Integer transcriptId, Pageable limit); 
	
	@Query(value ="select count(*) from exon e where e.exon_id in (select et.exon_id from exon_transcript et where et.transcript_id = (select transcript_id from transcript where stable_id=:transcriptStableId) order by et.rank)",nativeQuery=true)
	public Long countExons(@Param("transcriptStableId") String transcriptStableId); 
	
	@Query(value ="select * from exon e where e.exon_id in (select et.exon_id from exon_transcript et where et.transcript_id = (select transcript_id from transcript where stable_id=:transcriptStableId) order by et.rank)",nativeQuery=true)
	public List<Exon> getAllExons(@Param("transcriptStableId") String transcriptStableId, Pageable limit); 
}
