package com.example.CarCatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private TransmissionRepository transmissionRepository;

    /**
     * Saves the given car to the db.
     * @param car - car to be saved
     */
    public void saveCar(Car car) {

        checkMandatoryFields(car);

        List<Model> model = modelRepository.findByName(car.getModelId().getName());
        List<Brand> brand = brandRepository.findByName(car.getModelId().getBrandId().getName());
        List<Transmission> transmission = transmissionRepository.findByName(car.getTransmissionId().getName());
        List<FuelType> fuelType = fuelTypeRepository.findByName(car.getFuelTypeId().getName());

        // Check if the given brand already exists. If yes then uses the one from db. If not saves the current one.
        Brand newBrand = null;
        if (brand.size() == 0) {
            newBrand = brandRepository.save(car.getModelId().getBrandId());
        } else {
            newBrand = brand.get(0);
        }

        // Check if the given model already exists. If yes then uses the one from db. If not saves the current one.
        Model newModel = null;
        if (model.size() == 0) {
            car.getModelId().setBrandId(newBrand);
            newModel = modelRepository.save(car.getModelId());
        } else {
            newModel = model.get(0);
        }
        newModel.setBrandId(newBrand);
        car.setModelId(newModel);

        // Check if the given transmission already exists. If yes then uses the one from db. If not saves the current one.
        Transmission newTrans = null;
        if (transmission.size() == 0) {
            newTrans = transmissionRepository.save(car.getTransmissionId());
        } else {
            newTrans = transmission.get(0);
        }
        car.setTransmissionId(newTrans);

        // Check if the given fuel type already exists. If yes then uses the one from db. If not saves the current one.
        FuelType newFuel = null;
        if (fuelType.size() == 0) {
            newFuel = fuelTypeRepository.save(car.getFuelTypeId());
        } else {
            newFuel = fuelType.get(0);
        }
        car.setFuelTypeId(newFuel);

        carRepository.save(car);

        // TODO DELETE LATER
        System.out.println(car.getRemarks());
        System.out.println(car.getModelId().getBrandId().getName());
        System.out.println(car.getFuelTypeId().getName());
        System.out.println(car.getTransmissionId().getName());
    }

    /**
     * Checks if the mandatory fields of the car are all filled in.
     * @throws IllegalArgumentException if any of the fields are empty or null
     * @param car - car to be checked
     */
    public void checkMandatoryFields(Car car) {
        boolean emptyField = false;
        String exceptionMsg = "";

        if (car.getVin_number() == null) {
            emptyField = true;
            exceptionMsg = "Vin number should be specified!";
        } else if (car.getVin_number() == null) {
            emptyField = true;
            exceptionMsg = "Vin number should be specified!";
        } else if (car.getVin_number().isEmpty()) {
            emptyField = true;
            exceptionMsg = "Vin number should be specified!";
        } else if (car.getModelId() == null) {
            emptyField = true;
            exceptionMsg = "Model should be specified!";
        } else if (car.getModelId().getName() == null) {
            emptyField = true;
            exceptionMsg = "Model should be specified!";
        }else if (car.getModelId().getName().isEmpty()) {
            emptyField = true;
            exceptionMsg = "Model should be specified!";
        } else if (car.getModelId().getBrandId() == null) {
            emptyField = true;
            exceptionMsg = "Brand should be specified!";
        } else if (car.getModelId().getBrandId().getName() == null) {
            emptyField = true;
            exceptionMsg = "Brand should be specified!";
        } else if (car.getModelId().getBrandId().getName().isEmpty()) {
            emptyField = true;
            exceptionMsg = "Brand should be specified!";
        } else if (car.getPrice() == null) {
            emptyField = true;
            exceptionMsg = "Price should be specified!";
        } else if (car.getTransmissionId() == null) {
            emptyField = true;
            exceptionMsg = "Transmission should be specified!";
        } else if (car.getTransmissionId().getName() == null) {
            emptyField = true;
            exceptionMsg = "Transmission should be specified!";
        } else if (car.getTransmissionId().getName().isEmpty()) {
            emptyField = true;
            exceptionMsg = "Transmission should be specified!";
        } else if (car.getFuelTypeId() == null) {
            emptyField = true;
            exceptionMsg = "Fuel type should be specified!";
        } else if (car.getFuelTypeId().getName() == null) {
            emptyField = true;
            exceptionMsg = "Fuel type should be specified!";
        } else if (car.getFuelTypeId().getName().isEmpty()) {
            emptyField = true;
            exceptionMsg = "Fuel type should be specified!";
        }

        if (emptyField) {
            throw new IllegalArgumentException(exceptionMsg);
        }
    }
}
