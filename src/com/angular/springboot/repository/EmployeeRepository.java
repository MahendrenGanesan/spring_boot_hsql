package com.angular.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.angular.springboot.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

@Query("select e from Employee e where e.name = :employeename")
public Employee getEmployeeByName(@Param("employeename") String empName);
}
