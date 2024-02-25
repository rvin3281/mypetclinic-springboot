package com.caltech.mypetclinic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.caltech.mypetclinic.dto.OwnerRequestDto;
import com.caltech.mypetclinic.dto.OwnerResponseDto;
import com.caltech.mypetclinic.dto.PetRequestDto;
import com.caltech.mypetclinic.dto.UpdateOwnerDto;
import com.caltech.mypetclinic.entity.Owner;
import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.exception.customException.NotSaveException;
import com.caltech.mypetclinic.response.OwnerResponse;
import com.caltech.mypetclinic.service.OwnerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/owner")
@CrossOrigin
@Tag(name="Owner")
public class OwnerController {

	@Autowired
	private OwnerService service;
	
	@Autowired
	private OwnerResponse response;
	
	
	@PostMapping("")
	public ResponseEntity<Object> saveOwner(@RequestBody @Valid OwnerRequestDto ownerRequestDto)
	{
		OwnerResponseDto ownerResponseDto = service.saveOwner(ownerRequestDto);
		return response.responseWithData(ownerResponseDto, "success", HttpStatus.CREATED);
	}
	
	@PostMapping("/save-all")
	public ResponseEntity<Object> saveAllPet (@RequestBody @Valid List<OwnerRequestDto> ownerRequestDto) throws NotSaveException
	{
		service.saveAllPet(ownerRequestDto);
		return response.responseWithoutData("success", HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateOwner(@RequestBody @Valid UpdateOwnerDto updateOwnerDto, @PathVariable int id) throws CustomErrorException, NotFoundException
	{
		OwnerResponseDto ownerResponseDto = service.updateOwnerById(updateOwnerDto, id);
		return response.responseWithData(ownerResponseDto, "success", HttpStatus.OK);
		
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getAllOwner() throws NotFoundException
	{
		List<OwnerResponseDto> ownerResponseDto = service.getAllOwner();
		return response.responseWithData(ownerResponseDto, "success", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOwnerById(@PathVariable int id) throws NotFoundException
	{
		OwnerResponseDto ownerResponseDto = service.getOwnerById(id);
		return response.responseWithData(ownerResponseDto, "success", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOwnerById(@PathVariable int id)
	{
		service.deleteOwnerById(id);
		return response.responseWithoutData("success", HttpStatus.OK);
	}
	
}




























