package com.ensemble.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ensemble.Utils.Constants;
/**
 * Class represent DB model of transcript
 * @author sarfraz
 *
 */
@Entity
@Table(name = "transcript")
public class Transcript extends Auditable implements Serializable {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "transcript_id", nullable = false,length = 10)
	Integer transcriptId;

	/**
	 * Gene id assoicated with transcript
	 */
	@Column(name = "gene_id",length = 10)
	Integer geneId;

	/**
	 * Analysis id associated with Transcript
	 */
	@Column(name = "analysis_id")
	short  analysisId;

	/**
	 * Sequence region id 
	 */
	@Column(name = "seq_region_id", length = 10)
	Integer seqRegionId;

	/**
	 * Sequence region start 
	 */
	@Column(name = "seq_region_start", length = 10)
	Integer seqRegionStart;
	/**
	 * Sequence region end 
	 */
	@Column(name = "seq_region_end",  length = 10)
	Integer seqRegionEnd;
	/**
	 * Sequence region strand 
	 */
	@Column(name = "seq_region_strand",length = 2 )
	byte seqRegionStrand;
	
	
	@Column(name = "display_xref_id", length = 10)
	Integer displayXrefId;
	
	/**
	 * Source of transcript. Default value is ensembl
	 */
	@Column(name = "source")
	String source=Constants.ENSEMBL;
	
	@Column(name = "biotype", length = 40)
	String bioType;
	
	@Column(name = "description")
	String  description;
	
	@Column(name = "is_current", length = 1)
	byte isCurrent;
	
	@Column(name = "canonical_translation_id", length = 10, unique = true)
	Integer canonicalTranslationId;
	
	/**
	 * Stable id of transcript
	 */
	@Column(name = "stable_id", length = 128)
	String  stable_id;
	
	@Column(name = "version")
	short  version;

	public Integer getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Integer transcriptId) {
		this.transcriptId = transcriptId;
	}

	public Integer getGeneId() {
		return geneId;
	}

	public void setGeneId(Integer geneId) {
		this.geneId = geneId;
	}

	public short getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(short analysisId) {
		this.analysisId = analysisId;
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

	public Integer getDisplayXrefId() {
		return displayXrefId;
	}

	public void setDisplayXrefId(Integer displayXrefId) {
		this.displayXrefId = displayXrefId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBioType() {
		return bioType;
	}

	public void setBioType(String bioType) {
		this.bioType = bioType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(byte isCurrent) {
		this.isCurrent = isCurrent;
	}

	public Integer getCanonicalTranslationId() {
		return canonicalTranslationId;
	}

	public void setCanonicalTranslationId(Integer canonicalTranslationId) {
		this.canonicalTranslationId = canonicalTranslationId;
	}

	public String getStable_id() {
		return stable_id;
	}

	public void setStable_id(String stable_id) {
		this.stable_id = stable_id;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transcript [transcriptId=");
		builder.append(transcriptId);
		builder.append(", geneId=");
		builder.append(geneId);
		builder.append(", analysisId=");
		builder.append(analysisId);
		builder.append(", seqRegionId=");
		builder.append(seqRegionId);
		builder.append(", seqRegionStart=");
		builder.append(seqRegionStart);
		builder.append(", seqRegionEnd=");
		builder.append(seqRegionEnd);
		builder.append(", seqRegionStrand=");
		builder.append(seqRegionStrand);
		builder.append(", displayXrefId=");
		builder.append(displayXrefId);
		builder.append(", source=");
		builder.append(source);
		builder.append(", bioType=");
		builder.append(bioType);
		builder.append(", description=");
		builder.append(description);
		builder.append(", isCurrent=");
		builder.append(isCurrent);
		builder.append(", canonicalTranslationId=");
		builder.append(canonicalTranslationId);
		builder.append(", stable_id=");
		builder.append(stable_id);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + analysisId;
		result = prime * result + ((bioType == null) ? 0 : bioType.hashCode());
		result = prime * result + ((canonicalTranslationId == null) ? 0 : canonicalTranslationId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((displayXrefId == null) ? 0 : displayXrefId.hashCode());
		result = prime * result + ((geneId == null) ? 0 : geneId.hashCode());
		result = prime * result + isCurrent;
		result = prime * result + ((seqRegionEnd == null) ? 0 : seqRegionEnd.hashCode());
		result = prime * result + ((seqRegionId == null) ? 0 : seqRegionId.hashCode());
		result = prime * result + ((seqRegionStart == null) ? 0 : seqRegionStart.hashCode());
		result = prime * result + seqRegionStrand;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((stable_id == null) ? 0 : stable_id.hashCode());
		result = prime * result + ((transcriptId == null) ? 0 : transcriptId.hashCode());
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
		Transcript other = (Transcript) obj;
		if (analysisId != other.analysisId)
			return false;
		if (bioType == null) {
			if (other.bioType != null)
				return false;
		} else if (!bioType.equals(other.bioType))
			return false;
		if (canonicalTranslationId == null) {
			if (other.canonicalTranslationId != null)
				return false;
		} else if (!canonicalTranslationId.equals(other.canonicalTranslationId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (displayXrefId == null) {
			if (other.displayXrefId != null)
				return false;
		} else if (!displayXrefId.equals(other.displayXrefId))
			return false;
		if (geneId == null) {
			if (other.geneId != null)
				return false;
		} else if (!geneId.equals(other.geneId))
			return false;
		if (isCurrent != other.isCurrent)
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
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (stable_id == null) {
			if (other.stable_id != null)
				return false;
		} else if (!stable_id.equals(other.stable_id))
			return false;
		if (transcriptId == null) {
			if (other.transcriptId != null)
				return false;
		} else if (!transcriptId.equals(other.transcriptId))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
