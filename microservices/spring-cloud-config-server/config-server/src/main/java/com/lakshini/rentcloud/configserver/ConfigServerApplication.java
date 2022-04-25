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

The above spring-cloud-config-store repo has 3 different services and one application.yml (this is the default configuration file).

In video 5, we learnt that if we want to invoke configurations stored in git, u need to give the <service-name>/<profile-name>

in this case, in the same directory (in the mem-service directory), we have multiple profiles: dev, prod, QA and also a service default configuration file.
the membership.yml configuration file is used as the default settings for that particular service. But the application.yml file is a global
configuration file (common to all services).

The file structure of the spring-cloud-config-store repo.
we have the SERVICES AND MULTIPLE PROFILES FOR EACH SERVICE. EACH SERVICE HAS ITS OWN DEFAULT CONFIGURATION FILE AND ONE GLOBAL CONFIGURATION
FILE FOR ALL THE SERVICES.

EACH .yml file should be named as follows :
{SERVICE-NAME} - {PROFILE-NAME}.yml

USUALLY WE HAVE TO CALL THESE CONFIGURATIONS IN THE CONFIGURATION SERVICE AS FOLLOWS :

{SERVICE-NAME} / {PROFILE-NAME} / [{TAG}], THE TAG IS OPTIONAL, tag will be a branch or commit id.

when u give the service-name in the application.properties, u give the service-name as follows :

spring.application.name=rate-service

When u want to set the active profile in the service, u give it as follows in aaplication.properties file

spring.profiles.active=prod

So, these r the 2 values it s gng to use to fetch this automatically from the configuration service.

Here the active profile is hardcoded as "prod", but how can this configuration service be deployed to dev environment because the profile is hardcoded.

so, what happens in the real production environment is, we dnt hardcode the profile, but  when we start the docker which contains the service (so service is started),
we call spring.profiles.active as an environment variable, then it reads that variable and kicks off the appropriate service and service will
use that value to fetch the real configurations.

we discussed 3 parts of the url:

{service-name} / {profile-name} / {tag} , tag is optional, it means u cn use a version that is prevous versions of the configurations,
versioning is an advantage when using git which is not there when using a local file system to store the configurations.
u cn do this in git becoz u have a commit id.

this is demonstrated by changing the membership-prod.yml file property "duration" from "all" to "winter". Commit and push it to the repo. Then from insonmia try calling :
http://localhost:8191/membership/prod -> it will return winter as the duration in the exact prod.yml

now, try calling the configuration service with a previous tag -> http://localhost:8191/membership/prod/a0c8e10d1156c6ee6bc0e98aa775be66cb1d66b0
u ll get the duration in membership-prod.yml as "all" becoz u have called the previous tag. This is the hash value for the previous commit: a0c8e10d1156c6ee6bc0e98aa775be66cb1d66b0

the tag also can be any branch e.g. dev branch : http://localhost:8191/membership/prod/dev


if u call membership/default -> default means no profile or default profile. This will return the file membership.yml, becoz that is the default
configuration file for the mem-service. Then it will also return the global configuration file which is application.yml

if u call membership/prod -> it returns the exact file -> membership-prod.yml and also the membership.yml(which is the global configuration file for that
service) and also application.yml (global configuration for all services)

if u call reporting/perf, in this case we dnt have a profile called "perf" but will still return the reporting service's default configuration file (reporting.yml), why
becoz there s no exact profile to match. it will also return the application.yml file.

if u call account/prod -> prod multiple profiles exist but there is nothing called account service, there are no property files for
account service. In that case, it will only return the application.yml file, which is the global file.

After running the application, no matter how we call, we get the application.yml as the response. See below. The url for the below one is:
http://localhost:8191/reporting/dev

{
	"name": "reporting",
	"profiles": [
		"dev"
	],
	"label": null,
	"version": "3eb0bdaa5290f16c4fb9b08b36629535bce4826d",
	"state": null,
	"propertySources": [
		{
			"name": "https://github.com/Lakshikuga/spring-cloud-config-store/file:C:\\Users\\LAKSHI~1\\AppData\\Local\\Temp\\config-repo-4008385398270611076\\application.yml",
			"source": {
				"server.port": 8191,
				"spring.cloud.config.server.git.uri": "https://github.com/krish/spring-cloud-config",
				"spring.cloud.config.server.git.search-paths[0]": "*service"
			}
		}
	]
}

Looks like something is wrong!!! The reason for this is : In the application.properties file, we r telling to go and serach the
spring-cloud-config-store repo. But we have not tell to go search in those subdirectories within that repo.

Therefore, we need to tell the search paths for each of these sub directories in the repo.
search-paths property is an array. u cn see that every directory ends with a "service". so we tell search the directories that
start with any character but ends with the "service" word. If there are any such directories, search in them.

http://localhost:8191/reporting/dev

now the response will b three files as follows.

{
	"name": "reporting",
	"profiles": [
		"dev"
	],
	"label": null,
	"version": "3eb0bdaa5290f16c4fb9b08b36629535bce4826d",
	"state": null,
	"propertySources": [
		{
			"name": "https://github.com/Lakshikuga/spring-cloud-config-store/file:C:\\Users\\LAKSHI~1\\AppData\\Local\\Temp\\config-repo-4326732519122436723\\rpt-service\\reporting-dev.yml",
			"source": {
				"report.export.type": "pdf",
				"report.border": 2,
				"report.page.color": "yellow",
				"report.page.size": "A4",
				"duration": "all"
			}
		},
		{
			"name": "https://github.com/Lakshikuga/spring-cloud-config-store/file:C:\\Users\\LAKSHI~1\\AppData\\Local\\Temp\\config-repo-4326732519122436723\\rpt-service\\reporting.yml",
			"source": {
				"report.export.type": "pdf",
				"report.border": "none",
				"report.page.color": "white",
				"report.page.size": "A4",
				"duration": "all"
			}
		},
		{
			"name": "https://github.com/Lakshikuga/spring-cloud-config-store/file:C:\\Users\\LAKSHI~1\\AppData\\Local\\Temp\\config-repo-4326732519122436723\\application.yml",
			"source": {
				"server.port": 8191,
				"spring.cloud.config.server.git.uri": "https://github.com/krish/spring-cloud-config",
				"spring.cloud.config.server.git.search-paths[0]": "*service"
			}
		}
	]
}

if u call reporting-prod.yml -> it will return the exact property file as the response. It does not give the service's default file or the global configuration file
obviously.

server:
  port: 8191
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/krish/spring-cloud-config
          search-paths:
          - '*service'
report:
  export:
    type: pdf,doc
  border: 1
  page:
    color: white
    size: A4
duration: all


but if u want to see this as a .properties file,instead of .yml file (we stored this as .yml file), u cn also get as .properties file by using this url :
http://localhost:8191/membership-prod.properties

also u cn see this file in json format too, using this url : http://localhost:8191/membership-prod.json

What happens here is, we get the exact file from that particular service (the contents of the file and the details of the file)

u cn also give repo and multiple repos in the application.properties file.

this is not how it will exactly work in real world. becoz in the real world, we dnt call these rest endpoints to get the configurations, these
have to happen automatically for the service.

so now we r gng to create a new service which consumes these configurations. It is a new project called config-consumer
 */
