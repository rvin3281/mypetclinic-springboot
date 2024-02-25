package com.caltech.mypetclinic.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceResponse {

	public ResponseEntity<Object> responseWithData(Object object, String message, HttpStatus httpStatusCode)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("message", message);
		response.put("data", object);

		return new ResponseEntity<>(response,httpStatusCode);
		
	}
	
	public ResponseEntity<Object> responseWithoutData(String message, HttpStatus httpStatusCode)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("message", message);

		return new ResponseEntity<>(response,httpStatusCode);
		
	}
	
}
