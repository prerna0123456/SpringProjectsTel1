package com.example.TicketBookingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketBookingApp.dao.iTouristRepo;
import com.example.TicketBookingApp.exception.TouristNotFoundException;
import com.example.TicketBookingApp.model.Tourist;

@Service
public class TouristManagementImpl implements iTouristManagement {

	@Autowired
	private iTouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {

		Integer id = repo.save(tourist).getTid();
		return "Tourist info saved with id:"+ id;
	}

	@Override
	public List<Tourist> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Tourist fetchTouristInfoByID(Integer id) {
		
		return repo.findById(id).
				orElseThrow(()->new TouristNotFoundException("Tourist with given id "+id+" not found"));
	}

	@Override
	public String updateTouristInfo(Tourist tourist) {

		Integer id = tourist.getTid();
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.save(tourist); //if the id is present, it updates the record or if not present it saves, but in this case if it's not present, it will go to else block and throw exception
			return "Tourist info with id "+id+" updated";
		}else {
			throw new TouristNotFoundException("Tourist not found with id: "+id);
			
		}

	}

	@Override
	public String updateTouristInfoByID(Integer id, Double budget) {

		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Budget updated for tourist info with id "+id;
		}else {
			throw new TouristNotFoundException("Tourist not found with id: "+id);
		}

	}

	@Override
	public String deleteTouristByID(Integer id) {

		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			repo.delete(tourist);
			return "Tourist deleted with id: "+id;
			// another way
			//repo.deleteById(id); //then put a return message
		}else {
			throw new TouristNotFoundException("Tourist with id "+id+" not present");
		}

	}

	
}
