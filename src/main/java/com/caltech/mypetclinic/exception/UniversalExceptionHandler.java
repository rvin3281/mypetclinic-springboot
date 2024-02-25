package com.caltech.mypetclinic.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caltech.mypetclinic.exception.customException.CustomErrorException;
import com.caltech.mypetclinic.exception.customException.NotFoundException;
import com.caltech.mypetclinic.exception.customException.NotSaveException;

import jakarta.validation.UnexpectedTypeException;

@RestControllerAdvice
public class UniversalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleInvalidArgument (MethodArgumentNotValidException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		Map<String,Object> errors = new HashMap<>();
		
		List<String> customError = new ArrayList<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			customError.add(error.getDefaultMessage());
		});
		errorResponse.put("result", "fail");
		errorResponse.put("data", customError);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgument (IllegalArgumentException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();

		errorResponse.put("message", "fail");
		errorResponse.put("data", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFound (NotFoundException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("message", "fail");
		errorResponse.put("error", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> sqlConstraintError (SQLIntegrityConstraintViolationException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("message", "fail");
		errorResponse.put("error", ex.getStackTrace());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNotFoundById (NoSuchElementException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("message","fail");
		errorResponse.put("error", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotSaveException.class)
	public ResponseEntity<Object> handleNotSave (NotSaveException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("message","fail");
		errorResponse.put("error", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Object> handleUnexpectedTypeException (UnexpectedTypeException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("message", "fail");
		errorResponse.put("error", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomErrorException.class)
	public ResponseEntity<Object> handleNotSave (CustomErrorException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("message","fail");
		errorResponse.put("error", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
































