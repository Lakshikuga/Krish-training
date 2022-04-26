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
 */