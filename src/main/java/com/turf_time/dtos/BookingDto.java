package com.turf_time.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

	private Integer bookingId;

	@NotNull(message = "Booking time cannot be null")
	@Future(message = "Booking time must be in the future")
	private LocalDateTime bookingTime;

	@NotNull(message = "Check-in time is required")
	@Future(message = "Check-in time must be in the future")
	private LocalDateTime checkinTime;

	@NotNull(message = "Check-out time is required")
	@Future(message = "Check-out time must be in the future")
	private LocalDateTime checkoutTime;

	@NotNull(message = "User ID is required")
	private Integer userId;

	@NotNull(message = "Turf ID is required")
	private Integer turfId;
}
