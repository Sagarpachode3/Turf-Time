package com.turf_time.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

	private Integer paymentId;

	@NotNull(message = "Amount cannot be null")
	@DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero")
	private Double amount;

	@NotNull(message = "Payment time cannot be null")
	@FutureOrPresent(message = "Payment time must be in the present or future")
	private LocalDateTime paymentTime;

	@NotBlank(message = "Payment gateway transaction ID is required")
	private String paymentGatewayTransactionId;

	@NotBlank(message = "Status is required")
	private String status;

	@NotBlank(message = "Payment method is required")
	private String paymentMethod;

	@NotNull(message = "Booking ID is required")
	private Long bookingId;
}
