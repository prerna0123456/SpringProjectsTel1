package com.example.TicketBookingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tid;
	
	private String name;
	
	private String city;
	
	private String packageType;
	
	private Double budget;

	public Tourist() {
		super();
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Tourist [tid=" + tid + ", name=" + name + ", city=" + city + ", packageType=" + packageType
				+ ", budget=" + budget + "]";
	}
	
	

}
