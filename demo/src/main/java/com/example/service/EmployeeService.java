package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee updateEmployee(Employee employee,Long empId);
	
	public void deleteEmployee(Long empId);
}
