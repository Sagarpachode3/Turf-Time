package com.turf_time.controllers;

import com.turf_time.dtos.TurfAddressDto;
import com.turf_time.payloads.ApiResponse;
import com.turf_time.services.TurfAddressService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turfAddresses")
public class TurfAddressController {

	@Autowired
	private TurfAddressService turfAddressService;

	@PostMapping("/register")
	public ResponseEntity<TurfAddressDto> registerAddress(@Valid @RequestBody TurfAddressDto turfAddressDto) {
		TurfAddressDto createdTurfAddress = turfAddressService.registerAddress(turfAddressDto);

		return new ResponseEntity<>(createdTurfAddress, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TurfAddressDto> getTurfAddress(@PathVariable Integer id) {
		TurfAddressDto turfAddress = turfAddressService.getTurfAddress(id);
		
		return ResponseEntity.ok(turfAddress);
	}

	@GetMapping("/get/")
	public ResponseEntity<List<TurfAddressDto>> getAllTurfAddresses() {
		List<TurfAddressDto> turfAddresses = turfAddressService.getAllTurfAddresses();
		
		return ResponseEntity.ok(turfAddresses);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TurfAddressDto> updateTurfAddress(@Valid @RequestBody TurfAddressDto turfAddressDto,
			@PathVariable Integer id) {
		TurfAddressDto updatedTurfAddress = turfAddressService.updateTurfAddress(turfAddressDto, id);
		
		return ResponseEntity.ok(updatedTurfAddress);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteTurfAddress(@PathVariable Integer id) {
		turfAddressService.deleteTurfAddress(id);
		
		return new ResponseEntity<>(new ApiResponse("Address deleted Successfully", true), HttpStatus.OK);
	}
}
