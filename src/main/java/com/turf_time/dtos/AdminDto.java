package com.turf_time.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	private int adminId;

	@NotBlank(message = "User Name is mandatory!")
	@Size(min = 4, max = 25, message = "User Name length should be between 4 - 25 characters")
	private String userName;
	
	@NotBlank(message = "Password is mandatory !")
	@Size(min = 8, max = 16, message = "Password length must be between 8 - 16 charecters.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", 
	message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.")
	@JsonIgnore
	private String password;
}
