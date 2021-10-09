package com.ensemble.service;

import com.ensemble.dto.ListResponse;

public interface TranscriptService {

	/**
	 * Method returns all based on transcript_id
	 * @param transcriptId
	 * @param start
	 * @return
	 * @throws Exception
	 */
	public ListResponse getAllExons(int transcriptId, int start) throws Exception;
	/**
	 * Method returns all based on transcript stable id
	 * @param transcriptStableId
	 * @param start
	 * @return
	 * @throws Exception
	 */
	public ListResponse getAllExons(String transcriptStableId, int start, int version) throws Exception;
}
