package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.UserDto;

public interface UserService {

	UserDto registerUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

	void updateUserPassword(String email, String pass);

}
