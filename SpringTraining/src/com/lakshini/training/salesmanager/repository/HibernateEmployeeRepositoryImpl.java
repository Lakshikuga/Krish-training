package com.lakshini.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import com.lakshini.training.salesmanager.model.Employee;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	
	//implement a method to return all employees as ArrayList
	
	@Override
	public List<Employee> getAllEmployees() {
		
		//create the list
		
		List<Employee> employees = new ArrayList<Employee>();
		
		//invoke object of Employee, i.e. Employee object is created
		Employee employee = new Employee();
		employee.setEmployeeLocation("Dehiwela");
		employee.setEmployeeName("Lakshini");
		
		employee.setEmployeeName("Amma");
		employee.setEmployeeLocation("Dehiwela");
		
		//adding employee to the ArrayList
		employees.add(employee);
		
		return employees;
	}

}
