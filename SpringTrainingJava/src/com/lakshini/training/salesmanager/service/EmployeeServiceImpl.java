package com.lakshini.training.salesmanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.lakshini.training.salesmanager.repository.EmployeeRepository;
import com.lakshini.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.lakshini.training.salesmanager.model.Employee;


public class EmployeeServiceImpl implements EmployeeService {
	
	//@Autowired //change the service to auto wired
	EmployeeRepository employeeRepository;
	
	//adding constructors for constructor injection
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeServiceImpl() {
		//adding default constructor for support for setter injection
	}
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	@Autowired //moving @Autowired to setter.
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
