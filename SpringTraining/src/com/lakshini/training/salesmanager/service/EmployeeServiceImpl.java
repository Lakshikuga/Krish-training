package com.lakshini.training.salesmanager.service;

import java.util.List;

import com.lakshini.training.salesmanager.model.Employee;
import com.lakshini.training.salesmanager.repository.EmployeeRepository;
import com.lakshini.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	//EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	//private EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	//the above new keyword makes a bond to concrete reference.
	
	//since we dont need to have hardcode concrete references, remove that part and code should look like follows:
	
	private EmployeeRepository employeeRepository;
	
	//creating a constructor method on service class to understand Constructor injection (Dependency injection)
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
		
	
	//now we generate or write setter method for above property
	//this is also known as setter injection
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	//should be an implemented method in this class as it was in its interface
	
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.getAllEmployees();
		
	}

}
