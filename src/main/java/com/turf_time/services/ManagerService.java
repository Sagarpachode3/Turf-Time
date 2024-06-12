package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.BookingDto;
import com.turf_time.dtos.ManagerDto;
import com.turf_time.dtos.TurfDto;
import com.turf_time.dtos.UserDto;

public interface ManagerService {

	ManagerDto registerManager(ManagerDto managerDto);

	ManagerDto loginManager(String email, String password);

	ManagerDto getManagerById(Integer managerId);

	List<ManagerDto> getAllManagers();

	ManagerDto updateManager(Integer managerId, ManagerDto managerDto);

	void deleteManager(Integer managerId);

	TurfDto addTurf(Integer managerId, TurfDto turfDto);

	TurfDto updateTurf(Integer managerId, Integer turfId, TurfDto turfDto);

	List<TurfDto> getTurfsByManager(Integer managerId);

	List<UserDto> getUsersByManager(Integer managerId);

	BookingDto bookTurfOnBehalfOfCustomer(Integer managerId, BookingDto bookingDto);

	List<BookingDto> getAllBookingsByManager(Integer managerId);

	List<BookingDto> getBookingsByTurfId(Integer turfId, Integer managerId);

	void deleteInactiveUsers(Integer managerId);
}
