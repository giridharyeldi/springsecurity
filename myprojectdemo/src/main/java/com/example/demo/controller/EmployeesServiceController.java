package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeesSearchDto;
import com.example.demo.model.Employees;
import com.example.demo.model.Users;
import com.example.demo.serviceimpl.EmployeesServiceImpl;
import com.example.demo.utility.ObjectConverter;
import com.example.demo.utility.ResponseUtility;

@RestController
public class EmployeesServiceController {

	@Autowired	private EmployeesServiceImpl empService;
	@Autowired private ObjectConverter objConvert;
	@Autowired private ResponseUtility respUtility;
	
	@GetMapping("/searchByEmp")
	public ResponseEntity<String> empSearch(@RequestParam("firstName") String firstName){
		String jsonResp="";
		
		try {
			List<Object[]> lstEmployees = empService.searchEmployee(firstName);
			if(lstEmployees != null && lstEmployees.size()>0) {
				jsonResp = objConvert.objToJson(lstEmployees);
				System.out.println("Employees search record found.");
				return respUtility.generateResponse(jsonResp, HttpStatus.OK);
			}else {
				return respUtility.generateResponse("No record found.", HttpStatus.OK);
			}
			}catch(Exception e) {
				return respUtility.generateResponse("Internal server error, please retry after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(@RequestBody Employees employee){
		String strJson = "";
		try {
			if(employee != null) {
				Employees createdEmp = empService.createEmployee(employee);
				System.out.println("Employee is created successfull and userid is "+employee.getId());
				strJson = objConvert.objToJson(createdEmp);
				return respUtility.generateResponse(strJson, HttpStatus.CREATED);
			}else {
				return respUtility.generateResponse("Invalid input request.", HttpStatus.BAD_REQUEST);
			}
			}catch(Exception e) {
				return respUtility.generateResponse("Internal server error, please retry after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
}
