package com.caltech.mypetclinic.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.caltech.mypetclinic.entity.Owner;
import com.caltech.mypetclinic.entity.Pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDto {

	private Integer invoice_id;
	
	private LocalDate invoice_issuedate;              
    
	private LocalDate invoice_duedate;                
	                                             
	private String invoice_totalamount;          
	                                             
	private String invoice_paidamount;           
	                                             
	private String invoice_paymentstatus;        
	                                             
	private String invoice_paymentmethod;        
	                                             
	private String invoice_notes;                
	                                             
	private Timestamp invoice_create_timestamp;  
	                                             
	private Timestamp invoice_update_timestamp;
	
	private Owner owner;
	
	private Pet pet;
	
}
