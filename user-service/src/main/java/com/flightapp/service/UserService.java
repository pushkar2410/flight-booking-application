package com.flightapp.service;

import java.net.URISyntaxException;
import java.util.List;

import com.flightapp.dto.FlightResponseDto;
import com.flightapp.dto.SearchFlightRequestDto;
import com.flightapp.dto.SearchFlightResponseDto;
import com.flightapp.model.User;

public interface UserService {
	
	public FlightResponseDto bookTicket(User user, int flightId);
	
	public List<SearchFlightResponseDto> searchFlight(SearchFlightRequestDto searchFlightRequestDto) throws URISyntaxException;
	
	public FlightResponseDto getFlightInformation(String pnrNumber);
	
	public void deleteFlightInformation(String pnr);
	
	public List<FlightResponseDto> getBookingHistory(String email);
	
}
