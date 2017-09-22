package com.example.demoCURD.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass

public class AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@CreatedBy
	@Column(name = "created_by", nullable = false,length = 50, updatable = false)
	
	private String createdby;
	
	@CreatedBy
	@Column(name = "created_date", nullable = false)
	
	private Instant createdDate = Instant.now();
	
	@LastModifiedBy
	@Column(name = "last_modified_by",length = 50)
	
	private String lastModifiedBy;
	
	@LastModifiedDate
    @Column(name = "last_modified_date")
    
    private Instant lastModifiedDate = Instant.now();

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
