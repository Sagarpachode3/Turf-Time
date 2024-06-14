package com.turf_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.TurfSize;

public interface TurfSizeRepository extends JpaRepository<TurfSize, Integer> {
	
}
