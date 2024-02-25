package com.caltech.mypetclinic.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer invoice_id;

	@Column(nullable=false)
	private LocalDate invoice_issuedate;
	
	@Column(nullable=false)
	private LocalDate invoice_duedate;
	
	@Column(nullable=false)
	private String invoice_totalamount;
	
	@Column(nullable=false)
	private String invoice_paidamount;
	
	@Column(nullable=false)
	private String invoice_paymentstatus;
	
	@Column(nullable=false)
	private String invoice_paymentmethod;
	
	private String invoice_notes;
	
	private Timestamp invoice_create_timestamp;
	
	private Timestamp invoice_update_timestamp;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
    private Pet pet;
	
	@PrePersist
	protected void onCreate() {
		invoice_create_timestamp = new Timestamp(System.currentTimeMillis());
		invoice_update_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	protected void onUpdate() {
		invoice_update_timestamp = new Timestamp(System.currentTimeMillis());
	}
}





