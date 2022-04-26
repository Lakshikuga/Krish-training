package com.lakshini.configconsumer.configconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component   //which means when we put the Component annotation, it creates a bean.
public class MemberProfileConfiguration {

    @Autowired
    Environment environment; //make sure to use the springframework.core.env

    public String getDefaultModel() {
        return environment.getProperty("vehicle.default.model");
        /*this value within the brackets is from the response u get when running this
        url in insomnia :
        http://localhost:8191/membership/default

        response is as follows:

        {
	"name": "membership",
	"profiles": [
		"default"
	],
	"label": null,
	"version": "96b7f007179dcb62e783c7cd924340991ed88bd4",
	"state": null,
	"propertySources": [
		{
			"name": "https://github.com/Lakshikuga/spring-cloud-config-store/file:C:\\Users\\LAKSHI~1\\AppData\\Local\\Temp\\config-repo-1490801305909564003\\mem-service\\membership.yml",
			"source": {
				"member.rent.min": 7,
				"member.rent.max": 30,
				"member.price.discount": 3,
				"vehicle.default.model": "cross over",
				"duration": "all"
			}
		}
	]
}

         */
    }

    public String getMinRentPeriod() {
        return environment.getProperty("member.rent.min");
    }
}

/*
When service name is specified and called the rest endpoint : http://localhost:8080/profile
we get the response as follows :
{
	"defaultModel": "cross over"
}
but we only get this property, to get both the properties, we have mentioned 2 properties in the MemberProfileConfiguration class.

the method returns the String but when serialising into json, it always uses the bean naming convention. Bean naming convention means u need ti have getters and setters.
so making minRentPeriod() to getMinRentPeriod()

when u run this url :http://localhost:8080/profile
we get the following response :
{
	"minRentPeriod": "7",
	"defaultModel": "cross over"
}

this says we get both the properties in the MemberProfileConfiguration class.

if u want, u cn fetch this json response to a UI, i.e. displaying the model and the min-rent-period in the browser.
For that u need to make the profileController class a Controller instead of RestController, because we r not using the restendpoint anymore to
get a response.

Then pass a Model class of the org.springframework.ui package as a parameter to the getConfig method of the profileController class.
We return a String instead of a class. Since it is returning to the UI, WE NEED TO CREATE A WEBPAGE.

Under templates, create a new file, name it "mprofile". You have to match the same name as the string u return in profileController class. Here we use "mprofile"
rather than "profile" becoz to avoid confusions with the RequestMapping (the URL).

in the html page, inside <p> tags get the values of the properties based on the model name given in the profileController class.
then add thymeleaf dependency to pom file, reload the project to load the added dependency.

run the config-consumer, before running this, make sure config-server is already running at port 8191.
in the browser, type the url with the endpoint : http://localhost:8080/profile

u ll get the values of the properties printed in the browser.

The point here is, u cn even get the configurations not only as a REST service, anywhwere within the service, we cn access these configurations.
 */