package com.caltech.mypetclinic.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.caltech.mypetclinic.dto.InvoiceRequestDto;
import com.caltech.mypetclinic.dto.InvoiceResponseDto;
import com.caltech.mypetclinic.entity.Invoice;

@Mapper(componentModel="spring")
public interface InvoiceMapper {

	public InvoiceResponseDto invoiceToInvoiceResponseDto (Invoice invoice);
	
	public Invoice invoiceResponseDtoToInvoice (InvoiceResponseDto invoiceResponseDto);
	
	public List<InvoiceResponseDto> listInvoiceToInvoiceResponseDto(List<Invoice> invoice);
	
	public Invoice invoiceRequestDtoToInvoice (InvoiceRequestDto invoiceRequestDto);
}
