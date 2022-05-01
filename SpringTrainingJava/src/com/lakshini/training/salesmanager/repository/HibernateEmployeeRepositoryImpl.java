package com.lakshini.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.lakshini.training.salesmanager.model.Employee;

@Repository("you-can-use-anyname") //setter injection in a different way, for this we have to remove the employeeRepository bean
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	

	//Reading values from application.properties
	@Value("${name}")
	private String employeeName;
	@Value("${city}")
	private String employeeLocation;
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee = new Employee();
		
		employee.setEmployeeName(employeeName);
		employee.setEmployeeLocation(employeeLocation);
		
		/*
		employee.setEmployeeName("Lakshi");
		employee.setEmployeeLocation("Dehiwela");
		*/
		
		
		employees.add(employee); //adding to array list.
		
		return employees;
	}

}
