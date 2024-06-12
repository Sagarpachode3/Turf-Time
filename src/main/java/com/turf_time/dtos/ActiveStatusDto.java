package com.turf_time.dtos;

import jakarta.validation.constraints.NotBlank;

public class ActiveStatusDto {

	private Integer activeStatusId;

	@NotBlank(message = "Please select status")
	private String statusName;
}
