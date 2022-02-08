package com.flightapp.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapp.dto.FlightResponseDto;
import com.flightapp.dto.SearchFlightRequestDto;
import com.flightapp.dto.SearchFlightResponseDto;
import com.flightapp.exception.NoPNRRecordFoundException;
import com.flightapp.model.FlightRegistration;
import com.flightapp.model.User;
import com.flightapp.repository.UserRepository;
import com.google.common.base.Optional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private RestTemplate restTemplate;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.restTemplate = restTemplate;
	}

	@Override
	public FlightResponseDto bookTicket(User user, int flightId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		user.setPnrNumber(UUID.randomUUID().toString());
		user.setFlightId(flightId);
		
		FlightRegistration flightRegistration = modelMapper.map(user, FlightRegistration.class);
		
		for(int i=0; i < flightRegistration.getPassengers().size();i++) {
			flightRegistration.getPassengers().get(i).setFlightId(flightId);	
		}
		
		userRepository.save(flightRegistration);
		FlightResponseDto responseDto = modelMapper.map(flightRegistration, FlightResponseDto.class);
		return responseDto;
	}
	
	@Override
	public List<SearchFlightResponseDto> searchFlight(SearchFlightRequestDto searchFlightRequestDto) throws URISyntaxException {

		URI uri = new URI("http://admin-service/api/v1.0/admin/flight/airline");
		HttpEntity<SearchFlightRequestDto> entity = new HttpEntity<>(searchFlightRequestDto);
		ResponseEntity<SearchFlightResponseDto[]> data = restTemplate.exchange(uri.toString(), HttpMethod.POST, entity,
				SearchFlightResponseDto[].class);
		List<SearchFlightResponseDto> result = Arrays.asList(data.getBody());
		return result;
	}

	@Override
	public FlightResponseDto getFlightInformation(String pnrNumber) {
		Optional<FlightRegistration> byPnrNumber = userRepository.findByPnrNumber(pnrNumber);
		if (byPnrNumber.isPresent()) {
			System.out.println("Result--->"+byPnrNumber.get().getPassengers());
			return modelMapper.map(byPnrNumber.get(), FlightResponseDto.class);
		} else {
			throw new NoPNRRecordFoundException(" No Record found for PNR no " + pnrNumber);
		}
	}

	
	@Transactional
	@Override
	public void deleteFlightInformation(String pnr) {
		userRepository.deleteByPnrNumber(pnr);
	}

	@Override
	public List<FlightResponseDto> getBookingHistory(String email) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<FlightRegistration> allByEmail = userRepository.findAllByEmail(email);
		
		 List<FlightResponseDto> asList = Arrays.asList(modelMapper.map(allByEmail, FlightResponseDto[].class));
		 return asList;
	}

}
