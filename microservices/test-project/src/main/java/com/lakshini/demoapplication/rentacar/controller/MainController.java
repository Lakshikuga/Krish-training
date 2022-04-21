package com.lakshini.demoapplication.rentacar.controller;

import com.lakshini.demoapplication.rentacar.model.Student;
import com.lakshini.demoapplication.rentacar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    /*
    the student we need to save comes from the UI or the server request we are going to do. Server request may comes as a json.
    so i have to tell, whatever comes in the request body, convert to Student object.

    there are multiple ways u cn pass the parameters:
    1. request body
    2. in the url path

    We normally have endpoints such as create, add, update, save. This is wrong!!! You dont need to do that!!!
    What we need to do is: we have the /student as the endpoint (we need to deal with Student). But we can change the request method.
    if you want to create a student record or save the student, send a POST REQUEST
    Update a student, send a PUT REQUEST
    Fetch student record, send a GET REQUEST, you have to use the REST verbs instead of using the verbs in the URL.
     */

    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);

        /*
        Recap :
        we have a controller where we have a student endpoint and you pass a student object.
        the student object goes to service.

        in the service, i.e. the StudentServiceImpl class, we have annotated the class as Service, therfore spring
        know it is a service and it will create the bean. From here the StudentRepository takes over.

        in the StudentRepository interface, if we comment out the save() method, the save() method will fail.

         */
    }
}



/*
Controller - ROUTE THE TRAFFIC
Service - CALL THE DATA
Repository - deals with database, but we have to have a model.
 */
