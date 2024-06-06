package com.turf_time.entities;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turfs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer turfId;

	@Column(length = 25, nullable = false)
	private String turfName;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String district;

	@Column(nullable = false)
	private String tahsil;
	
	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String localAddress;
	
	@Column(nullable = false)
	private Double pricePerHour;
	
	@Column(nullable = false)
	private LocalTime availableFrom;
	
	@Column(nullable = false)
	private LocalTime availableTo;
	
	@Column(nullable = false)
    private boolean isAvailable;
	
	private String Features;
	
	private String type;
	
	private String size;

	@ManyToOne
	@JoinColumn(name = "managerId", referencedColumnName = "managerId")
	private Manager manager;
	
	@OneToMany(mappedBy = "turf",cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "turf", cascade = CascadeType.ALL)
	private List<Slot> slots;

}
