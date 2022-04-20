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
//an web flux or as jmx endpoints. Id here is the parts in the url, we use after actuator.
public class StageEndpoint {

    //Map<key, value>
    Map<String, Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation //means HTTP GET CALL is mapped here
    public Map<String, Stage> getAllStages() { //when running the GET call, it automatically maps with this method.
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name) { //takes the Stage name and returns a Stage object. //the parameter is name, so using
        //Selector annotation. It tells I need to operate based on this value, the name.  http://localhost:8080/actuator/{name}
        return stages.get(name);
    }

    //this method is no longer used like this. Look below!!!
    /*
    @WriteOperation //means HTTP POST CALL is mapped here
    public void setStage(@Selector String name, Stage stage) { //setting a stage so adding to the stages map
        //http://localhost:8080/actuator/{name} - > in the GET operation URL we need to give the name, which is the key in the map.
        stages.put(name, stage);
        /*
        in insomnia rest client
        first like this:
        {
            "name": "st001",
            "stage":100   //when u assign 100 here it will give a parameter passing failure error here, becoz we are passing an object
            as a parameter but in the json object, we are giving an int as the value for the key "stage"
        }
        then like this, becoz, in the method, we r passing a Stage object and not an int value
        {
            "name": "st001",
            "stage":{"value":100} //so here we are trying to pass a Stage object
            we ll also get a JSON parse error: Cannot deserialize instance of 'java.lang.String' out of START_OBJECT token.
            What this means is the GET call expects a String but we gave an object, then it is figuring out to get a String from this object. So it snot possible therefore the error!!!
        }
        */

    /* it worked with the String but there s an error when using int, everthing cannot be convertd to a String right!!!
    there s an error becoz the endpoint cannot identify this complex datatype. to preserve int behaviour. we do th following
     */
    @WriteOperation
    public void setStage(@Selector String name, int stage) {
        stages.put(name, new Stage(stage));
    }
    /*
    it returns a value as an int
    {
	   "value": 200
    }
    also trying out http://localhost:8080/actuator/stage/ without giving the selector, IT LL SAY ,POST NOT SUPPORTED, becoz, there s no POST signature without a selector here, so
    u ll have to pass the Selector. Selector always goes in the URL path!!!
     */


    static class Stage {

        int value;  //threshold value of each level of the service

        public Stage(int value) {
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

        /* to check the JSON parse error */
        /*String value;

        public Stage(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        /*
        {
	       "name": "st001",
	       "stage":"100" //passing the 100 as a String. The result is it returns the value as 100 in a json format
        }

        result

        {
	       "value": "100"
        }
         */
    }
}

