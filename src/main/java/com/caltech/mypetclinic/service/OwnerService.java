package com.caltech.mypetclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.mypetclinic.dto.OwnerRequestDto;
import com.caltech.mypetclinic.dto.OwnerResponseDto;
import com.caltech.mypetclinic.dto.PetRequestDto;
import com.caltech.mypetclinic.dto.UpdateOwnerDto;
import com.caltech.mypetclinic.entity.Owner;
import com.caltech.mypetclinic.entity.Pet;
import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.exception.customException.NotSaveException;
import com.caltech.mypetclinic.mapper.OwnerMapper;
import com.caltech.mypetclinic.repository.OwnerRepo;

@Service
public class OwnerService {

	@Autowired
	OwnerRepo repo;
	
	@Autowired
	OwnerMapper mapper;

	public OwnerResponseDto saveOwner(OwnerRequestDto ownerRequestDto)
	{
		Owner owner = mapper.OwnerRequestDtoToOwner(ownerRequestDto);
		repo.save(owner);
		
		OwnerResponseDto ownerResponseDtoSaved = mapper.OwnerToOwnerResponseDto(owner);
		return ownerResponseDtoSaved;
	}
	
	public void saveAllPet(List<OwnerRequestDto> ownerRequestDto) throws NotSaveException
	{
		try
		{
			List<Owner> owner = mapper.listOwnerRequestDtotoOwner(ownerRequestDto);
			repo.saveAll(owner);
			
		}catch(Exception ex)
		{
			throw new NotSaveException("Unable to save all "+ex.getMessage());
		}
	}

	public OwnerResponseDto updateOwnerById(UpdateOwnerDto updateOwnerDto, int id) throws CustomErrorException, NotFoundException
	{
		if(updateOwnerDto.getOwner_id().intValue() == id)
		{
			
			Owner owner = repo.findById(id).orElseThrow(()-> new NotFoundException("Owner not found with ID "+id));
			
			if(updateOwnerDto.getOwner_firstname()!=null)
			{
				owner.setOwner_firstname(updateOwnerDto.getOwner_firstname());
			}
			if(updateOwnerDto.getOwner_lastname()!= null)
			{
				owner.setOwner_lastname(updateOwnerDto.getOwner_lastname());
			}
			if(updateOwnerDto.getOwner_mobileno() != null)
			{
				owner.setOwner_mobileno(updateOwnerDto.getOwner_mobileno());
			}
			if(updateOwnerDto.getOwner_email() != null)
			{
				owner.setOwner_email(updateOwnerDto.getOwner_email());
			}
			if(updateOwnerDto.getOwner_address() != null)
			{
				owner.setOwner_address(updateOwnerDto.getOwner_address());
			}
			if(updateOwnerDto.getOwner_state() != null)
			{
				owner.setOwner_state(updateOwnerDto.getOwner_state());
			}
			if(updateOwnerDto.getOwner_city() != null)
			{
				owner.setOwner_city(updateOwnerDto.getOwner_city());
			}
			if(updateOwnerDto.getOwner_postalcode() != null)
			{
				owner.setOwner_postalcode(updateOwnerDto.getOwner_postalcode());
			}
			
			Owner updatedOwner = repo.save(owner);
			
			OwnerResponseDto ownerResponseDto = mapper.OwnerToOwnerResponseDto(updatedOwner);
			
			return ownerResponseDto;
			
		}else
		{
			throw new CustomErrorException("Owner unable to update. ID not match");
		}
	}
	
	public List<OwnerResponseDto> getAllOwner() throws NotFoundException {
		
	List<Owner> owner = repo.findAll();
	
	if(owner.isEmpty())
	{
		throw new NotFoundException("No Owner Found");
	}else {
		List<OwnerResponseDto> ownerResponseDto = mapper.listOwnerToOwnerResponseDto(owner);
		
		return ownerResponseDto;
	}
	
	}
	
	public OwnerResponseDto getOwnerById(int id) throws NotFoundException {
		
		Owner owner = repo.findById(id).orElseThrow(()-> new NotFoundException("No Owner Found with ID "+id));
		OwnerResponseDto ownerResponseDto = mapper.OwnerToOwnerResponseDto(owner);
		return ownerResponseDto;
		
	}
	
	public void deleteOwnerById(int id) {
		
		repo.deleteById(id);
		
	}
	
}











































