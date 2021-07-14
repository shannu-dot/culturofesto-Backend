package com.CulturoFesto.Exception;

import java.net.BindException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	// Festival not found
	@ExceptionHandler(FestivalNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handleAdmninNotFoundException(FestivalNotFoundException e, HttpServletRequest request) {

		logger.info("In controller advice to find the FestivalId");

		ErrorInfo error = new ErrorInfo(); // create instance of ErrorInfo
		error.setUrl(request.getRequestURI());
		error.setMessage(e.getMessage());

		return error;
	}
	
	// binding exception because of validation
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ResponseEntity<String> handleBindException(BindException e){
			
		return new ResponseEntity<>("Bind error on path parameter", HttpStatus.BAD_REQUEST);
		
	}

}
