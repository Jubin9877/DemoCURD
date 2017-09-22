package com.example.demoCURD.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demoCURD.domain.BedType;
import com.example.demoCURD.dto.BedTypeDTO;
import com.example.demoCURD.repository.BedTypeRepository;

@Service
public class BedTypeService {

	private final Logger log = LoggerFactory.getLogger(BedTypeService.class);

	private BedTypeRepository bedTypeRepository;

	public BedTypeService(BedTypeRepository bedTypeRepository) {
		this.bedTypeRepository = bedTypeRepository;

	}

	public BedTypeDTO save(BedTypeDTO bedTypeDTO) {
		log.info("Request to save BedType : {}", bedTypeDTO);

		BedType bedType = new BedType();
		bedType.setId(bedTypeDTO.getId());
		bedType.setName(bedTypeDTO.getName());
		bedType.setImageUrl(bedTypeDTO.getImageUrl());
		bedType.setActive(Boolean.TRUE);
		bedTypeRepository.save(bedType);

		BedTypeDTO bedtypedto = new BedTypeDTO();
		bedtypedto.setId(bedType.getId());
		bedtypedto.setName(bedType.getName());
		bedtypedto.setImageUrl(bedType.getImageUrl());
		bedtypedto.setActive(Boolean.TRUE);
		return bedtypedto;
	}

	public BedTypeDTO findOne(Long id) {
		log.info("Request to get BedType : {}", id);
		BedType bedType = bedTypeRepository.findOne(id);

		BedTypeDTO bedtypedto = new BedTypeDTO();
		bedtypedto.setId(bedType.getId());
		bedtypedto.setName(bedType.getName());
		bedtypedto.setImageUrl(bedType.getImageUrl());
		return bedtypedto;
	}

	public void delete(Long id) {
		log.info("Request to Delete BedType : {}", id);
		BedType bedType = bedTypeRepository.findOne(id);
		bedTypeRepository.delete(id);
	}

	public List<BedTypeDTO> findAll(String q) {
		log.debug("Request to get all BedTypes");
		List<BedType> beds = bedTypeRepository.findAll();
		List<BedTypeDTO> bedsDto = new ArrayList<>();

		for (BedType bedType : beds) {
			BedTypeDTO bedtypedto = new BedTypeDTO();
			bedtypedto.setId(bedType.getId());
			bedtypedto.setName(bedType.getName());
			bedtypedto.setImageUrl(bedType.getImageUrl());
			bedtypedto.setActive(bedType.isActive());
			bedsDto.add(bedtypedto);
		}
		return bedsDto;

	}

	public BedTypeDTO updateActivation(Long id, Boolean active) {
		log.debug("Request to update activation for instrument : {}", active);
		BedType bedType = bedTypeRepository.findOne(id);
		if(bedType == null) {
			throw new IllegalArgumentException("Id is not valid");
		}

		bedType.setActive(active);
		bedTypeRepository.save(bedType);
		BedTypeDTO bedtypedto = new BedTypeDTO();
		bedtypedto.setId(id);
		bedtypedto.setName(bedType.getName());
		bedtypedto.setImageUrl(bedType.getImageUrl());
		bedtypedto.setActive(bedType.isActive());
		return bedtypedto;

	}
	public List<BedTypeDTO> findAllActive(String q){
		List<BedType> beds = bedTypeRepository.findByActiveTrue();
		List<BedTypeDTO> bedsDto = new ArrayList<>();
		for (BedType bedType : beds) {
			BedTypeDTO bedtypedto = new BedTypeDTO();
			bedtypedto.setId(bedType.getId());
			bedtypedto.setName(bedType.getName());
			bedtypedto.setImageUrl(bedType.getImageUrl());
			bedtypedto.setActive(bedType.isActive());
			bedsDto.add(bedtypedto);
		}
		return bedsDto;
		
	}
}
