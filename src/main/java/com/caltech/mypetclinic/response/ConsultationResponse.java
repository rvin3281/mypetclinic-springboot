package com.caltech.mypetclinic.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.caltech.mypetclinic.dto.ConsultationResponseDto;

@Component
public class ConsultationResponse {

	public ResponseEntity<Object> responseWithData (ConsultationResponseDto consultationResponseDto, String message, HttpStatusCode httpStatusCode)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", message);
		response.put("data", consultationResponseDto);
		response.put("status", httpStatusCode);
		
		return new ResponseEntity<>(response, httpStatusCode);
	}
	
	public ResponseEntity<Object> responseWithoutData (String message, HttpStatusCode httpStatusCode)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", message);
		response.put("status", httpStatusCode);
		
		return new ResponseEntity<>(response, httpStatusCode);
	}
	
	public ResponseEntity<Object> responseWithListData (List<ConsultationResponseDto> consultationResponseDto, String message, HttpStatusCode httpStatusCode)
	{
		Map<String,Object> response = new HashMap<>();
	
		response.put("result", message);
		response.put("data", consultationResponseDto);
		response.put("status", httpStatusCode);
		
		return new ResponseEntity<>(response, httpStatusCode);
	}
	
}
