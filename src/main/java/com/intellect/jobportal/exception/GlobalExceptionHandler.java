package com.intellect.jobportal.exception;
import java.io.IOException;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.intellect.jobportal.enums.ErrorMessages;
import com.intellect.jobportal.model.common.BaseResponse;
import com.intellect.jobportal.utils.Utils;

@ControllerAdvice  
@RestController  
public class GlobalExceptionHandler {   
	
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class); 
  
    @ExceptionHandler(value = { BaseException.class})
	public ResponseEntity<BaseResponse> defaultLICErrorHandler(BaseException exception) {
		
		LOG.info(" defaultLICErrorHandler : ");
		LOG.error(exception.getMessage(), exception);
		ErrorMessages errorMessages = exception.errorMessages;
		
		String message = errorMessages.geterrorMessage();
		if( Utils.isNotEmpty( exception.customMessage ) ) {
			message = MessageFormat.format( message, exception.customMessage);
		}
		
		BaseResponse response = new BaseResponse();
		response.setStatus(exception.status);
		response.setMessage( message );
		response.setCode( errorMessages.geterrorCode() );
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
    
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<BaseResponse> defaultErrorHandler(Exception exception) {
		LOG.info(" defaultErrorHandler :: ");
		LOG.error(exception.getMessage(), exception);
		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*@ExceptionHandler(value = { MappingException.class })
	public ResponseEntity<BaseResponse> defaultErrorHandler( MappingException exception) {
		LOG.info(" defaultErrorHandler :: ");
		LOG.error(exception.getMessage(), exception);
		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
	@ExceptionHandler(value = { HttpClientErrorException.class })
	public ResponseEntity<BaseResponse> defaultErrorHandler(HttpClientErrorException exception) {
		LOG.info(" defaultErrorHandler :: ");
		LOG.error(exception.getMessage(), exception);
		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * @param request
	 * @param exception
	 * @return
	 * This method handled IOException and SocketTimeoutException
	 */
	@ExceptionHandler(value = { IOException.class })
	public ResponseEntity<BaseResponse> defaultErrorHandler( IOException exception) {
		LOG.info(" defaultErrorHandler :: ");
		LOG.error(exception.getMessage(), exception);
		BaseResponse response = new BaseResponse();
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 
	 
	 
	 
	 @ExceptionHandler(value = { HttpServerErrorException.class })
		public ResponseEntity<BaseResponse> defaultErrorHandler( HttpServerErrorException exception) {
			LOG.info(" defaultErrorHandler :: ");
			LOG.error(exception.getMessage(), exception);
			BaseResponse response = new BaseResponse();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
} 