package com.lakshini.training.salesmanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.lakshini.training.salesmanager.repository.EmployeeRepository;
import com.lakshini.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.lakshini.training.salesmanager.model.Employee;


public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
