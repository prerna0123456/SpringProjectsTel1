package com.example.TicketBookingApp.service;

import java.util.List;

import com.example.TicketBookingApp.model.Tourist;

public interface iTouristManagement {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> findAll();
	public Tourist fetchTouristInfoByID(Integer id);
	public String updateTouristInfo(Tourist tourist);
	public String updateTouristInfoByID(Integer id, Double budget);
	public String deleteTouristByID(Integer id);
}
