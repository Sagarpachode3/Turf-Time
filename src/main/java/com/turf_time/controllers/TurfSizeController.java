package com.turf_time.controllers;

import com.turf_time.dtos.TurfSizeDto;
import com.turf_time.payloads.ApiResponse;
import com.turf_time.services.TurfSizeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turfSizes")
public class TurfSizeController {

	@Autowired
	private TurfSizeService turfSizeService;

	@PostMapping("/create")
	public ResponseEntity<TurfSizeDto> createTurfSize(@Valid @RequestBody TurfSizeDto turfSizeDto) {
		TurfSizeDto createdTurfSize = turfSizeService.createTurfSize(turfSizeDto);
		return new ResponseEntity<>(createdTurfSize, HttpStatus.CREATED);
	}

	@GetMapping("/getsize/{id}")
	public ResponseEntity<TurfSizeDto> getTurfSizeById(@PathVariable Integer id) {
		TurfSizeDto turfSize = turfSizeService.getTurfSizeById(id);
		return ResponseEntity.ok(turfSize);
	}

	@GetMapping("/")
	public ResponseEntity<List<TurfSizeDto>> getAllTurfSizes() {
		List<TurfSizeDto> turfSizes = turfSizeService.getAllTurfSizes();
		return ResponseEntity.ok(turfSizes);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TurfSizeDto> updateTurfSize(@Valid @RequestBody TurfSizeDto turfSizeDto,
			@PathVariable Integer id) {
		TurfSizeDto updatedTurfSize = turfSizeService.updateTurfSize(id, turfSizeDto);
		return ResponseEntity.ok(updatedTurfSize);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteTurfSize(@PathVariable Integer id) {
		turfSizeService.deleteTurfSize(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Turf size deleted Successfully", true), HttpStatus.OK);
	}
}
