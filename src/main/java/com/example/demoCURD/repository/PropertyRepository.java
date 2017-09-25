package com.example.demoCURD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demoCURD.domain.Property;


public interface PropertyRepository extends JpaRepository<Property,Long>, JpaSpecificationExecutor<Property> {

}
