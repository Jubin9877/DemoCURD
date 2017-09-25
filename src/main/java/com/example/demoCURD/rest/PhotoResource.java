package com.example.demoCURD.rest;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoCURD.dto.PhotoDTO;
import com.example.demoCURD.dto.PropertyDTO;
import com.example.demoCURD.service.PhotoService;

@RestController
@RequestMapping("/api")
public class PhotoResource {

	private final Logger log = LoggerFactory.getLogger(PropertyResource.class);
	private static final String ENTITY_NAME = "property";

	private final PhotoService photoService;

	public PhotoResource(PhotoService photoService) {
		this.photoService = photoService;
	}

	@PostMapping("/property/{id}/photo")
	public PhotoDTO createProperty(@Valid @RequestBody PhotoDTO photoDTO, @PathVariable Long id)
			throws URISyntaxException {
		PhotoDTO result = photoService.create(photoDTO, id);
		return result;
	}

	@DeleteMapping("/photo/{id}")
	public void deletePhoto(@PathVariable Long id) {
		log.debug("REST request to delete Property : {}", id);
		photoService.delete(id);
	}
}
