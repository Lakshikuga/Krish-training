import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.lakshini.training.salesmanager.repository.EmployeeRepository;
import com.lakshini.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.lakshini.training.salesmanager.service.EmployeeService;
import com.lakshini.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.lakshini") //it can handle byName and byType both, byName refer @Bean name and byType refer instance type.
//@PropertySource("application.properties") //loading property file with java.
public class ApplicationConfiguration {

	@Bean(name = "employeeService")
	//@Scope("singleton") //if the bean scope is Singleton, this is one instance per Spring container and not for JVM.
	//@Scope("prototype") //opposite fo singleton, we get one instance per request, supports for both java and xml configurations. we ll get a new instance for each new request/for each run of the application.
	public EmployeeService getEmployeeService() {
		//return new EmployeeServiceImpl();
		
		//changing the wiring with setters
		/*
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.setEmployeeRepository(getEmployeeRepository());
		
		return employeeService;
		*/
		
		//Constructor injection
		/*
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl(getEmployeeRepository());
		return employeeService;
		*/
		
		//after adding @ComponentScan annotation, you can have the default constructor
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		return employeeService;
		
	}
	
	//this is under setter injection in a different way
	//we ll have to comment this bean if we are to use @Repository in the HibernateEmployeeRepositoryImpl class.
	
	@Bean(name = "employeeRepository")
	public EmployeeRepository getEmployeeRepository() {
		return new HibernateEmployeeRepositoryImpl();
	}
	
	//loading property file 
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
