package com.turf_time.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turfSize")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfSize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer turfSizeId;
	
	@Column(nullable = false, unique = true)
	private String turfSize;

	@ManyToMany(mappedBy = "turfSizes")
	private List<Turf> turfs;
}
