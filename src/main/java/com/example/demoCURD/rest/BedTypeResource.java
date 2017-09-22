package com.example.demoCURD.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demoCURD.dto.BedTypeDTO;
import com.example.demoCURD.service.BedTypeService;

@RestController
@RequestMapping("/api")
public class BedTypeResource {

	// @Autowired
	// private MessageSource messageSource;

	private final Logger log = LoggerFactory.getLogger(BedTypeResource.class);
	private static final String ENTITY_NAME = "bedType";

	private final BedTypeService bedTypeService;

	public BedTypeResource(BedTypeService bedTypeService) {
		this.bedTypeService = bedTypeService;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo handleTypeIllegalArgumentException(HttpServletRequest req, IllegalArgumentException ex) {
		String errorMessage = ex.getMessage();
		String errorURL = req.getRequestURL().toString();

		return new ErrorInfo(errorURL, errorMessage);
	}

	@PostMapping("/bed-types")
	public BedTypeDTO createBedType(@Valid @RequestBody BedTypeDTO bedTypeDTO) throws URISyntaxException {
		log.debug("REST request to save BedType : {}", bedTypeDTO);
		if (bedTypeDTO.getId() != null) {

		}
		BedTypeDTO result = bedTypeService.save(bedTypeDTO);
		return result;
	}

	@PutMapping("/bed-types")
	public BedTypeDTO updatedBedType(@Valid @RequestBody BedTypeDTO bedTypeDTO) throws URISyntaxException {
		log.debug("REST request to update BedType : {}", bedTypeDTO);
		if (bedTypeDTO.getId() != null) {

		}
		BedTypeDTO result = bedTypeService.save(bedTypeDTO);
		return result;
	}

	@GetMapping("/bed-types/{id}")
	public BedTypeDTO getBedType(@PathVariable Long id) {
		log.debug("REST request to get BedType : {}", id);
		if (id == 0) {
			throw new IllegalArgumentException("Id is not valid");
		}
		BedTypeDTO bedTypeDTO = bedTypeService.findOne(id);
		return bedTypeDTO;
	}

	@DeleteMapping("/bed-types/{id}")
	public void delteBedType(@PathVariable Long id) {
		log.debug("REST request to Delete BedType : {}", id);
		bedTypeService.delete(id);
	}

	@GetMapping("/bed-types")
	public List<BedTypeDTO> getAllBedTypes(@RequestParam(required = false) String q) {
		log.debug("REST request to get all BedTypes");
		return bedTypeService.findAll(q);
	}

	@PutMapping("/bed-types/{id}")
	public BedTypeDTO updateActivation(@PathVariable Long id, @RequestParam Boolean active) {
		log.debug("REST request to update BedType : {} activation", id);
		BedTypeDTO result = bedTypeService.updateActivation(id, active);
		return result;
	}

	@GetMapping("/bed-types/active")
	public List<BedTypeDTO> getAllBedTypeActive(@RequestParam(required = false) String q) {
		log.debug("REST request to get all BedTypes");
		return bedTypeService.findAllActive(q);
	}
}
