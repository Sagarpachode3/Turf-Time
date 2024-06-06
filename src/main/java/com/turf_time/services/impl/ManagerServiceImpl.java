package com.turf_time.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf_time.dtos.BookingDto;
import com.turf_time.dtos.ManagerDto;
import com.turf_time.dtos.TurfDto;
import com.turf_time.dtos.UserDto;
import com.turf_time.entities.Booking;
import com.turf_time.entities.Manager;
import com.turf_time.entities.Turf;
import com.turf_time.entities.User;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.exceptions.UnauthorizedAccessException;
import com.turf_time.repositories.BookingRepository;
import com.turf_time.repositories.ManagerRepository;
import com.turf_time.repositories.TurfRepository;
import com.turf_time.repositories.UserRepository;
import com.turf_time.services.ManagerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

	private ManagerRepository managerRepository;
	private TurfRepository turfRepository;
	private UserRepository userRepository;
	private BookingRepository bookingRepository;
	private ModelMapper modelMapper;

	@Autowired
	public ManagerServiceImpl(ManagerRepository managerRepository, TurfRepository turfRepository,
			UserRepository userRepository, BookingRepository bookingRepository, ModelMapper modelMapper) {
		super();
		this.managerRepository = managerRepository;
		this.turfRepository = turfRepository;
		this.userRepository = userRepository;
		this.bookingRepository = bookingRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ManagerDto registerManager(ManagerDto managerDto) {
		Manager manager = modelMapper.map(managerDto, Manager.class);
		Manager savedManager = managerRepository.save(manager);
		return modelMapper.map(savedManager, ManagerDto.class);
	}

	@Override
	public ManagerDto loginManager(String email, String passsword) {
		Manager manager = managerRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "email id", email));

		if (manager.getPassword().equals(passsword)) {
			return modelMapper.map(manager, ManagerDto.class);
		} else {
			throw new IllegalArgumentException("Invalid credentials");
		}
	}

	@Override
	public ManagerDto updateManagerDetails(Integer managerId, ManagerDto managerDto) {
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "manager Id", managerId));

		manager.setFirstName(managerDto.getFirstName());
		manager.setLastName(managerDto.getLastName());
		// manager.setEmail(managerDto.getEmail());
		manager.setContactNumber(managerDto.getContactNumber());
		manager.setActive(managerDto.isActive());

		Manager updatedManager = managerRepository.save(manager);
		return modelMapper.map(updatedManager, ManagerDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepository.delete(user);

	}

	@Override
	public List<TurfDto> getTurfsByManagerId(Integer managerId) {
		List<Turf> turfsByManagerId = turfRepository.findByManager_ManagerId(managerId);
		return turfsByManagerId.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
		// return users.stream().map(user -> modelMapper.map(user,
		// UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public TurfDto updateTurfDetails(Integer managerId, Integer turfId, TurfDto turfDto) {
		Turf turf = turfRepository.findById(turfId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turf Id", turfId));
		
		if(turf.getManager().getManagerId().equals(managerId)) {
			throw new UnauthorizedAccessException("You are not authorized to update this turf.");
		}
		
		turf.setTurfName(turfDto.getTurfName());
	    turf.setCountry(turfDto.getCountry());
	    turf.setState(turfDto.getState());
	    turf.setDistrict(turfDto.getDistrict());
	    turf.setTahsil(turfDto.getTahsil());
	    turf.setCity(turfDto.getCity());
	    turf.setLocalAddress(turfDto.getLocalAddress());
	    turf.setPricePerHour(turfDto.getPricePerHour());
	    turf.setAvailableFrom(turfDto.getAvailableFrom());
	    turf.setAvailableTo(turfDto.getAvailableTo());
	    turf.setAvailable(turfDto.isAvailable());
	    turf.setFeatures(turfDto.getFeatures());
	    turf.setType(turfDto.getType());
	    turf.setSize(turfDto.getSize());
	    
	    Turf savedTurf = turfRepository.save(turf);
		return modelMapper.map(savedTurf, TurfDto.class);
	}

	@Override
	public List<BookingDto> getBookingsByTurfId(Integer turfId) {
		List<Booking> bookings = bookingRepository.findByTurf_TurfId(turfId);
		return bookings.stream().map(booking -> modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getUsersByTurfId(Integer turfId) {
		List<User> users = userRepository.findByBookings_Turf_TurfId(turfId);
		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
	}

	@Override
	public List<BookingDto> getBookingsByManagerId(Integer managerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
