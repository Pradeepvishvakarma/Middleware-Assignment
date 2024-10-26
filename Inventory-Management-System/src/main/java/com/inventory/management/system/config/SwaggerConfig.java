package com.inventory.management.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI usersMicroserviceOpenAPI() {
		return new OpenAPI().info(new Info().title("Inventory Management System")
				.description("Application which provides the management of the Inventory").version("1.0"));
	}
}