package com.example.demoCURD.mapper;

import org.mapstruct.Mapper;

import com.example.demoCURD.domain.Photo;
import com.example.demoCURD.dto.PhotoDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PhotoMapper extends EntityMapper<PhotoDTO, Photo> {

}
