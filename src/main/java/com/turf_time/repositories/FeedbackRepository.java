package com.turf_time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf_time.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
