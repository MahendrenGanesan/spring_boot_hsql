package com.angular.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.angular.springboot.entity.Customer;

@Configuration
public class AppConfig {

	//prototype
	@Bean
	@Scope(scopeName="prototype")
	public Customer getCustomerByEmail(String email) {
	// public Customer getCustomerByEmail() {
		Customer c = new Customer(email);
		//ABC ob = new ABC(email);
		System.out.println("PROTOTYPE - Email: "+c.getEmail());
		return c;
	}
	
	@Bean
	@Scope(scopeName="prototype")
	public Customer getCustomerByEmail() {
	// public Customer getCustomerByEmail() {
		Customer c = new Customer("mmmmm");
		//ABC ob = new ABC(email);
		System.out.println("PROTOTYPE - Email: "+c.getEmail());
		return c;
	}
	
	@Bean
	//@Scope(scopeName="prototype")
	public Object obj() {
		this.getCustomerByEmail("abc@gmsil.com");
		return new Object();
	}
	
}
