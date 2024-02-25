package com.caltech.mypetclinic.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.caltech.mypetclinic.dto.PetRequestDto;
import com.caltech.mypetclinic.dto.PetResponseDto;
import com.caltech.mypetclinic.dto.UpdatePetDto;
import com.caltech.mypetclinic.entity.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

	public Pet petResponseDtoToPet (PetResponseDto petResponseDto);
	
	public PetResponseDto petToPetResponseDto (Pet pet);
	
	public Pet petRequestDtoToPet (PetRequestDto petRequestDto);
	
	public List<PetResponseDto> listPetToPetResponseDto (List<Pet> pet);
	
	public UpdatePetDto petToUpdatePetDto(Pet pet);
	
	public List<Pet> listPetRequestDtotoPet(List<PetRequestDto> petRequestDto);
}
