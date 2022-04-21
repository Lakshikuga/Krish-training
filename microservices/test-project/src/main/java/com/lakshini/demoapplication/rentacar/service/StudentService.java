package com.lakshini.demoapplication.rentacar.service;

import com.lakshini.demoapplication.rentacar.model.Student;

/*
always gud to go with interface driven programming. Code to an interface but not to the implementation (from head first java)
 */
public interface StudentService {

    Student save(Student student);
}
/*
the next will be coding the class implementing the interface.
 */