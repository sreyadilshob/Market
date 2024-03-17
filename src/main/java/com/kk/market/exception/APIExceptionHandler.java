package com.kk.market.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler({ServiceNotavailableException.class})
	ResponseEntity<ErrorMessage> handleServiceNotAvailableException(ServiceNotavailableException exp){
		ErrorMessage errMessage = getErrorMessage(exp, "MKT_10003");
		errMessage.setMessage(exp.getMessage());
		return new ResponseEntity<>(errMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler({HttpClientErrorException.class})
	ResponseEntity<ErrorMessage> handleHttpClientErrorException(HttpClientErrorException exp){
		ErrorMessage errMessage = getErrorMessage(exp, "MKT_10001");
		errMessage.setMessage("HttpClientErrorException occured: "+exp.getMessage());
		return new ResponseEntity<>(errMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler({RuntimeException.class})
	ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException exp){
		ErrorMessage errMessage = getErrorMessage(exp, "MKT_10002");
		errMessage.setMessage("RunTime Exception occured: "+exp.getMessage());
		return new ResponseEntity<>(errMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	private ErrorMessage getErrorMessage(Exception exp, String code) {
		System.out.println("Exception class name "+exp.getClass());
		System.out.println("Exception message "+exp.getMessage());
		ErrorMessage errMessage = new ErrorMessage();
		
		errMessage.setCode(code);
		return errMessage;
	}
}
