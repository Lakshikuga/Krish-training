package com.lakshini.demoapplication.rentacar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting() {
        return "Hello Springboot!!!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String greeting2() {
        return "Hello Springboot from Post";
    }

}



/*
Controller
Service
Repository - deals with database, but we have to have a model.
 */
