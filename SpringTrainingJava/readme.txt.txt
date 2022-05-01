Here, getting error while running the application after adding @ComponentScan annotation to ApplicationConfiguration.java


The error is that @ComponentScan is not able to read the model class, the Employee.java class

Tried adding the class's path to the basePackages of the @ComponentScan annotation.
Tried adding the @Component annotation to the model class.

But these above didnt work!!!
