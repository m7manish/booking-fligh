package com.flight.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight.book.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

	@Query(value = "select nvl(max(SEAT_NUMBER),1) from USER_INFO where FLIGHT_NUMBER =:flightnumber ", nativeQuery = true)
	Long findByNoOfSeats(@Param("flightnumber") String flightnumber);
}
