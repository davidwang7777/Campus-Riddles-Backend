package com.SobreMesa.Campus.Riddles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication( exclude = { SecurityAutoConfiguration.class } )
public class CampusRiddlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusRiddlesApplication.class, args);
	}

	
	
	
}


/*
<dependency>
<groupId>com.github.java-json-tools</groupId>
<artifactId>json-patch</artifactId>
<version>1.13</version>
</dependency>
*/