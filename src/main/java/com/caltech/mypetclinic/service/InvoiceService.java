package com.caltech.mypetclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.mypetclinic.dto.InvoiceRequestDto;
import com.caltech.mypetclinic.dto.InvoiceResponseDto;
import com.caltech.mypetclinic.dto.UpdateInvoiceDto;
import com.caltech.mypetclinic.entity.Invoice;
import com.caltech.mypetclinic.entity.Owner;
import com.caltech.mypetclinic.entity.Pet;
import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.mapper.InvoiceMapper;
import com.caltech.mypetclinic.repository.InvoiceRepo;
import com.caltech.mypetclinic.repository.OwnerRepo;
import com.caltech.mypetclinic.repository.PetRepo;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepo repo;
	
	@Autowired
	private InvoiceMapper mapper;
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private PetRepo petRepo;
	
	public InvoiceResponseDto saveInvoice(InvoiceRequestDto invoiceRequestDto)
	{
		Invoice invoice = repo.save(mapper.invoiceRequestDtoToInvoice(invoiceRequestDto));
		InvoiceResponseDto invoiceResponseDto = mapper.invoiceToInvoiceResponseDto(invoice);
		return invoiceResponseDto;
	}
	
	public List<InvoiceResponseDto> getAllInvoice () throws NotFoundException
	{
		List<Invoice> invoice = repo.findAll();
		
		if(!invoice.isEmpty())
		{
			
			List<InvoiceResponseDto> invoiceResponseDto = mapper.listInvoiceToInvoiceResponseDto(invoice);
			return invoiceResponseDto;
			
		}else {
			throw new NotFoundException("Invoice Not Found");
		}
	}
	
	public InvoiceResponseDto getInvoiceById(int id) throws NotFoundException
	{
		Invoice invoice = repo.findById(id).orElseThrow(()-> new NotFoundException("Invoice not found with ID "+id));
		InvoiceResponseDto invoiceResponseDto = mapper.invoiceToInvoiceResponseDto(invoice);
		return invoiceResponseDto;
	}
	
	public InvoiceResponseDto updateInvoiceById(UpdateInvoiceDto updateInvoiceDto, int id) throws CustomErrorException, NotFoundException
	{
		if(updateInvoiceDto.getInvoice_id() != null)
		{
			if(updateInvoiceDto.getInvoice_id().intValue() == id)
			{
				Invoice invoice = repo.findById(id).orElseThrow(()-> new NotFoundException("Invoice Not Found with ID "+id));
				
				if(updateInvoiceDto.getOwner_id() != null)
				{
					int ownerId = updateInvoiceDto.getOwner_id().intValue();
					Owner owner = ownerRepo.findById(ownerId).orElseThrow(()-> new NotFoundException("Owner not Found with ID "+ownerId));
					invoice.setOwner(owner);
					
				}
				if(updateInvoiceDto.getPet_id() != null)
				{
					int petId = updateInvoiceDto.getPet_id().intValue();
					Pet pet = petRepo.findById(petId).orElseThrow(()-> new NotFoundException("Pet not Found with ID "+petId));
					invoice.setPet(pet);
				}
				if(updateInvoiceDto.getInvoice_issuedate() != null)
				{
					invoice.setInvoice_issuedate(updateInvoiceDto.getInvoice_issuedate());
				}
				if(updateInvoiceDto.getInvoice_duedate() != null)
				{
					invoice.setInvoice_duedate(updateInvoiceDto.getInvoice_duedate());
				}
				if(updateInvoiceDto.getInvoice_totalamount() != null)
				{
					invoice.setInvoice_totalamount(updateInvoiceDto.getInvoice_totalamount());
				}
				if(updateInvoiceDto.getInvoice_paidamount() != null)
				{
					invoice.setInvoice_paidamount(updateInvoiceDto.getInvoice_paidamount());
				}
				if(updateInvoiceDto.getInvoice_paymentstatus() != null)
				{
					invoice.setInvoice_paymentstatus(updateInvoiceDto.getInvoice_paymentstatus());
				}
				if(updateInvoiceDto.getInvoice_paymentmethod() != null)
				{
					invoice.setInvoice_paymentmethod(updateInvoiceDto.getInvoice_paymentmethod());
				}
				if(updateInvoiceDto.getInvoice_notes() != null)
				{
					invoice.setInvoice_notes(updateInvoiceDto.getInvoice_notes());
				}
				
				Invoice savedInvoice = repo.save(invoice);
				InvoiceResponseDto invoiceResponseDto = mapper.invoiceToInvoiceResponseDto(savedInvoice);
				return invoiceResponseDto;
				
			}else
			{
				throw new CustomErrorException("ID on RequestBody and URL not match");
			}
			
		}else
		{
			throw new CustomErrorException("Invoice ID not found on RequestBody");
		}
		
	}
	
	public void deleteInvoiceById(int id) {
		
		repo.deleteById(id);
		
	}
}
