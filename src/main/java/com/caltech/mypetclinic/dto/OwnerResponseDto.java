package com.caltech.mypetclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponseDto {

	private Integer owner_id;
	private String owner_firstname;
	private String owner_lastname;
	private String owner_mobileno;
	private String owner_email;
	private String owner_address;
	private String owner_state;
	private String owner_city;
	private String owner_postalcode;
	private String owner_created_timestamp;
	private String owner_update_timestamp;
	
}
