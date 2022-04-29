package com.lakshini.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakshini.training.salesmanager.repository.EmployeeRepository;
//import com.lakshini.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.lakshini.training.salesmanager.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	//EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	
	@Autowired //member variable injection
	EmployeeRepository employeeRepository;
	
	/*if it is setter injection, so there should be no-arg constructor, so @Autowired annotation should not be for the 
	member variable but to the setter method.
	*/
	
	public EmployeeServiceImpl() {
		//TODO Auto-generated constructor stub
		System.out.println("Default constructor executed!");
	}
	
	//@Autowired //Constructor injection
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overloaded consructor executed!");
		this.employeeRepository = employeeRepository;
	}
	
	//getters and setters for bean naming convention
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	//@Autowired //Setter injection
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter injection fired");
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
