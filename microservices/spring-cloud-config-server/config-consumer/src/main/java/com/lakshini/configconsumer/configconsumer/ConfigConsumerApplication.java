package com.lakshini.configconsumer.configconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigConsumerApplication.class, args);
    }

}


/*
first in application.properties, we will give the config uri, this is the same url of the configuration server.

then start the configuration server - run the config-server project
then run the config-consumer project.

When config-consumer runs, u ll see that it is trying to fetch the configurations from localhost running at port 8888.
This is the default port for running the configuration server. If u didnt specify any port when creating a configuration server, this is the port it
takes.

But, in our case, the port we specified to run the configuration server is 8191.
when the spring application starts, before it reaches or processes the application.properties file of this project, it tries to fetch the configurations. It sees
ok, there s no specified URI, so what it does is try to pull it from the default URI. THIS IS BECOZ CONFIGURATIONS HAVE TO BE FETCHED
BEFORE IT PROCESSES THE APPLICATION.PROPERTIES FILE.
since we have a configuration client dependency in the pom file of this project, it tries to pull the configurations from git.

SO, THE SOLUTION IS WE HAVE TO MAKE A FILE CALLED bootstrap.yml file and adding the configuration URI to this file instead in the application.properties file.


NOTE : IF U PUT THE CONFIGURATION URI IN THE application.properties file, it wont wrk becoz, configurations are fetched before processing the
application.properties file.


 */
