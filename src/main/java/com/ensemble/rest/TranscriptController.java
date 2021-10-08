package com.ensemble.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensemble.db.entity.Exon;
import com.ensemble.db.entity.ExonTranscript;
import com.ensemble.db.entity.Transcript;
import com.ensemble.db.repository.ExonRepository;
import com.ensemble.db.repository.ExonTranscriptRepository;
import com.ensemble.db.repository.TranscriptRepository;
import com.ensemble.dto.ListResponse;
import com.ensemble.service.TranscriptService;

@RestController
public class TranscriptController {
	
	public static Logger log=LoggerFactory.getLogger(TranscriptController.class);

	@Autowired
	TranscriptRepository transcriptRepository;
	
	@Autowired
	ExonRepository exonRepository;
	
	@Autowired
	ExonTranscriptRepository exonTranscriptRepository;
	
	@Autowired
	TranscriptService transcriptService;
	
	@GetMapping
	public String Hello(@RequestParam String name) {
		
		return "Hello "  +name;
	}
	
	
	@PostMapping(path = "/transcript")
		public ResponseEntity<Transcript> createTranscript() {
		Transcript transcript=new Transcript();
		transcript.setAnalysisId((short) 9727);
		transcript.setSeqRegionId(131559);
		transcript.setSeqRegionStart(73736097);
		transcript.setSeqRegionEnd(73738867);
		transcript.setSeqRegionStrand((byte) -1);
		transcript.setBioType("cdna_update");
		transcript.setDescription("NM_001301058.1");
		transcript.setIsCurrent((byte) 1);
		transcript.setStable_id("1");
		transcript=transcriptRepository.save(transcript);
		
		System.out.println("tarnscript:"+transcript.getCreatedDate());
		Exon exon=new Exon();
		exon.setSeqRegionId(123123);
		exon.setSeqRegionStart(73736097);
		exon.setSeqRegionEnd(73738867);
		exon.setSeqRegionStrand((byte) -1);
		exon.setPhase((byte)0);
		exon.setPhase((byte)1);
		exon.setIsCurrent((byte)-1);
		exon.setIsConstitutive((byte)1);
		exonRepository.save(exon);
		System.out.println("date exon creation"+exon.getCreatedDate());
		ExonTranscript exonTranscript=new ExonTranscript();
		exonTranscript.setExon(exon);
		exonTranscript.setTranscript(transcript);
		exonTranscript.setRank(5);
		exonTranscriptRepository.save(exonTranscript);
		
		
		Exon exon2=new Exon();
		exon2.setSeqRegionId(123123);
		exon2.setSeqRegionStart(73736097);
		exon2.setSeqRegionEnd(73738867);
		exon2.setSeqRegionStrand((byte) -1);
		exon2.setPhase((byte)0);
		exon2.setPhase((byte)1);
		exon2.setIsCurrent((byte)-1);
		exon2.setIsConstitutive((byte)1);
		exonRepository.save(exon2);
		System.out.println("date exon creation"+exon2.getCreatedDate());
		ExonTranscript exonTranscript2=new ExonTranscript();
		exonTranscript2.setExon(exon2);
		exonTranscript2.setTranscript(transcript);
		exonTranscript2.setRank(5);
		exonTranscriptRepository.save(exonTranscript2);
		System.out.println(exonTranscript2.getRank());
		return ResponseEntity.ok(transcript);
	}
	
	@GetMapping(path = "/transcripts/{transcriptId}/exons")
	public ResponseEntity<ListResponse> getAllExons(@PathVariable(value="transcriptId", required = true) int transcriptId, @RequestParam(name = "startIndex",defaultValue = "0") int startIndex ){
		
		ListResponse exons;
		try {
			exons = transcriptService.getAllExons(transcriptId,startIndex);
			log.info("Number exons returned {}", exons.getItemsPerPage());
			return ResponseEntity.ok(exons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
