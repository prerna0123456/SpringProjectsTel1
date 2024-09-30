package com.example.TicketBookingApp.service;

import java.util.List;

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

	
}
