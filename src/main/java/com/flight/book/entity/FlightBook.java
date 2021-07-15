package com.flight.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FlightBook {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String flightNumber;
	private Long noOfSeats;
	private Long abaSeat;
	
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
	public Long getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Long noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public Long getAbaSeat() {
		return abaSeat;
	}
	public void setAbaSeat(Long abaSeat) {
		this.abaSeat = abaSeat;
	}
	
}
