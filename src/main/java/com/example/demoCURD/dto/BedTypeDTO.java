package com.example.demoCURD.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;





public class BedTypeDTO  implements Serializable {
	
	private Long id;

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Size(max = 45)
    private String name;

    @Size(max = 2083)
    private String imageUrl;

    private Boolean active;
    
    @Override
    public String toString() {
        return "BedTypeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }

}
