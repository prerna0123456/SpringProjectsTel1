package com.example.TicketBookingApp.advice;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private String StatusCode;
	
	private String msg;
	
	private LocalDateTime when;

	public ErrorDetails(String statusCode, String msg, LocalDateTime when) {
		super();
		StatusCode = statusCode;
		this.msg = msg;
		this.when = when;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getWhen() {
		return when;
	}

	public void setWhen(LocalDateTime when) {
		this.when = when;
	}

	@Override
	public String toString() {
		return "ErrorDetails [StatusCode=" + StatusCode + ", msg=" + msg + ", when=" + when + "]";
	}
	
	

}
