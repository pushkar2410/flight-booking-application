package com.flightapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dto.ResponseFlightDto;
import com.flightapp.dto.UserServiceRequestDto;
import com.flightapp.dto.UserServiceResponseDto;
import com.flightapp.model.FlightDetail;
import com.flightapp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminRepository adminRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper) {
		super();
		this.adminRepository = adminRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseFlightDto addFlightDetails(FlightDetail flightDetail) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		adminRepository.save(flightDetail);
		ResponseFlightDto responseFlightDto = modelMapper.map(flightDetail, ResponseFlightDto.class);
		return responseFlightDto;
	}

	@Override
	public void blockedFlight(String airline) {
		adminRepository.setFlightDetailsByAirline(airline);
	}

	@Override
	public List<UserServiceResponseDto> getFlightDetails(UserServiceRequestDto userServiceRequestDto) {
		
		List<UserServiceResponseDto> list = new ArrayList<>();
		List<FlightDetail> flightDetails = adminRepository.getFlightDetails(userServiceRequestDto.getSrcLocation(),
				userServiceRequestDto.getDestLocation());
		
		for(FlightDetail flightDetail : flightDetails) {
			UserServiceResponseDto responseDto = new UserServiceResponseDto();
			responseDto.setDate(flightDetail.getStartDate());
			responseDto.setFlightId(flightDetail.getFlightNo());
			responseDto.setFlightName(flightDetail.getAirline());
			responseDto.setFare(String.valueOf(flightDetail.getPrice()));
			list.add(responseDto);
		}

		return list;
	}

	@Override
	public List<UserServiceResponseDto> getAllFlight() {
		
		List<UserServiceResponseDto> list = new ArrayList<UserServiceResponseDto>();
		
		Iterable<FlightDetail> iterable = adminRepository.findAll();
		Iterator<FlightDetail> iterator = iterable.iterator();
		
		while(iterator.hasNext()) {
			FlightDetail flightDetail = iterator.next();
			
			UserServiceResponseDto responseDto = new UserServiceResponseDto();
			
			responseDto.setDate(flightDetail.getStartDate());
			responseDto.setFlightId(flightDetail.getFlightNo());
			responseDto.setFlightName(flightDetail.getAirline());
			responseDto.setFare(String.valueOf(flightDetail.getPrice()));
			list.add(responseDto);
		}
		
		return list;
	}
	
	

}
