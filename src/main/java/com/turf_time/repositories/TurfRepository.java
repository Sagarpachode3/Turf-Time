package com.turf_time.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Turf;

public interface TurfRepository extends JpaRepository<Turf, Integer> {

    List<Turf> findByTurfName(String turfName);
    
    List<Turf> findByCountry(String country);
    
    List<Turf> findByDistrict(String district);
    
    List<Turf> findByTahsil(String tahsil);
    
    List<Turf> findByCity(String city);
    
    List<Turf> findByManager_ManagerId(Integer managerId);
    
    List<Turf> findByIsAvailable(boolean isAvailable);
    
}
