package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.serviceimpl.UsersServiceImpl;
import com.example.demo.utility.ObjectConverter;
import com.example.demo.utility.ResponseUtility;

@RestController
public class UsersServiceController {

	@Autowired private ObjectConverter objConvert;
	@Autowired private ResponseUtility respUtility;
	@Autowired private UsersServiceImpl usersService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Welcome to my spring boot application";
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestBody Users user){
		try {
		if(user != null) {
			Users createUser = usersService.createUser(user);
			System.out.println("User is created successfull and userid is "+createUser.getId());
			return respUtility.generateResponse("User is created successfully and userid is "+createUser.getId(), HttpStatus.CREATED);
		}else {
			return respUtility.generateResponse("Invalid input request.", HttpStatus.BAD_REQUEST);
		}
		}catch(Exception e) {
			return respUtility.generateResponse("Internal server error, please retry after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
