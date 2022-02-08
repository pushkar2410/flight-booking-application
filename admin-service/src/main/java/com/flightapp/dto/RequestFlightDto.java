package com.flightapp.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestFlightDto {
	
	private int flightNo;
	private String airline;
	private String srcLocation;
	private String destLocation;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date startDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date endDate;
	
	private List<String> scheduledDays;
	private String instrument;
	private int noOfBusinessClassSeats;
	private int noOfNonBusinessClassSeats;
	private int price;
}
