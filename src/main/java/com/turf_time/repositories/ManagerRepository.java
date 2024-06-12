
package com.turf_time.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Booking;
import com.turf_time.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	Optional<Manager> findByEmail(String email);

	Optional<Manager> findByContactNumber(String contactNumber);
	
}
