package com.example.demoCURD.mapper;

import org.mapstruct.Mapper;

import com.example.demoCURD.domain.BedType;
import com.example.demoCURD.dto.BedTypeDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BedTypeMapper extends EntityMapper<BedTypeDTO, BedType> {

}
