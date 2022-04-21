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

        in the StudentRepository interface, if we comment out the save() method, when you go to StudentServiceImpl class, the save() method will fail.
        but if we extend the StudentRepository from the JpaRepository or CrudRepository, the save() method does not fail in the Impl class.

        This is because JpaRepository and CrudRepository both interfaces extend Repository interface. If the Repository interface
        has the save() method, then Jpa or CrudRepository will anyway have that method so you dont need to mention it inside the StudentRepository interface when it
        extends Jpa or CrudRepository.

        Repository is the top most one, when it comes to the Jpa or CrudRepository , save() method is already implemented.
        */

        /*
        when running the application, you may have an error as follows :
        Unknown column 'student0_.first_name' in 'field list' -> this is a mixup with a naming strategy

        in our code we have the firstName like this, in the db also same.

        This is because when it converts the data in the model class to the sql query (model to the query), it uses a different
        naming strategy, i.e. when there s a capital letter, it replaces that with an underscore. So,to correct this, we add a configuration
        for the naming strategy in the application.properties file. Here we are configuring the naming strategy so that it takes the name as it is in
        the model.
         */
    }
}



/*
Controller - ROUTE THE TRAFFIC
Service - CALL THE DATA
Repository - deals with database, but we have to have a model.
 */
