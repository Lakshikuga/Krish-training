package com.lakshini.rentacar.demoapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value ="/hello", method = RequestMethod.GET)  //this maps the request into the Java method //setting the 
	//request method to GET, so that we won't get the result in POST as well.
	
	public String greeting() {
		return "Hello Springboot!!!";
		
		//This is a java method. We will call this from a service i.e. thru http, a URL.
		//Someone has to map the URL to this method. Therefore use annotation-@RequestMapping
	}
	
	//to support for POST request
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String greeting2() {
		return "Hello Springboot from POST!!!";
	}

	/*SAME URLs but DIFFERENT REQUEST METHODS, one is GET and other is POST*/
}
