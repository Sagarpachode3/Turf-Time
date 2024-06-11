package com.turf_time.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turfAddress")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfAddress {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer turfAddressId;

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
	
	@OneToMany(mappedBy = "turfAddress", cascade = CascadeType.ALL)
    private List<Turf> turfs;
}
