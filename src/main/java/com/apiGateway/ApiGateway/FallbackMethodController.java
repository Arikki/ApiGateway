package com.apiGateway.ApiGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
	
	private Logger logger = LoggerFactory.getLogger(FallbackMethodController.class);
	@RequestMapping("/serviceFallBack")
	public ResponseEntity<ErrorMessage> serviceFallBackMethod(){
		
		ErrorMessage message = new ErrorMessage(HttpStatus.SERVICE_UNAVAILABLE, "Service is taking longer "
				+ "than expected or is down. Please try again");
		
		logger.error(message.toString());
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(message);
		
	}
	
	

	

}
