package com.lakshini.rentcloud.commons.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //annotating the Customer class as an Entity becoz this is the class we r going to deal with the database.
/*
this shows an error initially becoz there is no required dependency in the pom file. This is a class from the javax.persistence package.
 */
@Table(name = "customer") //giving the table name that will be created in the database (here we r using the approach of creating the databse and tables automatically in MySQL from java code)

public class Customer {

    //id would be the primary key so mark it as primary using the annotation @Id. Also we make it as an auto-increment number by annotating @GeneratedValue.

    @Id
    @GeneratedValue  //there are multiple strategies here but the default one is auto-increment, read abt this in the annotation docs.
    int id;

    String firstName;
    String lastName;
    String dlNumber;
    String zipcode;

    //Creating getters and setters for all these properties.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

/*
Creating another class Vehicle, classes Vehicle and Customer both supposed to be entities. These are the model classes. These classes are
supposed to be referred from the services class. Service class is supposed to do the database operations.

This means we need other 2 dependencies such as spring-data-jpa and mysql-connector. We can add those on the service class projects becoz they ar the ones dealing with the database.
But we dont need to go thru that burden, so we cn add these dependencies directly to this (model classes) project pom file.

This is the logic behind the above scenario :
so if u need to do any database operations, u need to use the rentcloud-commons project as a dependency in the service project. By adding the
other 2 dependencies (spring-data-jpa and mysql-connector dependencies) to this project, these 2 also will be dependencies for the service project, therefore these 2 are also called
transitive dependencies.
 */
