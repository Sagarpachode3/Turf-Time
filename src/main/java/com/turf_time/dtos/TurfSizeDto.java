package com.turf_time.dtos;

import jakarta.validation.constraints.NotBlank;

public class TurfSizeDto {
	
	private Integer turfSizeId;
	
	@NotBlank(message = "Turf size is required")
    private String turfSize;

}
