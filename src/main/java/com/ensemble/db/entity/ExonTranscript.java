package com.ensemble.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Class respresent DB model of exons_transcript.
 * 
 * @author sarfraz
 *
 */
@Entity
@Table(name = "exon_transcript")
@IdClass(ExonTranscriptId.class)
public class ExonTranscript implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "exon_id", length = 10, nullable = false)
	private Integer exon;

	@Id
	@Column(name = "transcript_id", length = 10, nullable = false)
	private Integer transcript;

	@Id
	@Column(name = "rank", length = 10, nullable = false)
	private Integer rank;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getExon() {
		return exon;
	}

	public void setExon(Integer exon) {
		this.exon = exon;
	}

	public Integer getTranscript() {
		return transcript;
	}

	public void setTranscript(Integer transcript) {
		this.transcript = transcript;
	}

}
