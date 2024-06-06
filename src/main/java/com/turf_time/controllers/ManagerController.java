package com.turf_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<ManagerDto> registerManager(@Valid @RequestBody ManagerDto managerDto){
		ManagerDto registeredManager = managerService.registerManager(managerDto);
		return new ResponseEntity<>(registeredManager, HttpStatus.CREATED);
	}

	@PutMapping("/update/{managerId}")
	public ResponseEntity<ManagerDto> updateManagerDetails(@Valid @RequestBody ManagerDto managerDto, @PathVariable Integer managerId){
		
		ManagerDto updatedManagerDetails = managerService.updateManagerDetails(managerId, managerDto);
		return ResponseEntity.ok(updatedManagerDetails);
	}
}
