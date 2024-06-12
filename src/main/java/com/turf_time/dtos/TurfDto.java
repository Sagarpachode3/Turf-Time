package com.turf_time.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfDto {

	private Integer turfId;

	@NotBlank(message = "Turf name is required")
	@Size(max = 25, message = "Turf name can have a maximum of 25 characters")
	private String turfName;

	@NotNull(message = "Price per hour is required")
	@Positive(message = "Price per hour must be positive")
	private Double pricePerHour;

	@NotBlank(message = "Contact Number can't be empty!")
	@Pattern(regexp = "\\d{10}", message = "Please enter a valid 10-digit contact number")
	private String contactNumber;
	
	private String features;

	@NotNull(message = "Manager ID is required")
	private Long managerId;

	@NotNull(message = "Turf address ID is required")
	private Long turfAddressId;

	private List<Integer> turfSizeIds;

	private List<Integer> turfTypeIds;

	private Long activeStatusId;

	private List<Integer> feedbackIds;

	private List<Integer> bookingIds;

}
