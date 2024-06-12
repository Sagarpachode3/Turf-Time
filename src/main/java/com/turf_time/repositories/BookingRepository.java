
package com.turf_time.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Booking;
import com.turf_time.entities.Turf;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByTurf(Turf turf);

	List<Booking> findByUser_UserId(Integer userId);

}
