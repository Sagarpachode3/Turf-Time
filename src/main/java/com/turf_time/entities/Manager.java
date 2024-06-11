package com.turf_time.entities;

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
@Table(name = "managers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer managerId;

	@Column(nullable = false, length = 25)
	private String firstName;

	@Column(nullable = false, length = 25)
	private String lastName;

	@Column(nullable = false, length = 6)
	private String gender;

	@Column(nullable = false, unique = true, length = 15)
	private String contactNumber;

	@Column(nullable = false, unique = true, length = 50)
	private String email;

	@Column(nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "active_status_id")
	private ActiveStatus activeStatus;

	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private List<Turf> turfs;
}
