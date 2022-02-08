package com.flightapp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseFlightDto {
	private Date startDate;
	private Date endDate;
	private String airline;
	private int price;
	private boolean roundTrip;
	private boolean oneWayTrip;
}
