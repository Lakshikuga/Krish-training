package com.lakshini.demoapplication.rentacar.controller;

import com.lakshini.demoapplication.rentacar.model.Student;
import com.lakshini.demoapplication.rentacar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        /*video 4
        first changing the database to sample_db2, and you ll get this error : Unknown database 'sample_db2', becoz there s no sample_db2 yet!!!
        so add the createDatabaseIfNotExist=true to the URL in the application.properties file.
        Then add the jpa-ddl-auto=create property to application.properties file to create the table under sample_db2 database
        with the columns for the properties in the model class. THEREFORE THIS CREATES TABLES AUTOMATICALLY.

        STOP THE SERVICE AND REFRESH DATABASE IN MYSQL, AND THE TABLES WILL BE STILL THERE. IF YOU TERMINATE THE SERVICE STILL THE TABLES
        REMAIN IN MYSQL.

        change create to create-drop -> when the service terminates it will also drop the table from the database.
        IT WILL CREATE THE TABLES IN THE DATABASE WHEN SERVICE STARTS AND DROPS THE TABLES WHEN SERVICE TERMINATES.

        THIS IS THE FEATURE WHERE EVERYTIME U START THE SERVICE YOU HAVE A FRESH SET OF TABLES, IF U WANT TO PRESERVE THE DATA, YOU HAVE TO
        GO WITH THE CREATE MODE.

        IN CREATE MODE, IT WILL CREATE ONLY IF TABLES DO NOT EXIST IN THE DATABASE. THE PROBLEM HERE IS, EVENTHOUGH TABLES REMAIN IN DATABASE,
        EVERYTIME YOU START THE SERVICE, IT WILL RECREATE THE TABLES, LOSING ALL THE DATA PREVIOUSLY STORED.

        THE DIFFERENCE BETWEEN CREATE AND CREATE-DROP is that in CREATE MODE, THE TABLE WILL REMAIN, BUT DATA WILL BE LOST ON RESTARTING THE SERVICE.
        BUT IN CREATE-DROP MODE, THE TABLE WILL DROP ON TERMINATING THE SERVICE.

        UPDATE MODE - IT WILL CREATE THE TABLE IF IT DOES NOT EXIST AND IF U ADD SOMETHING TO THE MODEL CLASS, IT WILL ADD THOSE COLUMNS TO
        THE TABLE BUT WITH RESTRICTIONS. AND ALSO IF U SHUTDOWN AND RESTART THE SERVICE, THE DATA/RECORDS ALSO WILL REMAIN UNLIKE IN CREATE MODE.
         */
        }
          /*
        Finding a record - > code in StudentServiceImpl class.
         */

    //mapping fetch data in controller class
    @RequestMapping(value = "/student", method = RequestMethod.GET) //always go with the entity name or in this case Student (the model class) and the REST verb needs to vary.
    public ResponseEntity<Student> fetchStudent(@RequestParam int id) { //sending the request parameter as id of student. This id is passed in the GET request.
        Student student = studentService.fetchStudentById(id);

            if(student == null) {
                return ResponseEntity.notFound().build();  //if no student record in database.
            }
            else{
                return ResponseEntity.ok().body(student); //returns Student type object in the response body.
            }


            /*
            Rather than returning a Student object as a response, we are using a ResponseEntityof type Student returning a response.
            Becoz there may be student records or there wont be student record.
            If there is not a single student record, the right practice is to have a "not found" response. In this case we can return a
            response code based on if a student record is found or not.

            In insomnia, we first insert the records using the save() method and the POST REQUEST
            Then, get each record by passing the id as parameter, url as follows: http://localhost:8080/student?id=1 as GET REQUEST.

            When the record with a specific Id is not found in the database the fetch() method will return 404 NOT FOUND response in insomnia
            or else it will return a json response of the id, firstName and lastName (all the details).
            */

        /* VIDEO 4
        insert record
        update record
        use features to generate these database and tables automatically, i.e. by not creating THE DATABASE OR THE TABLES AND THEIR COLUMNS MANUALLY IN MYSQL.
        */

    }
}



/*
Controller - ROUTE THE TRAFFIC
Service - CALL THE DATA
Repository - deals with database, but we have to have a model.
 */
