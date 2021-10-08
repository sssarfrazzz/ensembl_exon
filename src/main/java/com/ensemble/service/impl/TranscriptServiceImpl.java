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
import com.ensemble.dto.ListResponse;
import com.ensemble.service.TranscriptService;

@Service
public class TranscriptServiceImpl implements TranscriptService {
	@Autowired
	ExonRepository exonRepository;
	
	@Override
	public ListResponse getAllExons(int transcriptId, int start) throws Exception {
		if(start<0) {
			throw new Exception("Bad Request");
		}
		long count=exonRepository.countAllExons(transcriptId);
		int itemsPerPage=0;
		if(count>Constants.MAX_BATCH_SIZE_DB) {
			itemsPerPage=Utils.getNumberOfPages(count, Constants.MAX_BATCH_SIZE_DB);
		} else {
			itemsPerPage=(int) count;
		}
		Pageable limit=PageRequest.of(start, itemsPerPage);
		List<Exon> exons =exonRepository.getAllExons(transcriptId, limit);
		ListResponse response=new ListResponse(count, start, itemsPerPage, exons);
		return response;
	}

}
