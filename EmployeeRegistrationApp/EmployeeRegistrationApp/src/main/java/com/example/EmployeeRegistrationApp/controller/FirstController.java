package com.example.EmployeeRegistrationApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmployeeRegistrationApp.repository.Employee;
import com.example.EmployeeRegistrationApp.repository.iEmployeeRepo;

@Controller
public class FirstController {
	
	@Autowired
	private iEmployeeRepo repo;
	
	@GetMapping("/register")
	public String employeeRegistration() {
		
		return "register";
	}
	
	
	
	@PostMapping("/register")
	public String register(Map<String,Object> map, @ModelAttribute("emp")Employee emp) {
		System.out.println("In controller");
		System.out.println(emp);
		repo.save(emp);
	List<Employee> byFname = repo.findByFname("Bhavani");
	
	for(Employee e:byFname) {
		System.out.println("Employee by fname "+e);
	}
		
		map.put("emp", emp); //just to send to response page
		System.out.println("employee  "+emp);
		return "response";
	}

}
