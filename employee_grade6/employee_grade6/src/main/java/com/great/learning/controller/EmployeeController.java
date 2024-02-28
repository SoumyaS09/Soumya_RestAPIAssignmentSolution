package com.great.learning.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.great.learning.model.Employee;
import com.great.learning.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

//	@PostMapping("/customInfo")
//	public Employee customInfo(String firstName, String lastName, String email) {
//		return employeeService.customInfo(firstName,lastName,email );
//	}

	// build create Employee REST API

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

	}

	// build getAll Employee REST API
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	// build get Employee byId REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);

	}

	// build update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);

	}

	// build delete Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted employee id - " + id, HttpStatus.OK);

	}
	
	@GetMapping("/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName)
	{
		return employeeService.searchByFirstName(firstName);
	}
	
	@GetMapping("/sort")
	public List<Employee> sortByFirstName(@RequestParam(name = "order") String order){
		
		return employeeService.sortByFirstName(order);
	}
	
}
