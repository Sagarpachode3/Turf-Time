package com.turf_time.entities;

import java.util.List;

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
@Table(name = "activeStatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long activeStatusId;
	
	private String statusName;

	@OneToMany(mappedBy = "activeStatus")
	private List<Manager> managers;

	@OneToMany(mappedBy = "activeStatus")
	private List<User> users;

	@OneToMany(mappedBy = "activeStatus")
	private List<Turf> turfs;
}
