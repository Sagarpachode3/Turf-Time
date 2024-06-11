package com.turf_time.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int userId;

	@NotBlank(message = "First Name is mandatory!")
	@Size(min = 4, max = 25, message = "First Name length should be between 4 - 25 characters")
	private String firstName;

	@NotBlank(message = "Last Name is mandatory!")
	@Size(min = 4, max = 25, message = "Last Name length should be between 4 - 25 characters")
	private String lastName;

	@NotBlank(message = "Please select any one from options")
	private String gender;

	@NotBlank(message = "Contact Number can't be empty!")
	@Pattern(regexp = "\\d{10}", message = "Please enter a valid 10-digit contact number")
	private String contactNumber;

	@NotBlank(message = "Email Can't be empty!")
	@Email(message = "Please enter a valid email id")
	@Size(max = 50, message = "Email can have a maximum of 50 characters")
	private String email;

	@NotBlank(message = "Password is mandatory !")
	@Size(min = 8, max = 16, message = "Password length must be between 8 - 16 charecters.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.")
	//@JsonIgnore
	private String password;

	private List<BookingDto> bookings;

	private Integer activeStatusId;

	private List<Integer> bookingIds;

	private List<Integer> feedbackIds;

}
