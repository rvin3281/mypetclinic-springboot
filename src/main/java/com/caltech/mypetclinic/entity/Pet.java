package com.caltech.mypetclinic.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pet_id;
	
	@Column(nullable=false)
	private String pet_name;
	
	@Column(nullable=false)
	private String pet_age;
	
	@Column(nullable=false)
	private String pet_sex;
	
	@Column(nullable=false)
	private LocalDate pet_dob;
	
	@Column(nullable=false)
	private String pet_species;
	
	@Column(nullable=false)
	private String pet_breed;
	
	@Column(nullable=false)
	private Timestamp pet_created_timestamp;
	
	@Column(nullable=false)
	private Timestamp pet_updated_timestamp;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@OneToMany(mappedBy = "pet")
	private List<Consultation> consultation;
	
	@OneToMany(mappedBy = "pet")
	private List<Invoice> invoice;
	
	@PrePersist
	protected void onCreate() {
		pet_created_timestamp = new Timestamp(System.currentTimeMillis());
		pet_updated_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	protected void onUpdate() {
		pet_updated_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
}
