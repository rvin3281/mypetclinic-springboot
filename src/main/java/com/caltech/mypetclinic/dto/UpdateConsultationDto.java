package com.caltech.mypetclinic.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.caltech.mypetclinic.entity.Pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConsultationDto {

	@NotNull(message = "consultation id cannot be null")
	private Integer consultation_id;
	
	@NotNull(message = "consultation note cannot be null")
	@NotBlank(message = "consultation note cannot be empty")
	private String consultation_note;
	
	@NotNull(message = "consultation visitdate cannot be null")
	private LocalDate consultation_visitdate;
	
	@NotNull(message = "consultation symptoms cannot be null")
	@NotBlank(message = "consultation symptoms cannot be empty")
	private String consultation_symptoms;
	
	@NotNull(message = "consultation diagnosis cannot be null")
	@NotBlank(message = "consultation diagnosis cannot be empty")
	private String consultation_diagnosis;
	
	@NotNull(message = "consultation treatment cannot be null")
	@NotBlank(message = "consultation treatment cannot be empty")
	private String consultation_treatment;
	
	@NotNull(message = "consultation prescribe medicine cannot be null")
	@NotBlank(message = "consultation prescribe medicine cannot be empty")
	private String consultation_prescribe_medicine;
	
	@NotNull(message = "consultation fee cannot be null")
	@NotBlank(message = "consultation fee cannot be empty")
	private String consultation_fee;

	@NotNull(message = "pet id cannot be null")
	private Integer pet_id;
	
}
