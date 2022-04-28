import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lakshini.training.salesmanager.model.Employee;
import com.lakshini.training.salesmanager.service.EmployeeService;
import com.lakshini.training.salesmanager.service.EmployeeServiceImpl;

public class Application {
	
	public static void main(String args[]) {
		
		//using spring over classic execution
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//EmployeeService employeeService = new EmployeeServiceImpl();
		
		//without concrete reference, without the new keyword
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
		
		//getting the ArrayList of all employees
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+ " at " + employee.getEmployeeLocation());
		}
	}

}
