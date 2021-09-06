package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class SpringBootRegistrationLoginApplication extends SpringBootServletIntializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegistrationLoginApplication.class, args);
		
	}
	
	@Override
	protected  SpringApplicationBuilder configure(SpringApplicationBuilder builder)  {
		
		return builder.sources(SpringBootRegistrationLoginApplication.class);
	}
	

}
