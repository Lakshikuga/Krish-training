package com.lakshini.rentcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}





/*
video 6 - how to host a configuration store in github

these are 2 parts. Configuration server and configuration store. Configuration server u cn run anywhere, e.g.AWS or local machine.
In this video, the real configurations are going to be stored in github. So, for that we ll create a repository in github.
Then we pasted the contents in the primary-config-store folder in Krish's github repo(which was cloned) to the repo we created, and commited, pushed to that.

Then created this new project and added the git url of the repository (the configuration store) in application.properties.

 */
