package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
