package com.example.demo.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtility {

	public ResponseEntity<String> generateResponse(String body, HttpStatus httpStatus){
		ResponseEntity<String> response = new ResponseEntity<String>(body, httpStatus);
		return response;
	}
}
