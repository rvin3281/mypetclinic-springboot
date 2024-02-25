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
public class PetResponseDto {

	private Integer pet_id;
	private String pet_name;
	private String pet_age;
	private String pet_sex;
	private LocalDate pet_dob;
	private String pet_species;
	private String pet_breed;
	private Timestamp pet_created_timestamp;
	private Timestamp pet_updated_timestamp;
	private OwnerResponseDto ownerResponseDto;
}
