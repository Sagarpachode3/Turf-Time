package com.turf_time.controllers;

import com.turf_time.dtos.PasswordResetDto;
import com.turf_time.dtos.UserDto;
import com.turf_time.payloads.ApiResponse;
import com.turf_time.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// POST - register user

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
		UserDto registeredUser = userService.registerUser(userDto);
		return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
	}

	// PUT - Update user

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updatedUser = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}

	// GET - Get User
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
		UserDto user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}

	//GET - get all users List
	
	@GetMapping("/getusers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	//DELETE - delete User
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}

	//Reset user password
	
	@PutMapping("/res-pass")
	public ResponseEntity<ApiResponse> resetUserPassword(@Valid @RequestBody PasswordResetDto passwordResetDto) {
		this.userService.resetUserPassword(passwordResetDto.getEmail(),passwordResetDto.getPassword());
		return new ResponseEntity<>(new ApiResponse("Password changed Sucessfully!", true), HttpStatus.OK);
	}
}
