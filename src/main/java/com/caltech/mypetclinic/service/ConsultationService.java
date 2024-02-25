package com.caltech.mypetclinic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.mypetclinic.dto.ConsultationRequestDto;
import com.caltech.mypetclinic.dto.ConsultationResponseDto;
import com.caltech.mypetclinic.dto.PetResponseDto;
import com.caltech.mypetclinic.dto.UpdateConsultationDto;
import com.caltech.mypetclinic.entity.Consultation;
import com.caltech.mypetclinic.entity.Pet;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.mapper.ConsultationMapper;
import com.caltech.mypetclinic.mapper.PetMapper;
import com.caltech.mypetclinic.repository.ConsultationRepo;
import com.caltech.mypetclinic.repository.PetRepo;

@Service
public class ConsultationService {

	@Autowired
	ConsultationRepo repo;
	
	@Autowired
	PetRepo petRepo;
	
	@Autowired
	ConsultationMapper mapper;
	
	@Autowired
	PetMapper petMapper;
	
	Logger logger = Logger.getAnonymousLogger();
	
	public ConsultationResponseDto saveConsultation(ConsultationRequestDto consultationRequestDto) throws NotFoundException
	{
		int petID = consultationRequestDto.getPet_id().intValue();
	
		Pet pet = petRepo.findById(petID).orElseThrow(()->new NotFoundException("Pet Not found"));
		
		PetResponseDto petResponseDto = petMapper.petToPetResponseDto(pet);

		Consultation consultation = mapper.consultationRequestDtoToConsultation(consultationRequestDto);
		consultation.setPet(pet);

		Consultation savedConsultation = repo.save(consultation);
		
		ConsultationResponseDto consultationResponseDto = mapper.consultationToConsultationResponseDto(savedConsultation);
		
		// Attach PetResponseDto
		consultationResponseDto.setPetResponseDto(petResponseDto);
		
		return consultationResponseDto;
		
	}
	
	public List<ConsultationResponseDto> getAllConsultation() throws NotFoundException
	{
		List<Consultation> consultations = repo.findAll();
		List<ConsultationResponseDto> consultationResponseDtos = new ArrayList<>();
		for(Consultation consultation: consultations)
		{
			int petId = consultation.getPet().getPet_id().intValue();
			Pet pet = petRepo.findById(petId).orElseThrow(()-> new NotFoundException("Pet with ID "+petId+" not found"));
			PetResponseDto petResponseDto = petMapper.petToPetResponseDto(pet);
			
			ConsultationResponseDto consultationResponseDto = mapper.consultationToConsultationResponseDto(consultation);
			consultationResponseDto.setPetResponseDto(petResponseDto);
			
			consultationResponseDtos.add(consultationResponseDto);
		}
		
		return consultationResponseDtos;
	}
	
	public ConsultationResponseDto getConsultationById(int id) throws NotFoundException
	{
		Consultation consultation = repo.findById(id).orElseThrow(() -> new NotFoundException("Consultation not found with id " + id));
		
		int petId = consultation.getPet().getPet_id().intValue();
		Pet pet = petRepo.findById(petId).orElseThrow(()-> new NotFoundException("Pet with ID "+petId+" not found"));
		
		PetResponseDto petResponseDto = petMapper.petToPetResponseDto(pet);
		
		ConsultationResponseDto consultationResponseDto = mapper.consultationToConsultationResponseDto(consultation);
		consultationResponseDto.setPetResponseDto(petResponseDto);
		
		return consultationResponseDto;
	}
	
	public ConsultationResponseDto updateConsultationById(UpdateConsultationDto updateConsultation, int id) throws NotFoundException
	{
		if(updateConsultation.getConsultation_id().intValue() == id)
		{
			Consultation consultation = repo.findById(id).orElseThrow(() -> new NotFoundException("Consultation not found with id " + id));
			
			if(consultation != null)
			{
				int petId = updateConsultation.getPet_id().intValue();
				
				if(updateConsultation.getConsultation_note() != null) {
					consultation.setConsultation_note(updateConsultation.getConsultation_note());
				}
				if(updateConsultation.getConsultation_visitdate() != null)
				{
					consultation.setConsultation_visitdate(updateConsultation.getConsultation_visitdate());
				}
				if(updateConsultation.getConsultation_symptoms()!=null)
				{
					consultation.setConsultation_symptoms(updateConsultation.getConsultation_symptoms());
				}
				if(updateConsultation.getConsultation_diagnosis() != null)
				{
					consultation.setConsultation_diagnosis(updateConsultation.getConsultation_diagnosis());
				}
				if(updateConsultation.getConsultation_treatment() != null)
				{
					consultation.setConsultation_treatment(updateConsultation.getConsultation_treatment());
				}
				if(updateConsultation.getConsultation_treatment() != null)
				{
					consultation.setConsultation_treatment(updateConsultation.getConsultation_treatment());
				}
				if(updateConsultation.getConsultation_prescribe_medicine() != null)
				{
					consultation.setConsultation_prescribe_medicine(updateConsultation.getConsultation_prescribe_medicine());
				}
				if(updateConsultation.getConsultation_fee() != null)
				{
					consultation.setConsultation_fee(updateConsultation.getConsultation_fee());
				}
				if(updateConsultation.getPet_id() != null)
				{
					Pet pet =petRepo.findById(petId).orElseThrow(()-> new NotFoundException("Pet not found with ID"));
					consultation.setPet(pet);
				}
				
				Consultation updatedConsultation = repo.save(consultation);
				
				int updatedPetId = updatedConsultation.getPet().getPet_id().intValue();
				Pet pet = petRepo.findById(updatedPetId).orElseThrow(()-> new NotFoundException("Pet with ID "+updatedPetId+" not found"));
				PetResponseDto petResponseDto = petMapper.petToPetResponseDto(pet);
				
				ConsultationResponseDto updatedConsultationResponseDto = mapper.consultationToConsultationResponseDto(updatedConsultation);
				updatedConsultationResponseDto.setPetResponseDto(petResponseDto);
				
				return updatedConsultationResponseDto;
				
			}else {
				throw new NotFoundException("Consultation not found with id " +id);
			}
		}else {
			throw new NotFoundException("ID not match");
		}
	}
	
	public void deleteConsultation(int id)
	{
		repo.deleteById(id);
	}
	
}
