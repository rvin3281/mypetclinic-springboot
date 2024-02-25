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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.mypetclinic.dto.InvoiceRequestDto;
import com.caltech.mypetclinic.dto.InvoiceResponseDto;
import com.caltech.mypetclinic.dto.UpdateInvoiceDto;
import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.response.InvoiceResponse;
import com.caltech.mypetclinic.service.InvoiceService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1/invoice")
@CrossOrigin
@Tag(name="Invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
	@Autowired
	private InvoiceResponse response;
	
	@PostMapping("")
	public ResponseEntity<Object> saveInvoice(InvoiceRequestDto invoiceRequestDto)
	{
		InvoiceResponseDto invoiceResponseDto = service.saveInvoice(invoiceRequestDto);
		return response.responseWithData(invoiceResponseDto, "success", HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getAllInvoice () throws NotFoundException
	{
		List<InvoiceResponseDto> invoiceResponseDto = service.getAllInvoice();
		return response.responseWithData(invoiceResponseDto, "success", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getInvoiceById(@PathVariable int id) throws NotFoundException
	{
		InvoiceResponseDto invoiceResponseDto = service.getInvoiceById(id);
		return response.responseWithData(invoiceResponseDto, "success", HttpStatus.OK);
	}
	
	@PatchMapping("")
	public ResponseEntity<Object> updateInvoiceById(UpdateInvoiceDto updateInvoiceDto, int id) throws CustomErrorException, NotFoundException
	{
		InvoiceResponseDto invoiceResponseDto = service.updateInvoiceById(updateInvoiceDto, id);
		return response.responseWithData(invoiceResponseDto, "success", HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<Object> deleteInvoiceById(@PathVariable int id) {
		
		service.deleteInvoiceById(id);
		return response.responseWithoutData("success", HttpStatus.OK);
	}
}
