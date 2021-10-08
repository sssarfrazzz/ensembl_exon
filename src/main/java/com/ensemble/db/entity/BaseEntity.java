package com.ensemble.db.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id",nullable = false)
	String id;
	
	@CreatedDate
	@Column(name="created_ts")
	Long created_ts;
	
	@Column(name="updated_ts")
	@LastModifiedDate
	Long updated_ts;
	
	public BaseEntity() {
		this.id=UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_ts == null) ? 0 : created_ts.hashCode());
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
		BaseEntity other = (BaseEntity) obj;
		if (created_ts == null) {
			if (other.created_ts != null)
				return false;
		} else if (!created_ts.equals(other.created_ts))
			return false;
		return true;
	}
	
	
}
