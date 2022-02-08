package com.flightapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flightdetail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="flight_no",unique=true)
	private int flightNo;
	
	@Column(name="airline_name")
	private String airline;
	
	@Column(name="src")
	private String srcLocation;
	
	@Column(name="dest")
	private String destLocation;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="blocked_flight",nullable =false)
	private boolean blockedFlight;
	
	@Convert(converter = StringListConverter.class)
	private List<String> scheduledDays;
	
	@Column(name="instrument")
	private String instrument;
	
	@Column(name="no_of_businessclass_seats")
	private int noOfBusinessClassSeats;
	
	@Column(name="no_of_non_businessclass_seats")
	private int noOfNonBusinessClassSeats;
	
	@Column(name="price")
	private int price;
	
}
