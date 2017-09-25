package com.example.demoCURD.dto;

import java.io.Serializable;

public class PhotoDTO implements Serializable {

	 private Long id;

	    private String name;
	    //private Long propertId;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

//		public Long getPropertId() {
//			return propertId;
//		}
//
//		public void setPropertId(Long propertId) {
//			this.propertId = propertId;
//		}

		
		
}
