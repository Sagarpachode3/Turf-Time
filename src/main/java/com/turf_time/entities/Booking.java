package com.turf_time.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	@Column(nullable = false)
	private LocalDateTime bookingTime;

	@ManyToOne
	@JoinColumn(name = "slotId", referencedColumnName = "slotId", nullable = false)
	private Slot slot;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "turfId", referencedColumnName = "turfId")
	private Turf turf;

	
	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private Payment payment;

}
