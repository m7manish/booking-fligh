package com.flight.book.response;

public class FlightResponse {

	private String status;
	private String message;
	private Long seatNumber;
	private Long count;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Long seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
