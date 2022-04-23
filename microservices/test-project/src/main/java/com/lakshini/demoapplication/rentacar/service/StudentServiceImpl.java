package com.lakshini.demoapplication.rentacar.service;

import com.lakshini.demoapplication.rentacar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //we need to create a bean for this, so we are putting the @Service annotation to this class/
/*
service deals with a repository. When dealing with hibernate, in the repository layer, we need to deal with a lot of code to make the
entity manager, create a session and save into db, but here we dont need to do any of this!!!

So, for this, we have to create a Student repository.
There r 3 ways to create a repository


We can create a Student repository and then we can extend that interface from the following interfaces :
1.REPOSITORY
2.CRUD REPOSITORY
3.JPA REPOSITORY
 */
public class StudentServiceImpl implements StudentService{

    /*
    In the service class, we need to use the repository right.
    We are not creating an instance for the interface, StudentRepository. Because dependency injection is all about loosely coupled
    so we dont need to have a concrete implementation such as below:
    StudentRepository studentRepository = new StudentServiceImpl(); //u cnt instantiate an interface right.

    So we are doing autowiring!!!
    What is autowiring???
     */

    @Autowired
    StudentRepository studentRepository;
    public Student save(Student student) {

        return studentRepository.save(student);
    }

    public Student fetchStudentById(int id) { //When putting the if condition, changing the return type from Optional<Student> to Student

        Optional<Student> student = studentRepository.findById(id);

        //if even any student record is present in the database, return that record.
        if(student.isPresent()) {
            return student.get();
        }
        else{
            return null; //it s prefereable to handle it in the service layer instead of controller, becoz controller routes traffic and this
            //part of business logic.
        }
        /*
        With 2.0 onwards they use optional instead of fetch. It is not the spring boot version but the spring data-jpa dependency version
        used like this. Using optional, introduced in Java 8, avoids null pointer exception, i.e prior to java 8, like in java 7, every
        time, we need to check for null values, e.g.check class is null or not etc...Therefore, with optional we dont need to check for null.
        Now, spring data jpa when finding a record, it returns optional.

        First StudentRepository was extending Repositiory, but there s no findById method inbuilt.
        So extending from JpaRepository interface.

        See, it returns an Optional of type Student from findById method, think of it as a Map datastructure.

         */
    }
}
