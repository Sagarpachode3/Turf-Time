package com.turf_time.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.turf_time.dtos.BookingDto;
import com.turf_time.dtos.ManagerDto;
import com.turf_time.dtos.TurfDto;
import com.turf_time.dtos.UserDto;
import com.turf_time.services.ManagerService;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	// Manager registration
	@PostMapping("/register")
	public ResponseEntity<ManagerDto> registerManager(@RequestBody ManagerDto managerDto) {
		ManagerDto registeredManager = managerService.registerManager(managerDto);
		return ResponseEntity.ok(registeredManager);
	}

	// Manager login
	@PostMapping("/login")
	public ResponseEntity<ManagerDto> loginManager(@RequestParam String email, @RequestParam String password) {
		ManagerDto managerDto = managerService.loginManager(email, password);
		return ResponseEntity.ok(managerDto);
	}

	// Get manager by ID
	@GetMapping("/get/{managerId}")
	public ResponseEntity<ManagerDto> getManagerById(@PathVariable Integer managerId) {
		ManagerDto managerDto = managerService.getManagerById(managerId);
		return ResponseEntity.ok(managerDto);
	}

	// Get all managers
	@GetMapping("/getmanagers")
	public ResponseEntity<List<ManagerDto>> getAllManagers() {
		List<ManagerDto> managers = managerService.getAllManagers();
		return ResponseEntity.ok(managers);
	}

	// Update manager details
	@PutMapping("/update/{managerId}")
	public ResponseEntity<ManagerDto> updateManager(@PathVariable Integer managerId,
			@RequestBody ManagerDto managerDto) {
		ManagerDto updatedManager = managerService.updateManager(managerId, managerDto);
		return ResponseEntity.ok(updatedManager);
	}

	// Delete manager
	@DeleteMapping("/delete/{managerId}")
	public ResponseEntity<Void> deleteManager(@PathVariable Integer managerId) {
		managerService.deleteManager(managerId);
		return ResponseEntity.noContent().build();
	}

	// Add turf
	@PostMapping("/addturf/{managerId}/turfs")
	public ResponseEntity<TurfDto> addTurf(@PathVariable Integer managerId, @RequestBody TurfDto turfDto) {
		TurfDto addedTurf = managerService.addTurf(managerId, turfDto);
		return ResponseEntity.ok(addedTurf);
	}

	// Update turf
	@PutMapping("/updateturf/{managerId}/turfs/{turfId}")
	public ResponseEntity<TurfDto> updateTurf(@PathVariable Integer managerId, @PathVariable Integer turfId,
			@RequestBody TurfDto turfDto) {
		TurfDto updatedTurf = managerService.updateTurf(managerId, turfId, turfDto);
		return ResponseEntity.ok(updatedTurf);
	}

	// Get turfs by manager
	@GetMapping("/getturf/{managerId}/turfs")
	public ResponseEntity<List<TurfDto>> getTurfsByManager(@PathVariable Integer managerId) {
		List<TurfDto> turfs = managerService.getTurfsByManager(managerId);
		return ResponseEntity.ok(turfs);
	}

	// Get users by manager
	@GetMapping("/getuser/{managerId}/users")
	public ResponseEntity<List<UserDto>> getUsersByManager(@PathVariable Integer managerId) {
		List<UserDto> users = managerService.getUsersByManager(managerId);
		return ResponseEntity.ok(users);
	}

	// Book turf on behalf of customer
	@PostMapping("/bookturf/{managerId}/bookings")
	public ResponseEntity<BookingDto> bookTurfOnBehalfOfCustomer(@PathVariable Integer managerId,
			@RequestBody BookingDto bookingDto) {
		BookingDto booking = managerService.bookTurfOnBehalfOfCustomer(managerId, bookingDto);
		return ResponseEntity.ok(booking);
	}

	// Get all bookings by manager
	@GetMapping("/getbookings/{managerId}/bookings")
	public ResponseEntity<List<BookingDto>> getAllBookingsByManager(@PathVariable Integer managerId) {
		List<BookingDto> bookings = managerService.getAllBookingsByManager(managerId);
		return ResponseEntity.ok(bookings);
	}

	// Get bookings by turf ID
	@GetMapping("/getbookingbyturf/{managerId}/turfs/{turfId}/bookings")
	public ResponseEntity<List<BookingDto>> getBookingsByTurfId(@PathVariable Integer turfId,
			@PathVariable Integer managerId) {
		List<BookingDto> bookings = managerService.getBookingsByTurfId(turfId, managerId);
		return ResponseEntity.ok(bookings);
	}

	/*
	 * // Delete inactive users
	 * 
	 * @DeleteMapping("/{managerId}/inactive-users") public ResponseEntity<Void>
	 * deleteInactiveUsers(@PathVariable Integer managerId) {
	 * managerService.deleteInactiveUsers(managerId); return
	 * ResponseEntity.noContent().build(); }
	 */
}
