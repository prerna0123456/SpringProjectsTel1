package com.example.EmployeeRegistrationApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface iEmployeeRepo extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByFname(String fname);

}
