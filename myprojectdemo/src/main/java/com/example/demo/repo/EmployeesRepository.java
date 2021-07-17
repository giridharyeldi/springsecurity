package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.EmployeesSearchDto;
import com.example.demo.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{

	//@Query("Select e.firstName,e.lastName,e.dob from Employees e where firstName like %:firstName%")
	@Query("select e.firstName,e.lastName,e.dob,concat(m.firstName,' ',m.lastName) from Employees e,Employees m where e.firstName like %:firstName% and m.id=e.managerId")
	public List<Object[]> searchEmployee(@Param("firstName") String firstName);
	
}
