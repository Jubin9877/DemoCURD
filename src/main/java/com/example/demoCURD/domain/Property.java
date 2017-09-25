package com.example.demoCURD.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demoCURD.enumeration.Status;

@Entity
@Table(name = "property")
public class Property implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 100)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "property")
	private List<Photo> photos;

	@ManyToMany()
	@JoinTable(name = "property_bedtype", joinColumns = @JoinColumn(name = "propertyid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "bedtypeid", referencedColumnName = "id"))
	private Set<BedType> bedType = new HashSet<>();

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

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Set<BedType> getBedType() {
		return bedType;
	}

	public void setBedType(Set<BedType> bedType) {
		this.bedType = bedType;
	}
	
	

}
