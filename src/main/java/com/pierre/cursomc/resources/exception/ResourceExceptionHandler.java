package com.pierre.cursomc.resources.exception;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.pierre.cursomc.services.exceptions.DataIntegrityException;
import com.pierre.cursomc.services.exceptions.ObjectNotfoundException;

@ControllerAdvice
public class ResourceExceptionHandler{
	
	@ExceptionHandler(ObjectNotfoundException.class)
	public ResponseEntity<StandreError> objectNotfound(ObjectNotfoundException e, HttpServletRequest request){
		StandreError err = new StandreError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
    
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandreError> dataIntegrity(ObjectNotfoundException e, HttpServletRequest request){
		StandreError err = new StandreError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
