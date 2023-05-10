package com.example.CarCatalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CarCatalog.repositories.CarRepository;

@SpringBootApplication
public class CarCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCatalogApplication.class, args);
	}

	@Bean
	public CommandLineRunner initTestData(CarRepository carRepository) {
		return args -> {
			
		};
	}

}
