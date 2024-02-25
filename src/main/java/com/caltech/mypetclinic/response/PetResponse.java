package com.caltech.mypetclinic.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.caltech.mypetclinic.dto.PetResponseDto;

@Component
public class PetResponse {

	public ResponseEntity<Object> responseWithData(Object object, String message, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", message);
		response.put("data", object);
		
		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	public ResponseEntity<Object> responseWithoutData(String message, HttpStatus httpStatus){
		
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", message);
		
		return new ResponseEntity<>(response, httpStatus);
		
	}
	
}
