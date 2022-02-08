package com.flightapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	private String pnrNumber;
	private int flightId;
	private String name;
	private String email;
	private List<Passenger> passengers;
	private int noOfPassenger;
	private boolean meal;
	private TypeOfMeal typeOfMeal;
	
	@Override
	public String toString() {
		return "User [pnrNumber=" + pnrNumber + ", flightId=" + flightId + ", name=" + name + ", email=" + email
				+ ", passengers=" + passengers + ", noOfPassenger=" + noOfPassenger + ", meal=" + meal + ", typeOfMeal="
				+ typeOfMeal + "]";
	}
	
	
}
