package com.turf_time.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf_time.dtos.BookingDto;
import com.turf_time.entities.Booking;
import com.turf_time.entities.Turf;
import com.turf_time.entities.User;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.BookingRepository;
import com.turf_time.repositories.TurfRepository;
import com.turf_time.repositories.UserRepository;
import com.turf_time.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;

	private UserRepository userRepository;

	private TurfRepository turfRepository;

	private ModelMapper modelMapper;

	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository,
			TurfRepository turfRepository, ModelMapper modelMapper) {
		super();
		this.bookingRepository = bookingRepository;
		this.userRepository = userRepository;
		this.turfRepository = turfRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public BookingDto createBooking(BookingDto bookingDto) {

		Booking booking = modelMapper.map(bookingDto, Booking.class);
		User user = userRepository.findById(bookingDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", bookingDto.getUserId()));

		Turf turf = turfRepository.findById(bookingDto.getTurfId())
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turfId", bookingDto.getTurfId()));

		booking.setUser(user);
		booking.setTurf(turf);
		Booking savedBooking = bookingRepository.save(booking);
		return modelMapper.map(savedBooking, BookingDto.class);
	}

	@Override
	public BookingDto getBookingById(Integer bookingId) {
		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "BookingId", bookingId));
		return modelMapper.map(booking, BookingDto.class);
	}

	@Override
	public List<BookingDto> getAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		return bookings.stream().map(booking -> modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteBooking(Integer bookingId) {
		bookingRepository.deleteById(bookingId);

	}

	@Override
	public BookingDto updateBooking(Integer bookingId, BookingDto bookingDto) {
		
		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "BookingId", bookingId));
		
		booking.setBookingTime(bookingDto.getBookingTime());
		booking.setCheckinTime(bookingDto.getCheckinTime());
		booking.setCheckoutTime(bookingDto.getCheckoutTime());
		
		User user = userRepository.findById(bookingDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", bookingDto.getUserId()));

		Turf turf = turfRepository.findById(bookingDto.getTurfId())
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turfId", bookingDto.getTurfId()));
		
		//booking.setUser(user);
		booking.setTurf(turf);
		Booking updatedBooking = bookingRepository.save(booking);
		return modelMapper.map(updatedBooking, BookingDto.class);
	}

}
