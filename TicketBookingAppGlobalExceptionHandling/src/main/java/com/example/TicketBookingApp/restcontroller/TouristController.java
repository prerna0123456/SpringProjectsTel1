package com.example.TicketBookingApp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		
		String msg=service.registerTourist(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	
	@GetMapping("/findAll") //exception handling is done here but its wrong, you should use global exception handling
	public ResponseEntity<?> fetchAllTourist(){
		
		
			List<Tourist> list = service.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/findByID/{id}")
	public ResponseEntity<?> fetchTouristByID(@PathVariable("id") Integer id){
		
			Tourist tourist = service.fetchTouristInfoByID(id);
		return new ResponseEntity<>(tourist, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateTourist") //put mapping when you want to update everything
	public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist){
		
			String msg=service.updateTouristInfo(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		
	}
	

	@PatchMapping("/updateBudget/{id}/{budget}") //patch mapping when you want to update one particular item
	public ResponseEntity<String> updateBudget(@PathVariable("id") Integer id,@PathVariable("budget") Double budget){ //not adding path variable because id matches the name given
			String msg=service.updateTouristInfoByID(id, budget);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
			
		
	}
	
	@DeleteMapping("/deleteTouristInfo/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable Integer id){
		
			String msg=service.deleteTouristByID(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);	
		
		
	}
}
