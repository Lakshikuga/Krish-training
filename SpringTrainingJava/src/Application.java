import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lakshini.training.salesmanager.model.Employee;
import com.lakshini.training.salesmanager.service.EmployeeService;

public class Application {
	
	public static void main(String args[]) {
		
		//EmployeeService employeeService = new EmployeeServiceImpl();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee:employees) {
			
			System.out.println(employee.getEmployeeName() + " at " + employee.getEmployeeLocation());
			
		}
		
		
		
	}

}
