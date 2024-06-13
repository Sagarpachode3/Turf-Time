package com.turf_time.controllers;

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

import com.turf_time.dtos.ActiveStatusDto;
import com.turf_time.payloads.ApiResponse;
import com.turf_time.services.ActiveStatusService;

@RestController
@RequestMapping("/api/activestatus")
public class ActiveStatusController {

	ActiveStatusService activeStatusService;

	@Autowired
	public ActiveStatusController(ActiveStatusService activeStatusService) {
		super();
		this.activeStatusService = activeStatusService;
	}

	@PostMapping("/create")
	ResponseEntity<ActiveStatusDto> createActiveStatus(@RequestBody ActiveStatusDto activeStatusDto) {

		ActiveStatusDto activeStatus = activeStatusService.createActiveStatus(activeStatusDto);

		return new ResponseEntity<>(activeStatus, HttpStatus.CREATED);
	}

	@GetMapping("/getstatus/{activeStatusId}")
	ResponseEntity<ActiveStatusDto> getActiveStatus(@PathVariable Integer activeStatusId) {
		ActiveStatusDto activeStatus = activeStatusService.getActiveStatus(activeStatusId);
		return ResponseEntity.ok(activeStatus);
	}

	@PutMapping("/update/{activeStatusId}")
	ResponseEntity<ActiveStatusDto> updateActiveStatus(@RequestBody ActiveStatusDto activeStatusDto,
			@PathVariable Integer activeStatusId) {
		ActiveStatusDto updatedActiveStatus = activeStatusService.updateActiveStatus(activeStatusDto, activeStatusId);
		return ResponseEntity.ok(updatedActiveStatus);
	}

	@DeleteMapping("/delete/{activeStatusId}")
	ResponseEntity<ApiResponse> deleteActiveStatus(@PathVariable Integer activeStatusId) {
		activeStatusService.deleteActiveStatus(activeStatusId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Status Deleted Succesfully", true), HttpStatus.OK);
	}

}
