package com.example.demoCURD.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoCURD.dto.PropertyBadTypeDTO;
import com.example.demoCURD.dto.PropertyDTO;
import com.example.demoCURD.service.PropertyService;

@RestController
@RequestMapping("/api")
public class PropertyResource {

	private final Logger log = LoggerFactory.getLogger(PropertyResource.class);
	private static final String ENTITY_NAME = "property";

	private final PropertyService propertyService;

	public PropertyResource(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@PostMapping("/property")
	public PropertyDTO createProperty(@Valid @RequestBody PropertyDTO propertyDTO) throws URISyntaxException {
		PropertyDTO result = propertyService.create(propertyDTO);
		return result;
	}

	@GetMapping("/property")
	public List<PropertyDTO> getAllProperty() {
		log.debug("REST request to get all BedTypes");
		return propertyService.findAll();
	}

	@PostMapping("/propertybedtype")
	public PropertyDTO updateCourse(@RequestBody PropertyBadTypeDTO propertybedtypedto) {
		PropertyDTO result = propertyService.updatepropert_bedtype(propertybedtypedto);
		return result;
	}
	
	@DeleteMapping("/propertybedtype/{propertiesid}/bedtypes/{bedtypesid}")
	public void delteBedType(@PathVariable Long propertiesid , @PathVariable Long bedtypesid) {
		log.debug("REST request to Delete BedType : {}");
		propertyService.delete(propertiesid , bedtypesid );
	}
}
