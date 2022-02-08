package com.flightapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "flight_registration")
public class FlightRegistration implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;

	@Column(name = "pnr_no", unique = true)
	private String pnrNumber;
	
	@Column(name = "flight_id")
	private int flightId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	
	@OneToMany(targetEntity = Passenger.class,cascade = CascadeType.ALL)
	private List<Passenger> passengers;

	@Column(name = "total_passengers")
	private int noOfPassenger;

	@Column(name = "meal")
	private boolean meal;

	@Enumerated(EnumType.STRING)
	private TypeOfMeal typeOfMeal;


	
}
