package com.flight.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.book.entity.FlightBook;
import com.flight.book.entity.UserInfo;
import com.flight.book.repo.FlightBookRepo;
import com.flight.book.repo.UserInfoRepo;
import com.flight.book.response.FlightResponse;

@RestController
@RequestMapping("/flight")
public class FlightBookingController {

	@Autowired
	private FlightBookRepo flightBookRepo;
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@PostMapping("/scheduleFlight")
	public FlightResponse getscheduleFlight(@RequestBody FlightBook flightBook)
	{
		flightBookRepo.save(flightBook);
		FlightResponse flightResponse = new FlightResponse();
		flightResponse.setStatus("Success");
		flightResponse.setMessage("");
		return flightResponse;
	}
	@PostMapping("/bookSeat")
	public FlightResponse getbookSeat(@RequestBody UserInfo userInfo)
	{
		FlightResponse flightResponse = new FlightResponse();
		Long noofseatsMaxId = flightBookRepo.findByNoOfSeatsMax(userInfo.getFlightNumber());
		if(noofseatsMaxId  >0)
		{
			Long noofseatsMax = flightBookRepo.findByNoOfSeatsMax(userInfo.getFlightNumber());
			Long noofseats = userInfoRepo.findByNoOfSeats(userInfo.getFlightNumber());
			userInfo.setSeatNumber(noofseats);
			userInfoRepo.save(userInfo);
			
			FlightBook flightBook = (FlightBook)flightBookRepo.getById(flightBookRepo.findIdofFlight(userInfo.getFlightNumber()));
			flightBook.setAbaSeat(noofseatsMax - 1);
			flightBookRepo.save(flightBook);
			
			flightResponse.setStatus("Success");
			flightResponse.setSeatNumber(noofseats);
			flightResponse.setMessage("");
		}else
		{
			flightResponse = new FlightResponse();
			flightResponse.setStatus("Failure");
			flightResponse.setSeatNumber(0L);
			flightResponse.setMessage("Tickets full!!!");
		}
		
		return flightResponse;
	}
	@GetMapping("/getAvailableSeats")
	public FlightResponse getAvailableSeats(@RequestParam(name = "flightNumber") String number)
	{ 
		Long noofseatsMax = flightBookRepo.findByNoOfSeatsMax(number);
		FlightResponse flightResponse = new FlightResponse();
		flightResponse.setStatus("Success");
		flightResponse.setSeatNumber((long) 0);
		flightResponse.setMessage("");
		flightResponse.setCount(noofseatsMax);
		return flightResponse;
	}
}
