package com.flightapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.FlightRegistration;
import com.google.common.base.Optional;

@Repository
public interface UserRepository extends CrudRepository<FlightRegistration, Integer> {

	@Query(nativeQuery = true, value = "select * from flight_registration where pnr_no=?1")
	public Optional<FlightRegistration> findByPnrNumber(String pnrNumber);
	
//	@Modifying
//	@Query(nativeQuery = true, value = "delete from flight_registration where pnr_no=?1")
//	public void deleteByPnrNumber(String pnr_no);

	@Modifying
	@Query
	@Transactional
	public void deleteByPnrNumber(String pnr_no);
	
	@Query
	public List<FlightRegistration> findAllByEmail(String email);
}
