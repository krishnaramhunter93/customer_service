package com.microservice.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.customerservice.dao.CustomerDao;
import com.microservice.customerservice.model.Customer;
import com.microservice.customerservice.request.CustomerRequest;



@Service // it does business logic
public class CustomerService {

	// from service the flow goes to CustomerDao
	
	@Autowired
	private CustomerDao customerDao;
	
	/* create - createCustomer 
	 * read / retrieve - findCustomerById, findAllCustomer
	 * update - updateCustomer
	 * delete - deleteCustomerById
	 */
	
	
	public Customer createCustomer(CustomerRequest customerRequest) {
		// take all the request fields from customerRequest using getters
		// and set it in customer model/entity class using setter
		// save that customer model object into database
		// return the save customer
		
		Customer customer = new Customer();
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setCustomerPassword(customerRequest.getCustomerPassword());
		customer.setEmail(customerRequest.getEmail());
		customer.setMobile(customerRequest.getMobile());
		customer.setAddress(customerRequest.getAddress());
		
		customer = customerDao.save(customer);
		
		if(customer == null) {
			throw new RuntimeException("Customer not saved!");
		}
		
		return customer;
		
	}
	
	
	public Optional<Customer> findCustomerById(Long customerId) {
		// take customerId as input and find that customer in the table if present else not found
		Optional<Customer> customer = customerDao.findById(customerId);
		if(!customer.isPresent()) {
			throw new RuntimeException("Customer with "+customerId+" id not found");
		}
		return customer;
		
	}
	
	public List<Customer> findAllCustomers() {
		
		//find all the customers in the database with findAll() method and that returns list of customers
		List<Customer> customerList = customerDao.findAll();
		if(customerList.isEmpty()) {
			throw new RuntimeException("No customers found");
		}
		return customerList;
	}
	
	public void deleteCustomerById(Long customerId) {
		// takes customerId as input and deleted it in the database table customer
		customerDao.deleteById(customerId);
	}
	
	public Customer updateCustomer(CustomerRequest customerRequest, Long customerId) {
		// 1. get old/saved customer values from database table using findByID and store it in customer object
		// 2. set customer object old data to customerrequest object new data
		// 3. save customer object to database
		
		
		//customerRequest contains new data that needs to be updated in database, coming from the front end
		//customer object contains old data from database
		//remove old data from customer object and update it with the new data of customerRequest
		Customer updatedCustomer = null;
		// step1
		Optional<Customer> customer = customerDao.findById(customerId);
		//step2
		customer.get().setCustomerName(customerRequest.getCustomerName());
		customer.get().setCustomerPassword(customerRequest.getCustomerPassword());
		customer.get().setEmail(customerRequest.getEmail());
		customer.get().setMobile(customerRequest.getMobile());
		customer.get().setAddress(customerRequest.getAddress());
		
		//step3
		updatedCustomer = customerDao.save(customer.get());
		if(updatedCustomer==null) {
			throw new RuntimeException("Customer not updated");
		}
		
		return updatedCustomer;
		
	}
	
	// calling customerdao's countcustomer method and returning the int result(total number of customer)
//	public int countCustomer() {
//		int countCust = customerDao.countCustomer();
//		if(countCust <= 0) {
//			throw new RuntimeException("zero customer found");
//		}
//		return countCust;
//	}
	
}
