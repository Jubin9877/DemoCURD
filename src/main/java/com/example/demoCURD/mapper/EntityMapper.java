package com.example.demoCURD.mapper;

import java.util.List;

import org.mapstruct.Mapping;

public interface EntityMapper<D, E> {

	public E toEntity(D dto);

	
	public D toDto(E entity);

	public List<E> toEntity(List<D> dtoList);

	public List<D> toDto(List<E> entityList);

}
