package com.ensemble.db.entity;

import java.io.Serializable;
/**
 * Class represent composite primary key of {@link ExonTranscript}
 * @author sarfraz
 *
 */
public class ExonTranscriptId implements Serializable{

	
	
	private static final long serialVersionUID = 1L;

	private Integer  exon;
	
	private Integer transcript;
	
	private Integer rank;
	
	
	public ExonTranscriptId() {
		
	}
	
	public ExonTranscriptId(Integer  exon, Integer transcript, Integer rank) {
		this.exon=exon;
		this.transcript=transcript;
		this.rank=rank;
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

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exon == null) ? 0 : exon.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((transcript == null) ? 0 : transcript.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExonTranscriptId other = (ExonTranscriptId) obj;
		if (exon == null) {
			if (other.exon != null)
				return false;
		} else if (!exon.equals(other.exon))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (transcript == null) {
			if (other.transcript != null)
				return false;
		} else if (!transcript.equals(other.transcript))
			return false;
		return true;
	}


	
}
