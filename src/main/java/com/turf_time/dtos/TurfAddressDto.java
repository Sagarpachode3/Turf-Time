package com.turf_time.dtos;

import jakarta.validation.constraints.NotBlank;

public class TurfAddressDto {
	
	private Integer turfAddressId;
	
	@NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "District is required")
    private String district;

    @NotBlank(message = "Tahsil is required")
    private String tahsil;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Local address is required")
    private String localAddress;

}
