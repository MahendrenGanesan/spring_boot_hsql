package com.angular.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.angular.springboot.entity.Customer;
import com.angular.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
	
	public Customer save( Customer customer ) {
		customer = customerRepository.save(customer);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	
	public Customer getCustomerByEmail(String email) {
		Customer c = customerRepository.findByEmail(email);
		//ABC ob = new ABC(email);
		
		return c;
	}
	
	
}
