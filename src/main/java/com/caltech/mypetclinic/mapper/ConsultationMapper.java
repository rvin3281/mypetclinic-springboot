package com.caltech.mypetclinic.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.caltech.mypetclinic.dto.ConsultationRequestDto;
import com.caltech.mypetclinic.dto.ConsultationResponseDto;
import com.caltech.mypetclinic.entity.Consultation;

@Mapper(componentModel ="spring")
public interface ConsultationMapper {

	public Consultation consultationRequestDtoToConsultation (ConsultationRequestDto consultationRequestDto);
	
	public ConsultationResponseDto consultationToConsultationResponseDto (Consultation consultation);
	
	public List<ConsultationResponseDto> listConsultationToConsultationResponseDto (List<Consultation> consultation);
}
