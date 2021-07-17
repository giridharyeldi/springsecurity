package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employees;
import com.example.demo.repo.EmployeesRepository;
import com.example.demo.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService{

	@Autowired
	private EmployeesRepository empRepository;
	
	@Override
	public List<Object[]> searchEmployee(String firstName) {
		List<Object[]> lstEmp = empRepository.searchEmployee(firstName);
		
		return lstEmp;
	}

	@Override
	public Employees createEmployee(Employees employee) {
		Employees tmpEmp = empRepository.save(employee);
		return tmpEmp;
	}

	
	
}
