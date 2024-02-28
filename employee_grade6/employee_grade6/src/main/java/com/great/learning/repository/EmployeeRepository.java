package com.great.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.great.learning.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);

	List<Employee> findAllByOrderByFirstNameAsc();

	List<Employee> findAllByOrderByFirstNameDesc();

}
