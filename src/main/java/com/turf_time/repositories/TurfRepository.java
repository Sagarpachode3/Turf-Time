
package com.turf_time.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Turf;

public interface TurfRepository extends JpaRepository<Turf, Integer> {

    Optional<Turf> findByTurfNameAndManager_ManagerId(String turfName, Integer managerId);

}
