package com.flightapp.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.FlightRequestDto;
import com.flightapp.dto.FlightResponseDto;
import com.flightapp.dto.SearchFlightRequestDto;
import com.flightapp.dto.SearchFlightResponseDto;
import com.flightapp.exception.FlightNotFoundException;
import com.flightapp.model.User;
import com.flightapp.service.UserService;

@RestController
@RequestMapping("/api/v1.0/user/flight")
public class UserController {

	private final UserService userService;
	private final ModelMapper modelMapper;

	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("/search")
	public ResponseEntity<List<SearchFlightResponseDto>> searchFlight(
			@RequestBody SearchFlightRequestDto searchFlightRequestDto) throws URISyntaxException {

		List<SearchFlightResponseDto> searchFlightResultDTO = userService.searchFlight(searchFlightRequestDto);

		return ResponseEntity.status(HttpStatus.OK).body(searchFlightResultDTO);

	}

	@PostMapping("/booking/{flightId}")
	public ResponseEntity<FlightResponseDto> forFlightRegistration(@RequestBody FlightRequestDto dto,
			@PathVariable("flightId") int flightId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		User user = modelMapper.map(dto, User.class);

		FlightResponseDto flightResponseDto = userService.bookTicket(user, flightId);

		return ResponseEntity.status(HttpStatus.OK).body(flightResponseDto);
	}

	@GetMapping("/ticket/{pnrNumber}")
	public ResponseEntity<FlightResponseDto> getFlightDetails(@PathVariable("pnrNumber") String pnrNumber) {
		FlightResponseDto flightInformation = userService.getFlightInformation(pnrNumber);

		if (flightInformation == null) {
			throw new FlightNotFoundException("Flight with pnr number " + pnrNumber + " is not found. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(flightInformation);
	}

	@DeleteMapping("/booking/delete/{pnrNumber}")
	public String deleteFlightDetails(@PathVariable("pnrNumber") String pnrNumber) {

		userService.deleteFlightInformation(pnrNumber);
		return "Flight with PNR Number  " + pnrNumber + " is deleted";
	}

	@GetMapping("/booking/history/{email}")
	public ResponseEntity<List<FlightResponseDto>> getFlightBookingHistory(@PathVariable("email") String email) {

		List<FlightResponseDto> flightDetails = userService.getBookingHistory(email);

		return ResponseEntity.status(HttpStatus.OK).body(flightDetails);
	}

}
