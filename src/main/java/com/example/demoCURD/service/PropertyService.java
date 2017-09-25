package com.example.demoCURD.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demoCURD.domain.BedType;
import com.example.demoCURD.domain.Photo;
import com.example.demoCURD.domain.Property;
import com.example.demoCURD.dto.BedTypeDTO;
import com.example.demoCURD.dto.PhotoDTO;
import com.example.demoCURD.dto.PropertyDTO;
import com.example.demoCURD.dto.PropertyBadTypeDTO;
import com.example.demoCURD.enumeration.Status;
import com.example.demoCURD.repository.BedTypeRepository;
import com.example.demoCURD.repository.PhotoRepository;
import com.example.demoCURD.repository.PropertyRepository;

@Service
public class PropertyService {

	private final Logger log = LoggerFactory.getLogger(PropertyService.class);

	private final PropertyRepository propertyRepository;
	private final BedTypeRepository bedTypeRepository;

	private final PhotoRepository photoRepository;

	public PropertyService(PropertyRepository propertyRepository, PhotoRepository photoRepository,
			BedTypeRepository bedTypeRepository) {
		this.propertyRepository = propertyRepository;
		this.photoRepository = photoRepository;
		this.bedTypeRepository = bedTypeRepository;
	}

	public PropertyDTO create(PropertyDTO propertyDTO) {

		Property property = new Property();
		property.setTitle(propertyDTO.getTitle());
		property.setStatus(Status.ACTIVE);
		propertyRepository.save(property);

		PropertyDTO propertydto = new PropertyDTO();
		propertydto.setId(property.getId());
		propertydto.setTitle(property.getTitle());
		propertydto.setStatus(Status.ACTIVE);
		return propertydto;

	}

	public List<PropertyDTO> findAll() {
		log.debug("Request to get all BedTypes");
		List<Property> property = propertyRepository.findAll();
		List<PropertyDTO> propertyDto = new ArrayList<>();
		//List<PhotoDTO> photoDTO = new ArrayList<>();
		
		for (Property pro : property) {
			PropertyDTO propertydto = new PropertyDTO();
			propertydto.setId(pro.getId());
			propertydto.setTitle(pro.getTitle());
			propertydto.setStatus(pro.getStatus());

			List<PhotoDTO> photoDTO = new ArrayList<>();
			for (Photo photo : pro.getPhotos()) {
				PhotoDTO photodto = new PhotoDTO();
				photodto.setId(photo.getId());
				photodto.setName(photo.getName());
				photoDTO.add(photodto);
			}
			propertydto.setPhotos(photoDTO);
			propertyDto.add(propertydto);
		}
		return propertyDto;
	}

	public PropertyDTO updatepropert_bedtype(PropertyBadTypeDTO property_bedtypeDTO) {

		Property property = propertyRepository.findOne(property_bedtypeDTO.getPropertyId());

		BedType bedtype = bedTypeRepository.findOne(property_bedtypeDTO.getBedtypeId());

		Set<BedType> bedTypes = property.getBedType();
		if (bedtype == null) {
			bedTypes = new HashSet<>();
		}
		bedTypes.add(bedtype);

		property.setBedType(bedTypes);

		propertyRepository.save(property);

		PropertyDTO propertydto = new PropertyDTO();
		propertydto.setId(property.getId());
		propertydto.setTitle(property.getTitle());
		propertydto.setStatus(property.getStatus());

		List<BedTypeDTO> bedTypeList = new ArrayList<>();
		for (BedType bed : property.getBedType()) {
			BedTypeDTO bedtypedto = new BedTypeDTO();
			bedtypedto.setId(bed.getId());
			bedTypeList.add(bedtypedto);
		}

		propertydto.setBedTypes(bedTypeList);
		return propertydto;
	}

	public void delete(Long propertiesid , Long bedtypesid) {
		
		Property property = propertyRepository.findOne(propertiesid);
		BedType bedtype = bedTypeRepository.findOne(bedtypesid);
		bedTypeRepository.delete(bedtype);

	}
}
