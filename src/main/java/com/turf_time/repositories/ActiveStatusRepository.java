package com.turf_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.ActiveStatus;

public interface ActiveStatusRepository extends JpaRepository<ActiveStatus, Integer> {

}
