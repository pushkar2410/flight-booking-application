package com.flightapp.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.RequestFlightDto;
import com.flightapp.dto.ResponseFlightDto;
import com.flightapp.dto.UserServiceRequestDto;
import com.flightapp.dto.UserServiceResponseDto;
import com.flightapp.model.FlightDetail;
import com.flightapp.service.AdminService;

@RestController
@RequestMapping("/api/v1.0/admin/flight")
public class AdminController {

	private final AdminService adminService;
	private final ModelMapper modelMapper;

	public AdminController(AdminService adminService, ModelMapper modelMapper) {
		super();
		this.adminService = adminService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/")
	public String textS() {
		return "Running";
	}
	@PostMapping("/airline/inventory/add")
	public ResponseEntity<ResponseFlightDto> newFlightSchedule(@RequestBody RequestFlightDto requestFlightDto) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		FlightDetail flightDetail = modelMapper.map(requestFlightDto, FlightDetail.class);

		ResponseFlightDto responseFlightDto = adminService.addFlightDetails(flightDetail);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseFlightDto);
	}

	@GetMapping("/airline/inventory/block/{airline}")
	public String blockedAirline(@PathVariable("airline") String airline) {

		adminService.blockedFlight(airline);
		return "Flight has blocked";
	}

	@PostMapping("/airline")
	public ResponseEntity<List<UserServiceResponseDto>> getFlightDetails(
			@RequestBody UserServiceRequestDto serviceRequestDto) {

		List<UserServiceResponseDto> userServiceResponseDtos = adminService.getFlightDetails(serviceRequestDto);
		return ResponseEntity.status(HttpStatus.OK).body(userServiceResponseDtos);
	}

	@GetMapping("/showAllFlights")
	public ResponseEntity<List<UserServiceResponseDto>> blockedAirline() {

		List<UserServiceResponseDto> allFlight = adminService.getAllFlight();
		
		return ResponseEntity.status(HttpStatus.OK).body(allFlight);
	}
}
