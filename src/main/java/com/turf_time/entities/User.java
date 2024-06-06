package com.turf_time.entities;

import java.util.List;

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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length = 25, nullable = false)
	private String firstName;
	
	@Column(length = 25, nullable = false)
	private String lastName;
	
	@Column(length = 6, nullable = false)
	private String gender;
	
	@Column(length = 10, nullable = false,unique = true)
	private String contactNumber;
	
	@Column(length = 50, nullable = false, unique = true)
    private String email;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;

}
