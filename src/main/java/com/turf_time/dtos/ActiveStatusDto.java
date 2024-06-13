package com.turf_time.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveStatusDto {

	private Integer activeStatusId;

	@NotBlank(message = "Please select status")
	private String statusName;
}
