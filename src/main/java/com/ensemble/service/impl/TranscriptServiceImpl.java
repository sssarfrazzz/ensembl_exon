package com.ensemble.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ensemble.Utils.Constants;
import com.ensemble.Utils.Utils;
import com.ensemble.db.entity.Exon;
import com.ensemble.db.repository.ExonRepository;
import com.ensemble.db.repository2.ExonRepository2;
import com.ensemble.dto.ListResponse;
import com.ensemble.service.TranscriptService;

@Service
public class TranscriptServiceImpl implements TranscriptService {
	@Autowired
	ExonRepository exonRepository;
	
	
	@Autowired
	ExonRepository2 exonRepository2;

	@Override
	public ListResponse getAllExons(int transcriptId, int start) throws Exception {
		if (start < 0) {
			throw new Exception("Bad Request");
		}
		long count = exonRepository.countAllExons(transcriptId);
		int itemsPerPage = 0;
		if (count > Constants.MAX_BATCH_SIZE_DB) {
			itemsPerPage = Utils.getNumberOfPages(count, Constants.MAX_BATCH_SIZE_DB);
		} else {
			itemsPerPage = (int) count;
		}
		Pageable limit = PageRequest.of(start, itemsPerPage);
		List<Exon> exons = exonRepository.getAllExons(transcriptId, limit);
		ListResponse response = new ListResponse(count, start, itemsPerPage, exons);
		return response;
	}

	@Override
	public ListResponse getAllExons(String transcriptStableId, int start, int version) throws Exception {
		
		if (start < 0) {
			throw new Exception("Bad Request");
		}
		long count=0;
		if(version==2) {
			count=exonRepository2.countExons(transcriptStableId);
		} else {
			 count = exonRepository.countExons(transcriptStableId);
		}
		
		int itemsPerPage = 0;
		if (count > Constants.MAX_BATCH_SIZE_DB) {
			itemsPerPage = Utils.getNumberOfPages(count, Constants.MAX_BATCH_SIZE_DB);
		} else if (count == 0) {
			// if exons does not exist for given transcript id
			ListResponse response=new ListResponse(0, start, 0, null);
			response.setMessage("No exons found for given transcript stable id.");
			return response;
		} else {
			itemsPerPage = (int) count;
		}
		Pageable limit = PageRequest.of(start, itemsPerPage);
		List<Exon> exons=null;
		if(version==2) {
			exons= exonRepository2.getAllExons(transcriptStableId, limit);
		}else {
			exons= exonRepository.getAllExons(transcriptStableId, limit);
		}
		 
		ListResponse response = new ListResponse(count, start, itemsPerPage, exons);
		return response;
	}

}
