package com.example.demoCURD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoCURD.domain.BedType;



public interface BedTypeRepository extends JpaRepository<BedType, Long>{

	BedType findByName(String name);
	List<BedType> findByActiveTrue();
}
