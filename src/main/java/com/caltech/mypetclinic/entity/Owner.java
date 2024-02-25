package com.caltech.mypetclinic.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Owner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Integer owner_id;
	
	@Column(nullable=false)
	private String owner_firstname;
	
	@Column(nullable=false)
	private String owner_lastname;
	
	@Column(nullable=false)
	private String owner_email;
	
	@Column(nullable=false)
	private String owner_mobileno;
	
	@Column(nullable=false)
	private String owner_address;
	
	@Column(nullable=false)
	private String owner_state;
	
	@Column(nullable=false)
	private String owner_city;
	
	@Column(nullable=false)
	private String owner_postalcode;
	
	@Column(nullable=false)
	private Timestamp owner_created_timestamp;
	
	@Column(nullable=false)
	private Timestamp owner_update_timestamp;
	
	@OneToMany(mappedBy="owner")
	private List<Pet> pet;
	
	@OneToMany(mappedBy="owner")
	private List<Invoice> invoice;
	
	@PrePersist
	protected void onCreate() {
		owner_created_timestamp = new Timestamp(System.currentTimeMillis());
		owner_update_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	protected void onUpdate() {
		owner_update_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
}







