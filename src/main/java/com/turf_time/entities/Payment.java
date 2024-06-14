package com.turf_time.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	@Column(nullable = false)
    private String paymentGatewayTransactionId;
	
	@Column(nullable = false)
    private String status;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(nullable = false)
	private String paymentMethod;
	
	@OneToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
}
