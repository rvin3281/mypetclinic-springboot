package com.caltech.mypetclinic.dto;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceDto {

	@NotNull(message = "invoice id cannot be null")
	private Integer invoice_id;
	
	@NotNull(message = "invoice issuedate cannot be null")
	private LocalDate invoice_issuedate;            
    
	@NotNull(message = "invoice duedate cannot be null")
	private LocalDate invoice_duedate;              
	                  
	@NotNull(message = "invoice total amount cannot be null")
	@NotBlank(message = "invoice total amount cannot be empty")
	private String invoice_totalamount;        
	           
	private String invoice_paidamount;         
	          
	@NotNull(message = "invoice payment status cannot be null")
	@NotBlank(message = "invoice payment status cannot be empty")
	private String invoice_paymentstatus;      
	 
	@NotNull(message = "invoice payment method cannot be null")
	@NotBlank(message = "invoice payment method cannot be empty")
	private String invoice_paymentmethod;      
	                                           
	private String invoice_notes;              
	
	@NotNull(message = "owner id cannot be null")
	private Integer owner_id;
	
	@NotNull(message = "pet id name cannot be null")
	private Integer pet_id;
	
}
