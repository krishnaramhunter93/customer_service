package com.microservice.customerservice.request;

import lombok.Data;

@Data
public class CustomerRequest {
	// In request class we have the fields that will come as part of request
	private String customerName;
	private String customerPassword;
	private String email;
	private String mobile;
	private String address;

}
