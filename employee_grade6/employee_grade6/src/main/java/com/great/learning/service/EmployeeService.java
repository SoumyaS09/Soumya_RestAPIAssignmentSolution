package com.great.learning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.great.learning.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);

	public List<Employee> searchByFirstName(String firstName);

	public List<Employee> sortByFirstName(String order);

}
