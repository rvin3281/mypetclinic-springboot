package com.caltech.mypetclinic.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.caltech.mypetclinic.entity.Owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetRequestDto {

	@NotNull(message = "pet name cannot be null")
	@NotBlank(message = "pet name cannot be empty")
	private String pet_name;
	
	@NotNull(message = "pet age cannot be null")
	@NotBlank(message = "pet age cannot be empty")
	private String pet_age;
	
	@NotNull(message = "pet sex cannot be null")
	@NotBlank(message = "pet sex cannot be empty")
	private String pet_sex;
	
	private LocalDate pet_dob;
	
	@NotNull(message = "pet species cannot be null")
	@NotBlank(message = "pet species cannot be empty")
	private String pet_species;
	
	@NotNull(message = "pet breed cannot be null")
	@NotBlank(message = "pet breed cannot be empty")
	private String pet_breed;
	
	@NotNull(message = "pet owner cannot be null")
	private Integer owner_id;
	
}
