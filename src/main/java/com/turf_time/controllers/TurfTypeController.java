package com.turf_time.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turf_time.dtos.TurfTypeDto;
import com.turf_time.payloads.ApiResponse;
import com.turf_time.services.TurfTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turftypes")
public class TurfTypeController {

	private final TurfTypeService turfTypeService;

	@Autowired
	public TurfTypeController(TurfTypeService turfTypeService) {
		this.turfTypeService = turfTypeService;
	}

	@PostMapping("/create")
	public ResponseEntity<TurfTypeDto> createTurfType(@Valid @RequestBody TurfTypeDto turfTypeDto) {
		TurfTypeDto createdTurfType = turfTypeService.createTurfType(turfTypeDto);

		return new ResponseEntity<>(createdTurfType, HttpStatus.CREATED);
	}

	@GetMapping("/get/{turfTypeId}")
	public ResponseEntity<TurfTypeDto> getTurfTypeById(@PathVariable Integer turfTypeId) {
		TurfTypeDto turfType = turfTypeService.getTurfTypeById(turfTypeId);
		return ResponseEntity.ok(turfType);
	}

	@GetMapping("/get/")
	public ResponseEntity<List<TurfTypeDto>> getAllTurfTypes() {
		List<TurfTypeDto> turfTypes = turfTypeService.getAllTurfTypes();

		return ResponseEntity.ok(turfTypes);
	}

	@PutMapping("/update/{turfTypeId}")
	public ResponseEntity<TurfTypeDto> updateTurfType(@Valid @RequestBody TurfTypeDto turfTypeDto,
			@PathVariable Integer turfTypeId) {
		TurfTypeDto updatedTurfType = turfTypeService.updateTurfType(turfTypeId, turfTypeDto);
		return ResponseEntity.ok(updatedTurfType);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteTurfType(@PathVariable Integer turfTypeId) {
		turfTypeService.deleteTurfType(turfTypeId);
		return new ResponseEntity<>(new ApiResponse("Turf type deleted Successfully", true), HttpStatus.OK);
	}
}
