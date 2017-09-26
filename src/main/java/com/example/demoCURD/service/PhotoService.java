package com.example.demoCURD.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demoCURD.domain.BedType;
import com.example.demoCURD.domain.Photo;
import com.example.demoCURD.domain.Property;
import com.example.demoCURD.dto.PhotoDTO;
import com.example.demoCURD.mapper.PhotoMapper;
import com.example.demoCURD.repository.PhotoRepository;
import com.example.demoCURD.repository.PropertyRepository;

@Service
public class PhotoService {

	private final Logger log = LoggerFactory.getLogger(PhotoService.class);

	private final PropertyRepository propertyRepository;
	private final PhotoRepository photoRepository;
	private final PhotoMapper photoMapper;

	public PhotoService(PhotoRepository photoRepository, PropertyRepository propertyRepository,
			PhotoMapper photoMapper) {
		this.photoRepository = photoRepository;
		this.propertyRepository = propertyRepository;
		this.photoMapper = photoMapper;
	}

	public PhotoDTO create(PhotoDTO photoDTO, Long id) {

		Property property = propertyRepository.findOne(id);

		Photo photo = photoMapper.toEntity(photoDTO);
		// photo.setName(photoDTO.getName());
		photo.setProperty(property);
		photoRepository.save(photo);

		// PhotoDTO photodto = new PhotoDTO();
		// photodto.setId(photo.getId());
		// photodto.setName(photo.getName());
		// photodto.setPropertId(photo.getProperty().getId());
		return photoMapper.toDto(photo);
	}

	public void delete(Long id) {
		log.info("Request to Delete Photo : {}", id);
		Photo photo = photoRepository.findOne(id);
		photoRepository.delete(id);
	}

}
