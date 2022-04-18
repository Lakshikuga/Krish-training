package com.lakshini.training.salesmanager.service;

import java.util.List;

import com.lakshini.training.salesmanager.model.Employee;
import com.lakshini.training.salesmanager.repository.EmployeeRepository;
import com.lakshini.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	
	//should be an implemented method in this class as it was in its interface
	
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.getAllEmployees();
		
	}

}
