package com.flightapp.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="passengers")
public class Passenger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private int age;
	
	@Column(name="Seat_No")
	private String seatNo;
	
	@Column(name="flight_id")
	private int flightId;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonIgnore
//	private FlightRegistration flightRegistration;
	
}
