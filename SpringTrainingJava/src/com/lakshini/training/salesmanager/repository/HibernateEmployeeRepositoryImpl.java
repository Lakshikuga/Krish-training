package com.lakshini.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;
import com.lakshini.training.salesmanager.model.Employee;


public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee = new Employee();
		employee.setEmployeeName("Lakshi");
		employee.setEmployeeLocation("Dehiwela");
		
		employees.add(employee); //adding to array list.
		
		return employees;
	}

}
