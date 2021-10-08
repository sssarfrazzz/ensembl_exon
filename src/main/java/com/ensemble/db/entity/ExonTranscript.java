package com.ensemble.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exon_transcript")
@IdClass(ExonTranscriptId.class)
public class ExonTranscript implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "exon_id", nullable = false, referencedColumnName = "exon_id")
	@OneToOne(fetch = FetchType.LAZY,targetEntity = Exon.class)
	private Exon  exon;
	
	@Id
	@JoinColumn(name = "transcript_id", nullable = false,referencedColumnName = "transcript_id")
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Transcript.class)
	private Transcript  transcript;
	
	@Id
	@Column(name = "rank",length = 10, nullable = false)
	private Integer rank;

	public Exon getExon() {
		return exon;
	}

	public void setExon(Exon exon) {
		this.exon = exon;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
}
