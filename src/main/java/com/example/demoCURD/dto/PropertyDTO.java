package com.example.demoCURD.dto;

import java.util.List;

import com.example.demoCURD.enumeration.Status;

public class PropertyDTO {

	private Long id;

	private String title;
	private Status status;
	private List<PhotoDTO> photos;
	List<BedTypeDTO> bedTypes;

	

	public List<BedTypeDTO> getBedTypes() {
		return bedTypes;
	}

	public void setBedTypes(List<BedTypeDTO> bedTypes) {
		this.bedTypes = bedTypes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<PhotoDTO> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoDTO> photos) {
		this.photos = photos;
	}

}
