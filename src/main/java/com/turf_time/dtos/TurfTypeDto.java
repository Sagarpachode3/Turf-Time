package com.turf_time.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfTypeDto {

	private Integer turfTypeId;

	@NotBlank(message = "Turf type name is required")
	private String turfTypeName;

}
