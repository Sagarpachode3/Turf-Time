package com.turf_time.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FeedbackDto {

	@NotNull(message = "Rating is required. Rate between 1 - 5 (Worst - Good)")
	@Min(value = 1, message = "Rating must be at least 1")
	@Max(value = 5, message = "Rating must be at most 5")
	private Integer rating;

	@NotBlank(message = "Comment is required")
	@Size(max = 500, message = "Comment can have a maximum of 500 characters")
	private String comment;

	@NotNull(message = "User ID is required")
	private Long userId;

	@NotNull(message = "Turf ID is required")
	private Long turfId;
}
