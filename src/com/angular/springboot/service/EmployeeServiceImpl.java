package com.angular.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.angular.springboot.entity.Employee;
import com.angular.springboot.repository.EmployeeRepository;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public boolean SaveEmployee(Employee emp) {
		 
		try
		{
		employeeRepository.save(emp);
		return true;
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Employee getByID(Integer id) {
		return employeeRepository.findById((long)id).get();
	 
	}

	@Override
	public Employee getEmployeeByName(String name) {
		return employeeRepository.getEmployeeByName(name);
	}
	 
}
