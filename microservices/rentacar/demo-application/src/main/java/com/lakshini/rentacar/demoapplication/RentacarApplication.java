package com.lakshini.rentacar.demoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentacarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
	}

}




/*
basic structure of Spring application

	1. Controller - responsible to handle traffic for the required service. This is the last layer in the spring environment
	and should handle the exception. Exception best practice is throw early catch late
	2. Service - holds business logic, maintain states, i.e. create new login sessions etc..
	3. Repository - Deals with databases, dtatbase queries, CRUD operations
	
*/