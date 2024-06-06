package com.turf_time.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByTurf_TurfId(Integer turfId);
	
}
