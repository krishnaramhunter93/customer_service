package com.microservice.customerservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customerservice.model.Customer;
import com.microservice.customerservice.request.CustomerRequest;


@RestController
public class CustomerController {

	@GetMapping(value="/find/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(123L);
		customer.setCustomerName("Pravesh");
		customer.setCustomerPassword("test123");
		customer.setEmail("pravesh@gmail.com");
		customer.setMobile("+2345786990");
		customer.setAddress("Door no 123, ABC road, XYZ city");
		
		if(customerId == customer.getCustomerId()) {
			return customer;
		}else {
			return null;
		}
	}
	
	@DeleteMapping(value="/delete/{customerId}")
	public String deleteCustomerById(@PathVariable("customerId") Long customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(123L);
		customer.setCustomerName("Pravesh");
		customer.setCustomerPassword("test123");
		customer.setEmail("pravesh@gmail.com");
		customer.setMobile("+2345786990");
		customer.setAddress("Door no 123, ABC road, XYZ city");
		
		if(customerId == customer.getCustomerId()) {
			return "Customer with id "+customerId+" got deleted"; 
		}else {
			return "Customer did not found"; 
		}
		
	}
	
	@PutMapping(value="/update/{customerId}")
	public Customer updateCustomerById(@PathVariable("customerId") Long customerId,@RequestBody CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setCustomerId(123L);
		customer.setCustomerName("Pravesh");
		customer.setCustomerPassword("test123");
		customer.setEmail("pravesh@gmail.com");
		customer.setMobile("+2345786990");
		customer.setAddress("Door no 123, ABC road, XYZ city");
		
		if(customerId == customer.getCustomerId()) {
			customer.setCustomerName(customerRequest.getCustomerName());
			customer.setCustomerPassword(customerRequest.getCustomerPassword());
			customer.setEmail(customerRequest.getEmail());
			customer.setMobile(customerRequest.getMobile());
			customer.setAddress(customerRequest.getAddress());
			return customer;
		}else {
			return null;
		}
		
	}
}
