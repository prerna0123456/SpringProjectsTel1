package com.example.EmployeeRegistrationApp.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer empid;
	
	private String fname;
	private String lname;
	private String city;
	private Integer age;
	
	
	
	
	public Employee() {
		super();
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", city=" + city + ", age=" + age
				+ "]";
	}
	
	

}
