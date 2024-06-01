package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.UserDto;

public interface AdminService {

	//User related operations
	
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	UserDto updateUser(UserDto userDto, Integer userId);
	void viewUserDetails(Integer userId);
	
	//Manager related operations
	
}
