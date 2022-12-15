package com.example.controller;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.serviceImpl.EmployeeServiceImpl;


import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
@ExtendWith(MockitoExtension.class)
public class EMPcontrollertest {
	
//	@InjectMocks
//	private EmployeeController employeeController;
//	private EmployeeController employeeController;
//	
//	@Mock
//	private EmployeeServiceImpl empServiceImpl;
	
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	
	@Test
	public void AddEmployee(){
		
		
		Employee employee= new Employee((long) 765,"Virat","Dhoni",43,9876);
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		System.out.println(employeeRepository);
		System.out.println(employeeService);
		
		Employee newEmp = employeeService.createEmployee(employee);
		System.out.println(newEmp);
		assertThat(newEmp).isNotNull();
	}
	@Test
	public void getEmployeeAll() {
		//Give
		List<Employee> empl = new ArrayList<Employee>();
		
		empl.add(new Employee(100, "India", "Pakisthan", 40, 60000));
		empl.add(new Employee(150, "Sita", "Geeta", 30, 70000));
		empl.add(new Employee(140, "Ram", "Shyam", 50, 50000));
		//When //then
		when(employeeService.getAllEmployee()).thenReturn(empl);
		//Assert test
		List<Employee> emplist = employeeService.getAllEmployee();//invoke
		assertThat(emplist).isNotNull();
//		assertEquals(2, emp2.size());
		//verify(employeeService, times(1)).getAllEmployee();//verify -no of times particular method are invoke
		assertThat(emplist.size()).isEqualTo(3);
		
	}	
	
//	@Test
//	public void updateEmployee() {
//		List<Employee> emp = new ArrayList<Employee>();
//
//		when(empServiceImpl.save(employee)).thenReturn(employee);
//		assertEquals(2, emp2.size());
//	}     


@Test
public void UpdateEmployee() {
	Employee employee =new Employee ((long) 876,"Ankit","Kumar",63,983);
	given(employeeRepository.save(employee)).willReturn(employee);
	employee.setAge(30);
	employee.setFirstName("Ashu");
	Employee updatedEmpl=employeeService.createEmployee(employee);
	assertThat(updatedEmpl.getAge()).isEqualTo(30);
	assertThat(updatedEmpl.getFirstName()).isEqualTo("Ashu");
}

@Test
public void DeleteEmployee() {
	long empid= 765;
	willDoNothing().given(employeeRepository).deleteById(empid);
	employeeService.deleteEmployee(empid);
	verify(employeeRepository,times(1)).deleteById(empid);
}
}
