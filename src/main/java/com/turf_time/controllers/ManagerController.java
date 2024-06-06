package com.turf_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turf_time.dtos.ManagerDto;
import com.turf_time.services.ManagerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
	
	private ManagerService managerService;
	
	@Autowired
	public ManagerController(ManagerService managerService) {
		super();
		this.managerService = managerService;
	}

	@PostMapping("/register")
	ResponseEntity<ManagerDto> registerManager(@Valid @RequestBody ManagerDto managerDto){
		ManagerDto registeredManager = managerService.registerManager(managerDto);
		return new ResponseEntity<>(registeredManager, HttpStatus.CREATED);
	}
}
