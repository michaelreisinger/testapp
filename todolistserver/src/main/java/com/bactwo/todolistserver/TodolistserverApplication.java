package com.bactwo.todolistserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TodolistserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistserverApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfig () {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/resource/v1/todolist/**"))
				.apis(RequestHandlerSelectors.basePackage("com.bactwo"))
				.build();
	}

}
