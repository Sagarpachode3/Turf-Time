package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.BookingDto;

public interface BookingService {
	
	BookingDto createBooking(BookingDto bookingDto);

	BookingDto getBookingById(Integer bookingId);

	List<BookingDto> getAllBookings();

	void deleteBooking(Integer bookingId);

	BookingDto updateBooking(Integer bookingId, BookingDto bookingDto);
}
