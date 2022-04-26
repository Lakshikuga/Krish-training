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

the error when running this application: address is already in use. tomcat connected to 8191 failed to start, port is already in use.

in our case, we did not specify any port this config-consumer to run. This means it has to run on tomcat's default port 8080. But it does not run on that port nd that
s why the above error!!!
so, lets specify the port 8080 in application.properties and see.


Note : in Krish's video, when running the config-consumer first time, i.e. when config uri is added to application.properties file,
it says it fetching config from port 8888, this is the default port for configuration server. if we do not specify when we created a configuration server, this
is the port it takes to run the config server, by default.

in our case we purposefully ran the configuration server on port 8191.

When configuration server starts, before it reaches or processes the application.properties file, it tries to fetch the configurations, since we have a client dependency
in the pom file of config-consumer, it tries to pull the configurations. it sees there is no specified configuration uri, so the config-consumer tries to pull configurations from
the default port 8888 (default uri).So, this is why becoz, configurations has to be fetched before it reaches the application.properties file. So even though
config uri is mentioned in the application.properties of the config-consumer, it will try to look in port 8888.

Then he creates a bootstrap.yml file, where the config uri goes and not in the application.yml or application/propertie file.
Then restarts config-consumer and now it fetches configurations from the port 8191.
If u put configuration uri in the application.properties file, it wont work, why becoz configurations are fetched before it processes the application.properties file of the project (config-consumer)

But he gets an error when this is running i.e. address already in use.

in our case we have not specified a port for the config-consumer application to run, in its application.properties file. since it is not specified, it has to
run on the default tomcat server port which is 8080., but it is not running in that port.

so therefore to check this, he specifies the port 8080 in the application.properties file. But still gets the same error as address already in use.
this implies that it will not run in port 8080, whether mentioned or not.

it fetches config from server at 8191, we did nt specify any profile, so it fetches profile as the "default" profile (e.g. if we call membership/default)
then it will return the default configuration file for the mem-service, which is membership.yml and the global configuration file, application.yml.
so, in the application.yml, we have specified the port as 8191. So what happens here, the config-consumer starts running at port 8080, it fetches the configurations from configuration
server running at 8191, and overrides existing configurations (any configurations in the config-consumer resources folder), since the application.yml in git (basically the configuration server)
tells that the port that config-consumer should run is 8191. so, it overrides 8080 to 8191 and tries to start, but it cnt start, 8191 is already reserved by the configuration server.
so what he did is delete all the configurations from the application.yml file and estart config-consumer.

now even though config-consumer fetches the configurations, the application.yml file does not have configurations to override, so now config-consumer
continues to run at port 8080 without any errors.

so far, now config-consumer is fetching the configurations from the configuration server hosted in git.
now try to consume these configurations.
*/

/* MY CASE - BECOZ WATEVER I PUT IN bootstrap.properties file is not taking.
Here, in the application.properties file, i have not mentioned the config uri, so the config-consumer does not know the port in which
configuration server is running at the moment, so therefore it checks the default port of the configuration server, 8888. but i mentioned it in bootstrap.properties file, but it seems to not take it.

the below was in the logs
Fetching config from server at : http://localhost:8888

but when i mention it in the application.properties without in the bootstrap.properties file, it seems to fetch properly from 8191, but there s
an address aleady in use error. may be becoz of versioning, i had to put another property in application.properties file, spring.config.import
maybe because of this, the config consumer is able to pull configurations from 8191 eventhough the config uri being mentioned in the application.properties file.

so likewise even after mentioning the port for config-consumer as 8080, in application.properties file, it still gives the address already in use error.

i did the same and now config-consumer is running fine in port 8080.
*/
