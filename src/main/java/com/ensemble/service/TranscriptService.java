package com.ensemble.service;

import com.ensemble.dto.ListResponse;

public interface TranscriptService {

	public ListResponse getAllExons(int transcriptId, int start) throws Exception;
}
