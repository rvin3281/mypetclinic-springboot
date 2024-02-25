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
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer consultation_id;
	
	@Column(nullable=false)
	private String consultation_note;
	
	@Column(nullable=false)
	private LocalDate consultation_visitdate;
	
	@Column(nullable=false)
	private String consultation_symptoms;
	
	@Column(nullable=false)
	private String consultation_diagnosis;
	
	@Column(nullable=false)
	private String consultation_treatment;
	
	@Column(nullable=false)
	private String consultation_prescribe_medicine;
	
	@Column(nullable=false)
	private String consultation_fee;
	
	@Column(nullable=false)
	private Timestamp consultation_created_timestamp;
	
	@Column(nullable=false)
	private Timestamp consultation_updated_timestamp;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	@PrePersist
	protected void onCreate() {
		consultation_created_timestamp = new Timestamp(System.currentTimeMillis());
		consultation_updated_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	protected void onUpdate() {
		consultation_updated_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
}
