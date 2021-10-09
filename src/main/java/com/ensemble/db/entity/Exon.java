package com.ensemble.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Class respresent DB model of exons. 
 * @author sarfraz
 *
 */
@Entity
@Table(name = "exon")
public class Exon extends Auditable implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "exon_id", nullable = false,length = 10)
	Integer exonId;

	@Column(name = "seq_region_id", length = 10)
	Integer seqRegionId;

	@Column(name = "seq_region_start", length = 10)
	Integer seqRegionStart;
	
	@Column(name = "seq_region_end",  length = 10)
	Integer seqRegionEnd;
	
	@Column(name = "seq_region_strand",length = 2 )
	byte seqRegionStrand;
		
	@Column(name = "phase", length = 2)
	byte phase;
	
	@Column(name = "end_phase", length = 2)
	byte endPhase;
			
	@Column(name = "is_current", length = 1)
	byte isCurrent=1;
	
	@Column(name = "is_constitutive", length = 1)
	byte isConstitutive=0;
	
	@Column(name = "stable_id", length = 128)
	String  stableId;
	
	@Column(name = "version")
	short  version;

	public Integer getExonId() {
		return exonId;
	}

	public Integer getSeqRegionId() {
		return seqRegionId;
	}

	public void setSeqRegionId(Integer seqRegionId) {
		this.seqRegionId = seqRegionId;
	}

	public Integer getSeqRegionStart() {
		return seqRegionStart;
	}

	public void setSeqRegionStart(Integer seqRegionStart) {
		this.seqRegionStart = seqRegionStart;
	}

	public Integer getSeqRegionEnd() {
		return seqRegionEnd;
	}

	public void setSeqRegionEnd(Integer seqRegionEnd) {
		this.seqRegionEnd = seqRegionEnd;
	}

	public byte getSeqRegionStrand() {
		return seqRegionStrand;
	}

	public void setSeqRegionStrand(byte seqRegionStrand) {
		this.seqRegionStrand = seqRegionStrand;
	}

	public byte getPhase() {
		return phase;
	}

	public void setPhase(byte phase) {
		this.phase = phase;
	}

	public byte getEndPhase() {
		return endPhase;
	}

	public void setEndPhase(byte endPhase) {
		this.endPhase = endPhase;
	}

	public byte getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(byte isCurrent) {
		this.isCurrent = isCurrent;
	}

	public byte getIsConstitutive() {
		return isConstitutive;
	}

	public void setIsConstitutive(byte isConstitutive) {
		this.isConstitutive = isConstitutive;
	}

	public String getStableId() {
		return stableId;
	}

	public void setStableId(String stable_id) {
		this.stableId = stable_id;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endPhase;
		result = prime * result + ((exonId == null) ? 0 : exonId.hashCode());
		result = prime * result + isConstitutive;
		result = prime * result + isCurrent;
		result = prime * result + phase;
		result = prime * result + ((seqRegionEnd == null) ? 0 : seqRegionEnd.hashCode());
		result = prime * result + ((seqRegionId == null) ? 0 : seqRegionId.hashCode());
		result = prime * result + ((seqRegionStart == null) ? 0 : seqRegionStart.hashCode());
		result = prime * result + seqRegionStrand;
		result = prime * result + ((stableId == null) ? 0 : stableId.hashCode());
		result = prime * result + version;
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
		Exon other = (Exon) obj;
		if (endPhase != other.endPhase)
			return false;
		if (exonId == null) {
			if (other.exonId != null)
				return false;
		} else if (!exonId.equals(other.exonId))
			return false;
		if (isConstitutive != other.isConstitutive)
			return false;
		if (isCurrent != other.isCurrent)
			return false;
		if (phase != other.phase)
			return false;
		if (seqRegionEnd == null) {
			if (other.seqRegionEnd != null)
				return false;
		} else if (!seqRegionEnd.equals(other.seqRegionEnd))
			return false;
		if (seqRegionId == null) {
			if (other.seqRegionId != null)
				return false;
		} else if (!seqRegionId.equals(other.seqRegionId))
			return false;
		if (seqRegionStart == null) {
			if (other.seqRegionStart != null)
				return false;
		} else if (!seqRegionStart.equals(other.seqRegionStart))
			return false;
		if (seqRegionStrand != other.seqRegionStrand)
			return false;
		if (stableId == null) {
			if (other.stableId != null)
				return false;
		} else if (!stableId.equals(other.stableId))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
