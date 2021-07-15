package com.flight.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String flightNumber;
	private String userName;
	private Long seatNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Long seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
