package com.names.fiducial;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class FiducialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiducialApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		Info info = new Info()
				.title("FIDUCIAL NAME API")
				.version("1.0")
				.description("This API exposes endpoints for names.");

		return new OpenAPI()
				.info(info);
	}
}
