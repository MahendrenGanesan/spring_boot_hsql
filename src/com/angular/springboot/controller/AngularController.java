package com.angular.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angular.springboot.entity.Customer;
import com.angular.springboot.entity.Employee;
import com.angular.springboot.service.CustomerService;
import com.angular.springboot.service.EmployeeService;

@RestController
@RequestMapping("/angular")
//@Scope(scopeName="prototype")
public class AngularController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	EmployeeService employeeService;
	
	

	@RequestMapping(value="/getTest", method=RequestMethod.GET)
	public String getTest() {
		return "Angular GET Test" ;
	}
	
	@Lookup
	public  Customer getCustomer(@Autowired Customer customer) {
		System.out.println("Object - "+" customer Email-"+customer.getEmail());
		return customer;
	}
	
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		System.out.println("Customer Name - "+customer.getName());
		return customerService.save(customer);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	//
	public List<Customer> getAllCustomers() {
		
		return customerService.getAllCustomers();
	}
	
	
	
	@RequestMapping(value="/getCustByEmail", method=RequestMethod.GET)
	public Customer getCustomerByEmail(@RequestParam("email") String email) {
		System.out.println("Email :::::::::::::"+email);
		return customerService.getCustomerByEmail(email);
	}
	@RequestMapping(value="/getEmployeeById",method=RequestMethod.GET)
	public Employee getEmployee(@RequestParam("ID") Integer id)
	{
		return employeeService.getByID(id); 
	}
	@RequestMapping(value="/getEmployeeName",method=RequestMethod.GET)
	public Employee getEmployeeName(@RequestParam("Name") String name)
	{
		return employeeService.getEmployeeByName(name); 
	}
	@RequestMapping(value = "/SaveEmployee",method = RequestMethod.POST)
	public boolean SaveEmployee(@RequestBody Employee employee)
	{
		employee.setId(null);
		return employeeService.SaveEmployee(employee);
	}
}
