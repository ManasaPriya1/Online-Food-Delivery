package com.cg.fds;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OnlinefoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinefoodDeliveryApplication.class, args);
		
	}

	//Create Docket bean to configure swagger 2 for your application
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.cg.fds")).build();
	}
}
	

	


