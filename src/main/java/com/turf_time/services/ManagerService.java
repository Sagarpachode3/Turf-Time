package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.BookingDto;
import com.turf_time.dtos.ManagerDto;
import com.turf_time.dtos.TurfDto;
import com.turf_time.dtos.UserDto;

public interface ManagerService {

	ManagerDto registerManager(ManagerDto managerDto);
	
	ManagerDto loginManager(String email, String passsword);
	
	ManagerDto updateManagerDetails(Integer managerId, ManagerDto managerDto);
	
	void deleteUser(Integer userId);
	
	List<TurfDto> getTurfsByManagerId(Integer managerId);
	
	TurfDto updateTurfDetails(Integer managerId, Integer turfId, TurfDto turfDto);
	
	List<BookingDto> getBookingsByManagerId(Integer managerId);
	
	List<BookingDto> getBookingsByTurfId(Integer turfId);
	
	List<UserDto> getUsersByTurfId(Integer turfId);
	
	
}
