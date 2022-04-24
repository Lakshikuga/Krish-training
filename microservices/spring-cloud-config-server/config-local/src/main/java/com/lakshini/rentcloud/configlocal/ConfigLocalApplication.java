package com.lakshini.rentcloud.configlocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //adding this enables to run configurations. Using this we are creating a configuration server.
public class ConfigLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigLocalApplication.class, args);
    }

}



/*
We nned to store the configurations.
This is the concept : this is a configuration server. Purpose is to give the configuration data through http.That is this server's
responsibility.
Whether is local (local file system or remote (git) is just a store, where u store the configurations.
Video 5 - How to store the configurations locally.

But the moment u want to host it, the configuration service will remain the same but the configuration store will be in github.

in spring boot there are few places where it looks for configurations files when the application is started.U CAN CHANGE AND OVERRIDE, GIVING THE PATH TO
LOOK FOR THE CONFIGURATIONS!!!

But by default it looks inside following for any configurations.

1. any changes in the classpath
2. in the resources directory
3. in the resources/config directory
4.in the current directory
5. in the current directory/config

if u r using any ABD directory to store the configurations, u might have to tell spring explicitly that the configurations
are stored here!

First step was to create a config directory inside resources directory. Inside that create files service1.properties and service2.properties
Adding a greeting property to both files.

So here we created a CONFIGURATION SERVICE AND A CONFIGURATION STORE!

Second step was to go to insomnia, use GET request with this url:http://localhost:8191/service1/default, this 'default' here is the profile type, e.g. default, prod, dev etc...
u ll get the following response
{
	"name": "service1",
	"profiles": [
		"default"
	],
	"label": null,
	"version": null,
	"state": null,
	"propertySources": [
		{
			"name": "classpath:/config/service1.properties",  //this is where the service1 configuration file comes from.
			"source": {
				"service.greeting": "Hello from service 1"  //this is the property of the file, adding more properties to the file, u ll get more here.
			}
		}
	]
}

if u try for service3 : http://localhost:8191/service3/default, u ll get the following response:

{
	"name": "service3",
	"profiles": [
		"default"
	],
	"label": null,
	"version": null,
	"state": null,
	"propertySources": []
}

becoz of no service3 file or any configurations.

Also if u try for service2 and give a different profile like this : http://localhost:8191/service2/prod or http://localhost:8191/service2/dev
u ll get the same response :
{
	"name": "service2",
	"profiles": [
		"prod"
	],
	"label": null,
	"version": null,
	"state": null,
	"propertySources": [
		{
			"name": "classpath:/config/service2.properties",
			"source": {
				"service.greeting": "Hello from service 2"
			}
		}
	]
}
*/

/*
There s a naming convention we need to follow for the property file, specially when hosting in git.

The convention to name ur property file is :
<the service name> - <profile> - <any label>.properties / .yml

Now we have a basic understanding of how we can create a configuration server and u can host it locally.

When u add more properties to the service1 or service2 files, http://localhost:8191/service2/prod
it will give the response as follows:

{
	"name": "service2",
	"profiles": [
		"prod"
	],
	"label": null,
	"version": null,
	"state": null,
	"propertySources": [
		{
			"name": "classpath:/config/service2.properties",
			"source": {
				"service.greeting": "Hello from service 2",
				"service.id": "8888898"
			}
		}
	]
}

 */