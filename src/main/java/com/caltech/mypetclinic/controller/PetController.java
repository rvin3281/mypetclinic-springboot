package com.caltech.mypetclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.mypetclinic.dto.PetRequestDto;
import com.caltech.mypetclinic.dto.PetResponseDto;
import com.caltech.mypetclinic.dto.UpdatePetDto;
import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.exception.customException.NotSaveException;
import com.caltech.mypetclinic.response.PetResponse;
import com.caltech.mypetclinic.service.PetService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pet")
@CrossOrigin
@Tag(name="Pet")
public class PetController {

	@Autowired
	PetService service;
	
	@Autowired
	PetResponse response;
	
	
	@PostMapping("")
	public ResponseEntity<Object> savePet(@RequestBody @Valid PetRequestDto petRequestDto) throws NotSaveException{
		
		PetResponseDto petResponseDto = service.savePet(petRequestDto);
		
		return response.responseWithData(petResponseDto, "success", HttpStatus.CREATED);
		
	}
	
	@PostMapping("/save-all")
	public ResponseEntity<Object> saveAllPet (@RequestBody @Valid List<PetRequestDto> petRequestDto) throws NotSaveException
	{
		service.saveAllPet(petRequestDto);
		return response.responseWithoutData("success", HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getAllPet() throws CustomErrorException, NotFoundException{
		
		List<PetResponseDto> petResponseDto = service.getAllPet();
		
		return response.responseWithData(petResponseDto, "success", HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPetById(@PathVariable int id) throws CustomErrorException, NotFoundException{
		
		PetResponseDto petResponseDto = service.getPetById(id);
		return response.responseWithData(petResponseDto, "success", HttpStatus.OK);
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updatePetById(@RequestBody UpdatePetDto updatePetDto, @PathVariable int id) throws CustomErrorException{
		
		PetResponseDto petResponseDto = service.updatePetById(updatePetDto, id);
		return response.responseWithData(petResponseDto, "success", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePetById( @PathVariable int id) {
		 service.deletePetById(id);
	     return response.responseWithoutData("Pet deleted successfully", HttpStatus.OK);
	}
	
}











