package com.turf_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.TurfAddress;

public interface TurfAddressRepository extends JpaRepository<TurfAddress, Integer> {

}
