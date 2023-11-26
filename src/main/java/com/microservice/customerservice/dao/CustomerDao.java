package com.microservice.customerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.customerservice.model.Customer;


@Repository // it does database operations
// JpaRepository has in built methods for database operations, we are
//inheriting it and using in our application
public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	// writing an query for counting total number of customer present in the table
	// @Query - annotation used to write user defines queries
	// nativeQuery = true - we have our own query to run
	// value - it is the query statement and it returns output
//	@Query(nativeQuery = true,value = "select count(*) from customer")
//	public int countCustomer();
	
	@Query(nativeQuery = true,value="select * from customer where email = :email")
	public Customer getCustomerByEmail(@Param("email") String email);
}
