package com.ensemble.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/**
 * Base class of entity. 
 * @author sarfraz
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
	@CreatedDate
	@Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", updatable = false, name="created_date")
	protected Timestamp createdDate;
	
	@LastModifiedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", name = "modified_date")
    protected Timestamp modifiedDate;

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModifiedDate() {
		return modifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.modifiedDate = lastModifiedDate;
	}
}
