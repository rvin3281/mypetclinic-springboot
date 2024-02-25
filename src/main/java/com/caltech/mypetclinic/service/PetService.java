package com.caltech.mypetclinic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.mypetclinic.dto.OwnerResponseDto;
import com.caltech.mypetclinic.dto.PetRequestDto;
import com.caltech.mypetclinic.dto.PetResponseDto;
import com.caltech.mypetclinic.dto.UpdatePetDto;
import com.caltech.mypetclinic.entity.Owner;
import com.caltech.mypetclinic.entity.Pet;
import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.exception.customException.NotSaveException;
import com.caltech.mypetclinic.mapper.OwnerMapper;
import com.caltech.mypetclinic.mapper.PetMapper;
import com.caltech.mypetclinic.repository.OwnerRepo;
import com.caltech.mypetclinic.repository.PetRepo;

@Service
public class PetService {

	@Autowired
	PetRepo repo;
	
	@Autowired
	PetMapper mapper;
	
	@Autowired
	OwnerRepo ownerRepo;
	
	
	@Autowired
	OwnerMapper ownerMapper;
	
	public PetResponseDto savePet(PetRequestDto petRequestDto) throws NotSaveException {
		
		try {
			int ownerID = petRequestDto.getOwner_id().intValue();
			Owner owner = ownerRepo.findById(ownerID).orElseThrow(()-> new NotFoundException("Owner not found with ID "+ ownerID));

			Pet pet = mapper.petRequestDtoToPet(petRequestDto);
			pet.setOwner(owner);
			
			Pet savedPet = repo.save(pet);
			
			PetResponseDto petResponseDto = mapper.petToPetResponseDto(savedPet);
			
			return petResponseDto;
			
		}catch(Exception ex)
		{
			throw new NotSaveException("Unable to save "+ex.getMessage());
		}
	}
	
	public void saveAllPet(List<PetRequestDto> petRequestDto) throws NotSaveException
	{
		try
		{
			List<Pet> savePet = new ArrayList<>();
			for(PetRequestDto petRequest:petRequestDto)
			{
				int ownerID = petRequest.getOwner_id().intValue();
				Owner owner = ownerRepo.findById(ownerID).orElseThrow(()-> new NotFoundException("Owner not found with ID "+ ownerID));
				
				Pet pet = mapper.petRequestDtoToPet(petRequest);
				pet.setOwner(owner);
				
				savePet.add(pet);
			}
			
			repo.saveAll(savePet);
			
		}catch(Exception ex)
		{
			throw new NotSaveException("Unable to save all "+ex.getMessage());
		}
	}
	
	public List<PetResponseDto> getAllPet() throws CustomErrorException, NotFoundException {
		try {
			
			List<Pet> pets  = repo.findAll();
			
			List<PetResponseDto> petResponseDtos  = mapper.listPetToPetResponseDto(pets);

			for(Pet pet: pets )
			{
				Owner owner = ownerRepo.findById(pet.getOwner().getOwner_id().intValue()).orElseThrow(()-> new NotFoundException("Owner Not Found"));
				OwnerResponseDto ownerResponseDto = ownerMapper.OwnerToOwnerResponseDto(owner);
				
				// Find the corresponding PetResponseDto and set its OwnerResponseDto
				petResponseDtos.stream()
	                .filter(petResponseDto -> petResponseDto.getPet_id().equals(pet.getPet_id()))
	                .findFirst()
	                .ifPresent(petResponseDto -> petResponseDto.setOwnerResponseDto(ownerResponseDto));
			}
			
			return petResponseDtos ;
			
		}
		catch(NotFoundException ex) {
			throw new NotFoundException(ex.getMessage());
		}
		catch(Exception ex) {
			throw new CustomErrorException("Not able to fetch all Pet"+ex.getMessage());
		}
	}
	
	public PetResponseDto getPetById(int id) throws CustomErrorException, NotFoundException {
		
		
			
			Pet pet = repo.findById(id).orElseThrow(()-> new NotFoundException("Pet ID not found"+id));
			Owner owner = ownerRepo.findById(pet.getOwner().getOwner_id().intValue()).orElseThrow(()-> new NotFoundException("Owner not found on Pet"));
			OwnerResponseDto ownerResponseDto = ownerMapper.OwnerToOwnerResponseDto(owner);
			
			PetResponseDto petResponseDto = mapper.petToPetResponseDto(pet);
			petResponseDto.setOwnerResponseDto(ownerResponseDto);
			return petResponseDto;
			
		
		
	}
	
	public PetResponseDto updatePetById(UpdatePetDto updatePetDto, int id) throws CustomErrorException {
		
		try {
			
			if(updatePetDto.getPet_id().intValue() == id)
			{
				Pet pet = repo.findById(id).orElseThrow(()-> new NotFoundException("Pet ID not found"+id));
				
				int ownerId = updatePetDto.getOwner_id().intValue();
				Owner owner = new Owner();
				
				if(updatePetDto.getOwner_id() != null)
				{
					owner = ownerRepo.findById(ownerId).orElseThrow(()-> new NotFoundException("Owner not Found with ID "+ownerId));
					pet.setOwner(owner);
				}
				
				if(updatePetDto.getPet_name() != null)
				{
					pet.setPet_name(updatePetDto.getPet_name());
				}
				if(updatePetDto.getPet_age() != null)
				{
					pet.setPet_age(updatePetDto.getPet_age());
				}
				if(updatePetDto.getPet_sex() != null)
				{
					pet.setPet_sex(updatePetDto.getPet_sex());
				}
				if(updatePetDto.getPet_dob() != null)
				{
					pet.setPet_dob(updatePetDto.getPet_dob());
				}
				if(updatePetDto.getPet_species() != null)
				{
					pet.setPet_species((updatePetDto.getPet_species()));
					
				}
				if(updatePetDto.getPet_breed() != null)
				{
					pet.setPet_breed((updatePetDto.getPet_breed()));
				}
				
				Pet savePet = repo.save(pet);
				
				PetResponseDto petResponseDto = mapper.petToPetResponseDto(savePet);
				
				return petResponseDto;
				
			}else {
				throw new CustomErrorException("ID on Request Body and URL not match");
			}
			
		}catch(Exception ex)
		{
			throw new CustomErrorException("Not able to update Pet with ID "+id +ex.getMessage());
		}
		
	}
	
	public void deletePetById(int id) {
		
		repo.deleteById(id);
		
	}
}









