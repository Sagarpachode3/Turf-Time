package com.turf_time.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
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
	    @FutureOrPresent(message = "Booking time must be in the present or future")
	    private LocalDateTime bookingTime;

	    @NotNull(message = "Slot cannot be null")
	    private SlotDto slot;

	    @NotNull(message = "User cannot be null")
	    private UserDto user;

	    private TurfDto turf;

	    private PaymentDto payment;
}
