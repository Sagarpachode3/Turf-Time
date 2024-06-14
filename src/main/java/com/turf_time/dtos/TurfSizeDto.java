package com.turf_time.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfSizeDto {
	
	private Integer turfSizeId;
	
	@NotBlank(message = "Turf size is required")
    private String turfSize;

}
