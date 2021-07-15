package com.flight.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight.book.entity.FlightBook;

public interface FlightBookRepo extends JpaRepository<FlightBook, Long>{

	@Query(value = "select (NO_OF_SEATS-ABA_SEAT) from FLIGHT_BOOK where FLIGHT_NUMBER =:flightnumber ", nativeQuery = true)
	Long findByNoOfSeatsMax(@Param("flightnumber") String flightnumber);
	
	@Query(value = "select ID from FLIGHT_BOOK where FLIGHT_NUMBER =:flightnumber ", nativeQuery = true)
	Long findIdofFlight(@Param("flightnumber") String flightnumber);
	
}
