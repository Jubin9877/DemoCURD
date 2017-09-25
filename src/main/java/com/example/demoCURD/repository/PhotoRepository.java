package com.example.demoCURD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoCURD.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long>{

}
