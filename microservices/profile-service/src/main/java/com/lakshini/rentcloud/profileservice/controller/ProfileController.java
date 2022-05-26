package com.lakshini.rentcloud.profileservice.controller;

import com.lakshini.rentcloud.commons.model.Customer;
import com.lakshini.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/services") //this is a basic requestmapping, i.e. after the basic URL, u have this requestmapping path, then we ll have a method level requestmapping path.
public class ProfileController {

    /*
    We need to access the model object which is Customer from the rentcloud-commons-model project, first there ll be a compile error, since we
    have not added the dependency to the pom file. Therefore we can add the rentcloud-commons-model project as a maven dependency to this project.Now
    the profileService project depends on the rentcloud-commons-model project.
     */

    @Autowired
    CustomerService customerService;  //here we will get a compile error under 'customerService' ref variable, saying that "could not autowire, No beans of 'CustomerService' type found".
    //this is because we forgot to add @Service annotation to the CustomerServiceImpl class. Without a @Service annotation, spring wont create a bean. Either we have to create the bean manually or use @Component annotation or @Service annotation or @Repository annotation, then only we can create a bean.

    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

}
