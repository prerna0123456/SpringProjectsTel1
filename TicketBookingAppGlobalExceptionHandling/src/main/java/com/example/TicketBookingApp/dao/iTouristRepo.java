package com.example.TicketBookingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketBookingApp.model.Tourist;

public interface iTouristRepo extends JpaRepository<Tourist, Integer> {

}
