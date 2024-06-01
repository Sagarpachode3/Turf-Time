package com.turf_time.dtos;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfDto {

    private Integer turfId;

    @NotBlank(message = "Turf name is required")
    private String turfName;

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

    @NotNull(message = "Price per hour is required")
    private Double pricePerHour;

    @NotNull(message = "Available from time is required")
    private LocalTime availableFrom;

    @NotNull(message = "Available to time is required")
    private LocalTime availableTo;

    private boolean isAvailable;

    private String features;

    private String type;

    private String size;

}
