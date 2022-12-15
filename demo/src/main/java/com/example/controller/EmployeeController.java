package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees/")
	public Employee createEmployeee(@RequestBody Employee employee) {
		Employee emp=this.employeeService.createEmployee(employee);
		return emp;
	} 
	
	@GetMapping("/employees/")
	public List<Employee> getAll(){
		
	System.out.println ("Inside controller method-get All" );
	
		return employeeService.getAllEmployee();
	}

	@PutMapping("/employees/{empId}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long empId) {
		this.employeeService.updateEmployee(employee, empId);
		return employee;
	}

	@DeleteMapping("/employees/{empId}")
	public void deleteEmployee(@PathVariable Long empId ) {
		employeeService.deleteEmployee(empId);
	}
}

