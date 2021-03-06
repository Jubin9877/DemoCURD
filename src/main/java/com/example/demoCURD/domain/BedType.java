package com.example.demoCURD.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class BedType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=45)
	@Column(name="name",length = 45)
	private String name;
	
	@Size(max = 2083)
    @Column(name = "image_url", length = 2083)
    private String imageUrl;
	
	@Column(name = "active")
    private Boolean active;
	
	@ManyToMany()
	@JoinTable(name = "property_bedtype", joinColumns = @JoinColumn(name = "bedtypeid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "propertyid", referencedColumnName = "id"))
	private Set<Property> property = new HashSet<>();
	
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
	

	

	public Set<Property> getProperty() {
		return property;
	}

	public void setProperty(Set<Property> property) {
		this.property = property;
	}

	@Override
    public String toString() {
        return "BedType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }
	
}
