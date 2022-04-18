package com.lakshini.rentacar.demoapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value ="/hello")  //this maps the request into the Java method
	public String greeting() {
		return "Hello Springboot!!!";
		
		//This is a java method. We will call this from a service i.e. thru http, a URL.
		//Someone has to map the URL to this method. Therefore use annotation-@RequestMapping
	}

}
