package com.flightapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.flightapp.model.Passenger;

public interface PassangerRepository extends CrudRepository<Passenger, Integer> {

}
