package com.ensemble.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensemble.dto.ListResponse;
import com.ensemble.service.TranscriptService;

/**
 * Controller class exposes transcript API
 * @author sarfraz
 *
 */
@RestController
public class TranscriptController {
	
	public static Logger log=LoggerFactory.getLogger(TranscriptController.class);

	
	@Autowired
	TranscriptService transcriptService;
	

	/**
	 * Get all exon for given transcript stable id.
	 * @param transcriptStableId transcript stable id
	 * @param startIndex value should be greater than or equal to 0
	 * @return
	 */
	@GetMapping(path = "/transcripts/{transcriptStableId}/exons")
	public ResponseEntity<ListResponse> getAllExons(@PathVariable(value="transcriptStableId", required = true) String transcriptStableId, @RequestParam(name = "startIndex",defaultValue = "0") int startIndex ){
		
		ListResponse exons;
		try {
			exons = transcriptService.getAllExons(transcriptStableId,startIndex,1);
			log.info("Number exons returned {}", exons.getItemsPerPage());
			return ResponseEntity.ok(exons);
		} catch (Exception e) {
			log.error("Exception occurred {}, stacktrace {}", e.getMessage(),e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	/**
	 * Get all exon for given transcript stable id. This API is connection to second database asscociated with Project
	 * @param transcriptStableId transcript stable id
	 * @param startIndex value should be greater than or equal to 0
	 * @return
	 */
	@GetMapping(path = "/v2/transcripts/{transcriptStableId}/exons")
	public ResponseEntity<ListResponse> getAllExonsV2(@PathVariable(value="transcriptStableId", required = true) String transcriptStableId, @RequestParam(name = "startIndex",defaultValue = "0") int startIndex ){
		
		ListResponse exons;
		try {
			exons = transcriptService.getAllExons(transcriptStableId,startIndex,2);
			log.info("Number exons returned {}", exons.getItemsPerPage());
			return ResponseEntity.ok(exons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
