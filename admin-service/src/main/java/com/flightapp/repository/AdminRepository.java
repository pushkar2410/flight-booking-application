package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flightapp.model.FlightDetail;

@Repository
public interface AdminRepository extends CrudRepository<FlightDetail, Long> {

	@Query(nativeQuery = true, value = "update flightdetail f set f.blocked_flight =true where f.airline_name=?1")
	@Modifying
	@Transactional
	public void setFlightDetailsByAirline(String airline);
	
	@Query(nativeQuery=true,value="select "
			+ "* from flightdetail f where "
			+ "  f.src =?1 and f.dest=?2")
	public List<FlightDetail> getFlightDetails( String srcLocation,String destLocation );
}
