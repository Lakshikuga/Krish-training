package com.lakshini.demoapplication.rentacar;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component  //in Spring, when you annotate something with a "Component", it creates a BEAN
//you can annotate with either a Service OR Repository annotations because both extend from Component.
@Endpoint(id = "stage")//The moment you use Component which creates a bean and along with the Endpoint, automatically this service will expose via an
//an web flux as jmx endpoints. Id here is the parts in the url, we use after actuator
public class StageEndpoint {

    //Map<key, value>
    Map<String,Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation //means HTTP GET CALL is mapped here
    public Map<String,Stage> getAllStages() {
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name) { //takes the Stage name and returns a Stage object. //the parameter is name, so using
        //Selector annotation. It tells i need to operate based on this value, the name.  http://localhost:8080/actuator/{name}
        return stages.get(name);
    }

    @WriteOperation //means HTTP POST CALL is mapped here
    public void setStage(@Selector String name, Stage stage) { //setting a stage so adding to the stages map
        //http://localhost:8080/actuator/{name}
        stages.put(name, stage);
    }


    static class Stage{

        int value;  //threshold value of each level of the service

        public Stage(int value){
            this.value = value;
        }

        //to get the threshold value or read the value
        public int getValue() {
            return value;
        }

        //to set the threshold value
        public void setValue(int value) {
            this.value = value;
        }

        /*but if you have a constructor taking the value argument, then why do we need a setter???
        * May be to set threshold value when the program is running and constructor sets the inital value!!!
        * */
    }
}
