package com.turf_time.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	private Double pricePerHour;

	@Column(nullable = false)
	private String contactNumber;

	private String Features;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id", referencedColumnName = "managerId", nullable = false)
	private Manager manager;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "turf_address_id", nullable = false)
	private TurfAddress turfAddress;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "turfs_sizes", 
	joinColumns = @JoinColumn(name = "turfId"), 
	inverseJoinColumns = @JoinColumn(name = "turfSizeId"))
	private List<TurfSize> turfSizes;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "turfs_turfTypes", 
	joinColumns = @JoinColumn(name = "turfId"),
	inverseJoinColumns = @JoinColumn(name = "turfTypeId"))
	private List<TurfType> turfTypes;

	@ManyToOne
	@JoinColumn(name = "active_status_id")
	private ActiveStatus activeStatus;

	@OneToMany(mappedBy = "turf", cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;

	@OneToMany(mappedBy = "turf",  cascade = CascadeType.ALL)
	private List<Booking> bookings;

}
