package com.lakshini.training.salesmanager.repository;

import java.util.List;

import com.lakshini.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}