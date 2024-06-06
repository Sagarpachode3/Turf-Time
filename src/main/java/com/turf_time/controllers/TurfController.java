package com.turf_time.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turf_time.dtos.TurfDto;
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
	public ResponseEntity<TurfDto> registerTurf(@Valid @RequestBody TurfDto turfDto){
		TurfDto registeredTurf = turfService.registerTurf(turfDto);
		return new ResponseEntity<>(registeredTurf, HttpStatus.CREATED);
	}

}
