package com.example.demoCURD.dto;

import java.io.Serializable;

public class PropertyBadTypeDTO implements Serializable {

	private Long propertyId;
	
	private Long bedtypeId;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public Long getBedtypeId() {
		return bedtypeId;
	}

	public void setBedtypeId(Long bedtypeId) {
		this.bedtypeId = bedtypeId;
	}

	
}
