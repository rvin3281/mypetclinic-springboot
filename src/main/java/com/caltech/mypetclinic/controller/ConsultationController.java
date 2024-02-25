	package com.caltech.mypetclinic.controller;

import java.util.List;

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

import com.caltech.mypetclinic.dto.ConsultationRequestDto;
import com.caltech.mypetclinic.dto.ConsultationResponseDto;
import com.caltech.mypetclinic.dto.UpdateConsultationDto;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.response.ConsultationResponse;
import com.caltech.mypetclinic.service.ConsultationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/consultation/")
@CrossOrigin
@Tag(name="Consultation")
public class ConsultationController {

	@Autowired
	ConsultationService service;
	
	@Autowired
	ConsultationResponse response;
	
	@PostMapping("")
	private ResponseEntity<Object> saveConsultation (@RequestBody @Valid ConsultationRequestDto consultationRequestDto) throws NotFoundException
	{
		ConsultationResponseDto consultationResponseDto = service.saveConsultation(consultationRequestDto);
		
		return response.responseWithData(consultationResponseDto, "success", HttpStatus.CREATED);
	}
	
	@GetMapping("")
	private ResponseEntity<Object> getAllConsultation() throws NotFoundException
	{
		List<ConsultationResponseDto> consultationReponseDto = service.getAllConsultation();
		return response.responseWithListData(consultationReponseDto, "success", HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	private ResponseEntity<Object> getConsultationById(@PathVariable int id) throws NotFoundException
	{
		ConsultationResponseDto consultationResponseDto = service.getConsultationById(id);
		return response.responseWithData(consultationResponseDto, "success", HttpStatus.OK);
	}
	
	@PatchMapping("{id}")
	private ResponseEntity<Object> updateConsultationById(@RequestBody @Valid UpdateConsultationDto updateConsultationDto, @PathVariable int id) throws NotFoundException
	{
		ConsultationResponseDto consultationResponseDto = service.updateConsultationById(updateConsultationDto, id);
		
		return response.responseWithData(consultationResponseDto, "success", HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<Object> deleteConsultationById(@PathVariable int id)
	{
		service.deleteConsultation(id);
		return response.responseWithoutData("success", HttpStatus.NO_CONTENT);
	}
	
}
