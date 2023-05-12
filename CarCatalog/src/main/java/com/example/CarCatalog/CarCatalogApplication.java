package com.example.CarCatalog;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CarCatalog.models.Brand;
import com.example.CarCatalog.models.Car;
import com.example.CarCatalog.models.FuelType;
import com.example.CarCatalog.models.Model;
import com.example.CarCatalog.models.Transmission;
import com.example.CarCatalog.repositories.BrandRepository;
import com.example.CarCatalog.repositories.CarRepository;
import com.example.CarCatalog.repositories.FuelTypeRepository;
import com.example.CarCatalog.repositories.ModelRepository;
import com.example.CarCatalog.repositories.TransmissionRepository;

@SpringBootApplication
public class CarCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCatalogApplication.class, args);
	}

	@Bean
	public CommandLineRunner initTestData(CarRepository carRepository, BrandRepository brandRepository, FuelTypeRepository fuelTypeRepository, ModelRepository modelRepository, TransmissionRepository transmissionRepository) {
		return args -> {

			Brand vw = new Brand("vw");
			Brand audi = new Brand("audi");

			Model q5 = new Model("q5", audi);
			Model q7 = new Model("q7", audi);
			Model passat = new Model("passat", vw);
			Model tiguan = new Model("tiguan", vw);

			Transmission hybrid = new Transmission("hybrid");
			Transmission automatic = new Transmission("automatic");

			FuelType gas = new FuelType("gas");
			FuelType diesel = new FuelType("diesel");

			brandRepository.save(vw);
			brandRepository.save(audi);

			modelRepository.save(q5);
			modelRepository.save(passat);
			modelRepository.save(q7);
			modelRepository.save(tiguan);

			transmissionRepository.save(hybrid);
			transmissionRepository.save(automatic);

			fuelTypeRepository.save(gas);
			fuelTypeRepository.save(diesel);

			Car car1 = new Car("vin number", q7, 20000, new Date(), hybrid, gas, "new1");
			carRepository.save(car1);

			Car car3 = new Car("vin number3", q5, 10300, new Date(), automatic, gas, "new2");
			carRepository.save(car3);

			Car car2 = new Car("number vin", passat, 10500, new Date(), hybrid, diesel, "old1");
			carRepository.save(car2);

			Car car4 = new Car("number vin 4", tiguan, 15000, new Date(), automatic, diesel, "old2");
			carRepository.save(car4);
		};
	}

}
