package com.flightapp.service;

import java.util.List;

import com.flightapp.dto.ResponseFlightDto;
import com.flightapp.dto.UserServiceRequestDto;
import com.flightapp.dto.UserServiceResponseDto;
import com.flightapp.model.FlightDetail;

public interface AdminService {
	
	ResponseFlightDto addFlightDetails(FlightDetail flightDetail);

	void blockedFlight(String airline);

	List<UserServiceResponseDto> getFlightDetails(UserServiceRequestDto userServiceRequestDto);
	
	List<UserServiceResponseDto> getAllFlight();
}
