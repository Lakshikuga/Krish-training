package com.lakshini.demoapplication.rentacar.service;

import com.lakshini.demoapplication.rentacar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<Student, Integer> { //also need to tell what is the datatype this will deal with and the
    //primary key datatype (e.g. Id datatype)

    Student save(Student student);

}
