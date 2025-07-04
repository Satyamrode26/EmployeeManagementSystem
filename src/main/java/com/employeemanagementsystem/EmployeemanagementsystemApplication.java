package com.employeemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info (title = "EmployeeManagementSystemApi",
		version="1.0",
		description="============================================================================================= ")
		)
public class EmployeemanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementsystemApplication.class, args);
	}
	@Bean
	public OpenAPI getopenAPI() {
		return new OpenAPI();
	}

}
