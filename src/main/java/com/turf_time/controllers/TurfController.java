package com.turf_time.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turf_time.dtos.TurfDto;
import com.turf_time.payloads.ApiResponse;
import com.turf_time.services.TurfService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turfs")
public class TurfController {

	private TurfService turfService;

	public TurfController(TurfService turfService) {
		super();
		this.turfService = turfService;
	}

	@PostMapping("/register")
	public ResponseEntity<TurfDto> registerTurf(@Valid @RequestBody TurfDto turfDto) {
		TurfDto registeredTurf = turfService.registerTurf(turfDto);
		return new ResponseEntity<>(registeredTurf, HttpStatus.CREATED);
	}

	@PutMapping("/update/{turfId}")
	public ResponseEntity<TurfDto> updateTurfDetails(@Valid @RequestBody TurfDto turfDto,
			@PathVariable Integer turfId) {

		TurfDto updatedTurf = turfService.updateTurf(turfDto, turfId);
		return new ResponseEntity<>(updatedTurf, HttpStatus.OK);
	}

	@GetMapping("/getturf/{turfId}")
	public ResponseEntity<TurfDto> getTurfByTurfId(@PathVariable Integer turfId) {
		TurfDto turfDto = turfService.getTurfByTurfId(turfId);
		return new ResponseEntity<>(turfDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TurfDto>> getAllTurfs() {
		List<TurfDto> turfs = turfService.getAllTurfs();
		return new ResponseEntity<>(turfs, HttpStatus.OK);
	}

	@GetMapping("/manager/{managerId}")
	public ResponseEntity<List<TurfDto>> getTurfByManagerId(@PathVariable Integer managerId) {
		List<TurfDto> turfs = turfService.getTurfByManagerId(managerId);
		return new ResponseEntity<>(turfs, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{turfId}")
	public ResponseEntity<ApiResponse> deleteTurf(@PathVariable Integer turfId) {
		turfService.deleteTurf(turfId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Turf deleted Successfully", true),
				HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<TurfDto>> getTurfsByCriteria(@RequestParam(required = false) String name,
			@RequestParam(required = false) String country, @RequestParam(required = false) String state,
			@RequestParam(required = false) String district, @RequestParam(required = false) String tahsil,
			@RequestParam(required = false) String city) {

		List<TurfDto> turfs = null;

		if (name != null) {
			turfs = turfService.getTurfByName(name);
		} else if (country != null) {
			turfs = turfService.getTurfByCountry(country);
		} else if (state != null) {
			turfs = turfService.getTurfByState(state);
		} else if (district != null) {
			turfs = turfService.getTurfByDistrict(district);
		} else if (tahsil != null) {
			turfs = turfService.getTurfByTahsil(tahsil);
		} else if (city != null) {
			turfs = turfService.getTurfByCity(city);
		}

		return new ResponseEntity<>(turfs, HttpStatus.OK);
	}

}
