package com.example.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		employee=employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		System.out.println ("Getting data from DB" );
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee,Long empId) {
		employee.setEmpId(empId);
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
		
	}

}
