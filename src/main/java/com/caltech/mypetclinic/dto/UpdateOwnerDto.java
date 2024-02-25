package com.caltech.mypetclinic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOwnerDto {

	@NotNull(message = "Owner ID cannot be empty")
	private Integer owner_id;
	
	@NotNull(message = "first name cannot be empty")
	@NotBlank(message = "first name cannot be empty")
	private String owner_firstname;
	
	@NotNull(message = "last name cannot be empty")
	@NotBlank(message = "last name cannot be empty")
	private String owner_lastname;
	
	@Pattern(regexp="^\\d{10}$", message="Enter valid mobile number")
	private String owner_mobileno;
	
	@NotNull(message = "email cannot be empty")
	@Email(message = "Enter valid email ID")
	@NotBlank(message = "email cannot be empty")
	private String owner_email;
	
	@NotNull(message = "address cannot be empty")
	@NotBlank(message = "address cannot be empty")
	private String owner_address;
	
	@NotNull(message = "state cannot be empty")
	@NotBlank(message = "state cannot be empty")
	private String owner_state;
	
	@NotNull(message = "city cannot be empty")
	@NotBlank(message = "city cannot be empty")
	private String owner_city;
	
	@NotNull(message = "postal code cannot be empty")
	@NotBlank(message = "postal code cannot be empty")
	private String owner_postalcode;
}
