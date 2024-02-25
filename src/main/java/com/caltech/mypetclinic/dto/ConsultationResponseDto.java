package com.caltech.mypetclinic.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.caltech.mypetclinic.entity.Pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationResponseDto {

	private Integer consultation_id;
	private String consultation_note;
	private LocalDate consultation_visitdate;
	private String consultation_symptoms;
	private String consultation_diagnosis;
	private String consultation_treatment;
	private String consultation_prescribe_medicine;
	private String consultation_fee;
	private Timestamp consultation_created_timestamp;
	private Timestamp consultation_updated_timestamp;
	private PetResponseDto petResponseDto;
	
}
	