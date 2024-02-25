package com.caltech.mypetclinic.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		
		info = @Info(
				contact = @Contact(
							name = "Arvend",
							email = "arvendrajan100@gmail.com",
							url = "https://mypet.com"
						),
				description = "OpenAPI documentation for mypet clinic",
				title = "MyPet App Open API",
				version = "1.0",
				license = @License(
						name = "License name",
						url = "https://some-url.com"
						),
				termsOfService = "Terms of Service"
				),
		servers = {
				@Server(
						description = "Local ENV",
						url = "http://localhost:8090"
						
						),
				@Server(
						description = "PROD ENV",
						url ="https://prod.com"
						)
				
		}
		)
	
	
public class OpenApiConfig {

}
