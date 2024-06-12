package com.turf_time.services.impl;

import java.util.List;
import java.util.Optional;
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
import com.turf_time.exceptions.EmailAlreadyExistsException;
import com.turf_time.exceptions.InvalidCredentialsException;
import com.turf_time.exceptions.PhoneNumberAlreadyExistsException;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.exceptions.UnauthorizedAccessException;
import com.turf_time.repositories.BookingRepository;
import com.turf_time.repositories.ManagerRepository;
import com.turf_time.repositories.TurfRepository;
import com.turf_time.repositories.UserRepository;
import com.turf_time.services.ManagerService;

@Service
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

		Optional<Manager> existingManagerByEmail = managerRepository.findByEmail(managerDto.getEmail());
		if (existingManagerByEmail.isPresent()) {
			throw new EmailAlreadyExistsException("Email is already used by another user: " + managerDto.getEmail());
		}

		Optional<Manager> existingManagerByContactNumber = managerRepository
				.findByContactNumber(managerDto.getContactNumber());
		if (existingManagerByContactNumber.isPresent()) {
			throw new PhoneNumberAlreadyExistsException(
					"Phone number is already used by another user: " + managerDto.getContactNumber());
		}

		Manager manager = modelMapper.map(managerDto, Manager.class);
		Manager savedManager = managerRepository.save(manager);
		return modelMapper.map(savedManager, ManagerDto.class);
	}

	@Override
	public ManagerDto loginManager(String email, String password) {

		Manager manager = managerRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "Email", email));
		if (!manager.getPassword().equals(password)) {
			throw new InvalidCredentialsException("Invalid email or password");
		}

		return modelMapper.map(manager, ManagerDto.class);
	}

	@Override
	public ManagerDto getManagerById(Integer managerId) {

		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "Id", managerId));
		return modelMapper.map(manager, ManagerDto.class);
	}

	@Override
	public List<ManagerDto> getAllManagers() {
		List<Manager> managers = managerRepository.findAll();
		return managers.stream().map(manager -> modelMapper.map(manager, ManagerDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ManagerDto updateManager(Integer managerId, ManagerDto managerDto) {

		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "Id", managerId));

		Optional<Manager> existingManagerByContactNumber = managerRepository
				.findByContactNumber(managerDto.getContactNumber());
		if (existingManagerByContactNumber.isPresent()) {
			throw new PhoneNumberAlreadyExistsException(
					"Phone number is already used by another user: " + managerDto.getContactNumber());
		}

		manager.setFirstName(managerDto.getFirstName());
		manager.setLastName(managerDto.getLastName());
		manager.setGender(managerDto.getGender());
		manager.setContactNumber(managerDto.getContactNumber());
		// manager.setEmail(managerDto.getEmail());
		manager.setPassword(managerDto.getPassword());

		Manager updatedManager = managerRepository.save(manager);
		return modelMapper.map(updatedManager, ManagerDto.class);

	}

	@Override
	public void deleteManager(Integer managerId) {
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "Id", managerId));
		managerRepository.delete(manager);
	}

	@Override
	public TurfDto addTurf(Integer managerId, TurfDto turfDto) {
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "Id", managerId));

		Turf turf = modelMapper.map(turfDto, Turf.class);
		turf.setManager(manager);
		Turf savedTurf = turfRepository.save(turf);

		return modelMapper.map(savedTurf, TurfDto.class);
	}

	@Override
	public TurfDto updateTurf(Integer managerId, Integer turfId, TurfDto turfDto) {

		Turf turf = turfRepository.findById(turfId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "Id", turfId));

		if (!turf.getManager().getManagerId().equals(managerId)) {
			throw new UnauthorizedAccessException("You can only update turfs listed by you");
		}

		turf.setTurfName(turfDto.getTurfName());
		turf.setPricePerHour(turfDto.getPricePerHour());
		turf.setContactNumber(turfDto.getContactNumber());
		turf.setFeatures(turfDto.getFeatures());

		Turf updatedTurf = turfRepository.save(turf);
		return modelMapper.map(updatedTurf, TurfDto.class);
	}

	@Override
	public List<TurfDto> getTurfsByManager(Integer managerId) {
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager", "Id", managerId));

		List<Turf> turfs = manager.getTurfs();
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getUsersByManager(Integer managerId) {

		List<User> users = userRepository.findAll().stream()
				.filter(user -> user.getBookings().stream()
						.anyMatch(booking -> booking.getTurf().getManager().getManagerId().equals(managerId)))
				.collect(Collectors.toList());

		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public BookingDto bookTurfOnBehalfOfCustomer(Integer managerId, BookingDto bookingDto) {

		Turf turf = turfRepository.findById(bookingDto.getTurfId())
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "Id", bookingDto.getTurfId()));

		if (!turf.getManager().getManagerId().equals(managerId)) {
			throw new UnauthorizedAccessException("You can only book turfs listed by you");
		}

		Booking booking = modelMapper.map(bookingDto, Booking.class);
		booking.setTurf(turf);
		Booking savedBooking = bookingRepository.save(booking);

		return modelMapper.map(savedBooking, BookingDto.class);
	}

	@Override
	public List<BookingDto> getAllBookingsByManager(Integer managerId) {
		List<Booking> bookings = bookingRepository.findAll().stream()
				.filter(booking -> booking.getTurf().getManager().getManagerId().equals(managerId))
				.collect(Collectors.toList());

		return bookings.stream().map(booking -> modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BookingDto> getBookingsByTurfId(Integer turfId, Integer managerId) {
		 Turf turf = turfRepository.findById(turfId)
	                .orElseThrow(() -> new ResourceNotFoundException("Turf", "Id", turfId));
	        
	        if (!turf.getManager().getManagerId().equals(managerId)) {
	            throw new UnauthorizedAccessException("You can only view bookings for turfs listed by you");
	        }

	        List<Booking> bookings = bookingRepository.findByTurf(turf);
	        return bookings.stream()
	                .map(booking -> modelMapper.map(booking, BookingDto.class))
	                .collect(Collectors.toList());
	    }

	@Override
	public void deleteInactiveUsers(Integer managerId) {
		// TODO Auto-generated method stub

	}

}
