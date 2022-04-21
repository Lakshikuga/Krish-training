package com.lakshini.demoapplication.rentacar.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //if you want you can specify the table name. When the table name and the class name is identical you
//dont need to specify the table name explicitly. Here we dnt need to specify the table name but we will.

@Table(name = "student") //specifying the table name as student as created in mysql
public class Student {

    private int id;
    private String firstName;
    private String lastName;


    @Id
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

    public void setId(Integer id) {
        this.id = id;
    }
}



/*
these 3 variables's value come from the user/client as a json payload. But here we deal with java objects.
So the serialization or conversion from json object to java object happens automatically by the spring Jackson libraries. But for this we need to expose getters and setters.
*/

/*
we need to tell our project that we are dealing with database
first we dealt with JDBC (need to deal with prepared statements -> Persistent framework/ORM/Hibernate, here also we need to create entity managers and all -> next generation
we dont need to create all these entity managers.
 */

/*
spring data-jpa - can do certain things such as creating entity managers
if we are dng some advanced stuff like insertign multiple records in the same transaction, then you need to
handle the transaction. In this case we have three things in handling the transaction i.e.
1. begin the transaction
2. commit transaction if everything is ok
3. rollback transaction if something goes wrong
So using the data-jpa we might not need to do this, just you need to use the trabsaction annotation (@Transaction)
other advanced stuff include: if we want to use the same session, we can use a propagation stategy with the Transaction annotation.
 */

/*
NOW WE NEED TO TELL WHAT IS OUR DATABASE, USERNAME AND PASSWORD, specify them in the application.properties file.
database url
username
password
schema name

mysql-connector-java dependency in pom get automatically imported!!!

after the configurations, the service knows
1. schema name
2. username
3.password
4.the driver to connect, i.e. mysql-jdbc-driver

after this, we need to create an endpoint in the controller
 */
