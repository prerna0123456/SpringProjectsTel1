package com.example.TicketBookingApp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketBookingApp.exception.TouristNotFoundException;
import com.example.TicketBookingApp.model.Tourist;
import com.example.TicketBookingApp.service.iTouristManagement;

@RestController
@RequestMapping("/api")
public class TouristController {
	
	@Autowired
	private iTouristManagement  service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		
		try {
		String msg=service.registerTourist(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Some problem in enrolling", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll") //exception handling is done here but its wrong, you should use global exception handling
	public ResponseEntity<?> fetchAllTourist(){
		
		try {
			List<Tourist> list = service.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Some problem in enrolling", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findByID/{id}")
	public ResponseEntity<?> fetchTouristByID(@PathVariable("id") Integer id){
		try {
			Tourist tourist = service.fetchTouristInfoByID(id);
		return new ResponseEntity<>(tourist, HttpStatus.OK);
		}catch(TouristNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
