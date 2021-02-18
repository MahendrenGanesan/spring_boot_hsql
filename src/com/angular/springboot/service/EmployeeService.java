package com.angular.springboot.service;

import com.angular.springboot.entity.Employee;

public interface EmployeeService {
	public boolean SaveEmployee(Employee emp);
	public Employee getByID(Integer id);
	public Employee getEmployeeByName(String name);
}
