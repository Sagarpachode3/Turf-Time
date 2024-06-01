package com.turf_time.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.turf_time.dtos.UserDto;
import com.turf_time.entities.User;
import com.turf_time.exceptions.PhoneNumberAlreadyExistsException;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.exceptions.UserAlreadyExistsException;
import com.turf_time.repositories.UserRepository;
import com.turf_time.services.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	// private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto registerUser(UserDto userDto) {
		Optional<User> existingUserByEmail = userRepository.findByEmail(userDto.getEmail());
		if (existingUserByEmail.isPresent()) {
			throw new UserAlreadyExistsException("User", "Email Id", userDto.getEmail());
		}
		Optional<User> existingUserByContactNumber = userRepository.findByContactNumber(userDto.getContactNumber());
		if (existingUserByContactNumber.isPresent()) {
			throw new UserAlreadyExistsException("User", "Contact Number", userDto.getContactNumber());
		}

		// Map userDto to User Entity
		User user = modelMapper.map(userDto, User.class);

		// password hashing
		user.setPassword(userDto.getPassword());

		// Saving user Entity to database
		User savedUser = userRepository.save(user);

		// Mapping the saved User entity back to DTO
		return modelMapper.map(savedUser, UserDto.class);

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		Optional<User> userWithSameContactNumber = userRepository.findByContactNumber(userDto.getContactNumber());
		if (userWithSameContactNumber.isPresent() && userWithSameContactNumber.get().getUserId() != userId) {
			throw new PhoneNumberAlreadyExistsException(
					"Phone number is already used by another user: " + userDto.getContactNumber());
		}
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setContactNumber(userDto.getContactNumber());
//		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setPassword(userDto.getPassword());

		User updatedUser = this.userRepository.save(user);
		UserDto userDtoUpdated = modelMapper.map(updatedUser, UserDto.class);

		return userDtoUpdated;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Integer userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepository.delete(user);

	}

	@Override
	public void updateUserPassword(String email, String pass) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Email Id", email));
		user.setPassword(pass);
		userRepository.save(user);

	}

}
