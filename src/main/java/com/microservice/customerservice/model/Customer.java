package com.microservice.customerservice.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates getter and setters
@Entity//refers that this is an entity class
@Table(name="customer")// creates table customer in database oms
@AllArgsConstructor // all fields constructor
@NoArgsConstructor // no field constructor
public class Customer {
	
	@Id // refers to primary key of the table
	@Column(name="customer_id", nullable=false)// column corresponds to table column and it cannot be null
	@GeneratedValue(strategy = GenerationType.AUTO)// automatically generates id value
	private Long customerId;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="customer_password", nullable=false)
	private String customerPassword;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="mobile", nullable=false)
	private String mobile;
	
	@Column(name="address", nullable=false)
	private String address;

}
