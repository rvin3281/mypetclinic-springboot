package com.caltech.mypetclinic.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.caltech.mypetclinic.dto.OwnerRequestDto;
import com.caltech.mypetclinic.dto.OwnerResponseDto;
import com.caltech.mypetclinic.dto.PetRequestDto;
import com.caltech.mypetclinic.dto.UpdateOwnerDto;
import com.caltech.mypetclinic.entity.Owner;
import com.caltech.mypetclinic.entity.Pet;

@Mapper(componentModel="spring")
public interface OwnerMapper {

	public Owner OwnerRequestDtoToOwner (OwnerRequestDto ownerRequestDto);
	
	public OwnerResponseDto OwnerToOwnerResponseDto (Owner owner);
	
	public UpdateOwnerDto ownerToUpdateOwnerDto (Owner owner);
	
	public List<OwnerResponseDto> listOwnerToOwnerResponseDto ( List<Owner> owner);
	
	public List<Owner> listOwnerRequestDtotoOwner(List<OwnerRequestDto> ownerRequestDto);
	
}
