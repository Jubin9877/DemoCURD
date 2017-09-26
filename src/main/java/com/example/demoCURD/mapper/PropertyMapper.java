package com.example.demoCURD.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demoCURD.domain.Property;
import com.example.demoCURD.dto.PhotoDTO;
import com.example.demoCURD.dto.PropertyDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PropertyMapper {

	@Mapping(target = "photos", ignore = true)
	public Property toEntity(PropertyDTO dto);

	@Mapping(target = "photos", ignore = true)
	public PropertyDTO toDto(Property entity);
}
