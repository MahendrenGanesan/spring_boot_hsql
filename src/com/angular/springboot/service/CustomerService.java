package com.angular.springboot.service;


import java.util.List;

import com.angular.springboot.entity.Customer;



public interface CustomerService {

	public Customer save( Customer customer );
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerByEmail(String email);
}
