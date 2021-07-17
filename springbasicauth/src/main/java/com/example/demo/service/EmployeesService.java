package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.EmployeesSearchDto;
import com.example.demo.model.Employees;

public interface EmployeesService {

	public List<Object[]> searchEmployee(String firstName);
	public Employees createEmployee(Employees employee);
	
}
