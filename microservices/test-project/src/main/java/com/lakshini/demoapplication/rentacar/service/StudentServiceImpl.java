package com.lakshini.demoapplication.rentacar.service;

import com.lakshini.demoapplication.rentacar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
