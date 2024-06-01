package com.turf_time.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetDto {
	
	@NotBlank(message = "Email Can't be empty!")
	@Email(message = "Please enter a valid email id")
	private String email;

	@NotBlank(message = "Password is mandatory !")
	@Size(min = 8, max = 16, message = "Password length must be between 8 - 16 charecters.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", 
	message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.")
	private String password;
}
