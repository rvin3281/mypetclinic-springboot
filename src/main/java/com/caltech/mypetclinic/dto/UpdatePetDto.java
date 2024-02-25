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
public class UpdatePetDto {

	
	private Integer pet_id;
	
	private String pet_name;

	private String pet_age;
	
	private String pet_sex;
	
	private LocalDate pet_dob;
	
	private String pet_species;

	private String pet_breed;

	private Integer owner_id;
	
}
