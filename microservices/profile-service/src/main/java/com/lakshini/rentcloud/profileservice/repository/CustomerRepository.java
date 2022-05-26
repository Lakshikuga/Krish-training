package com.lakshini.rentcloud.profileservice.repository;

import com.lakshini.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> { //the datatype dealing with is Customer
    //and the primary key datatype is Integer



}
