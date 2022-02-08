package com.flightapp.dto;

import java.util.List;

import com.flightapp.model.Passenger;
import com.flightapp.model.TypeOfMeal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightResponseDto {

	private String pnrNumber;
	private int flightId;
	private String name;
	private String email;
	private List<Passenger> passengers;
	private int noOfPassenger;
	private boolean meal;
	private TypeOfMeal typeOfMeal;
}
