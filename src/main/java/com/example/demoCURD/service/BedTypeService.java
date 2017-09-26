package com.example.demoCURD.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demoCURD.domain.BedType;
import com.example.demoCURD.dto.BedTypeDTO;
import com.example.demoCURD.mapper.BedTypeMapper;
import com.example.demoCURD.repository.BedTypeRepository;

@Service
public class BedTypeService {

	private final Logger log = LoggerFactory.getLogger(BedTypeService.class);

	private BedTypeRepository bedTypeRepository;
	private final BedTypeMapper bedTypeMapper;

	public BedTypeService(BedTypeRepository bedTypeRepository, BedTypeMapper bedTypeMapper) {
		this.bedTypeRepository = bedTypeRepository;
		this.bedTypeMapper = bedTypeMapper;
	}

	public BedTypeDTO save(BedTypeDTO bedTypeDTO) {
		log.info("Request to save BedType : {}", bedTypeDTO);

		/* without mapper */
		// BedType bedType = new BedType();
		// bedType.setId(bedTypeDTO.getId());
		// bedType.setName(bedTypeDTO.getName());
		// bedType.setImageUrl(bedTypeDTO.getImageUrl());

		/* Use Of Mapper */
		BedType bedType = bedTypeMapper.toEntity(bedTypeDTO);
		bedType.setActive(Boolean.TRUE);
		bedTypeRepository.save(bedType);

		/* Without Mapper */
		// BedTypeDTO bedtypedto = new BedTypeDTO();
		// bedtypedto.setId(bedType.getId());
		// bedtypedto.setName(bedType.getName());
		// bedtypedto.setImageUrl(bedType.getImageUrl());
		// bedtypedto.setActive(Boolean.TRUE);

		/* Use of Mapper */
		return bedTypeMapper.toDto(bedType);
	}

	public BedTypeDTO findOne(Long id) {
		log.info("Request to get BedType : {}", id);
		BedType bedType = bedTypeRepository.findOne(id);

		return bedTypeMapper.toDto(bedType);
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
			BedTypeDTO bedtypedto = bedTypeMapper.toDto(bedType);
			bedsDto.add(bedtypedto);
		}
		return bedsDto;

	}

	public BedTypeDTO updateActivation(Long id, Boolean active) {
		log.debug("Request to update activation for instrument : {}", active);
		BedType bedType = bedTypeRepository.findOne(id);
		if (bedType == null) {
			throw new IllegalArgumentException("Id is not valid");
		}
		bedType.setActive(active);
		bedTypeRepository.save(bedType);
		return bedTypeMapper.toDto(bedType);

	}

	public List<BedTypeDTO> findAllActive(String q) {
		List<BedType> beds = bedTypeRepository.findByActiveTrue();
		List<BedTypeDTO> bedsDto = new ArrayList<>();
		for (BedType bedType : beds) {
			BedTypeDTO bedtypedto = bedTypeMapper.toDto(bedType);
			// bedtypedto.setId(bedType.getId());
			// bedtypedto.setName(bedType.getName());
			// bedtypedto.setImageUrl(bedType.getImageUrl());
			// bedtypedto.setActive(bedType.isActive());
			bedsDto.add(bedtypedto);
		}
		return bedsDto;

	}
}
