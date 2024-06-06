package com.turf_time.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turf_time.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmail(String email);
	Optional<User> findByContactNumber(String contactNumber);
	List<User> findByBookings_Turf_TurfId(Integer turfId);
}
