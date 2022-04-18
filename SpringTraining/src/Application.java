import java.util.List;

import com.lakshini.training.salesmanager.model.Employee;
import com.lakshini.training.salesmanager.service.EmployeeService;
import com.lakshini.training.salesmanager.service.EmployeeServiceImpl;

public class Application {
	
	public static void main(String args[]) {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		//getting the ArrayList of all employees
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+ " at " + employee.getEmployeeLocation());
		}
	}

}
