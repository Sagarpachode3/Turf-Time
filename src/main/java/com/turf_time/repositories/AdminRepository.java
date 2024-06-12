
package com.turf_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
