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

    public void saveCar(Car car) {
        // TODO check for mandatory fields

        List<Model> model = modelRepository.findByName(car.getModelId().getName());
        List<Brand> brand = brandRepository.findByName(car.getModelId().getBrandId().getName());
        List<Transmission> transmission = transmissionRepository.findByName(car.getTransmissionId().getName());
        List<FuelType> fuelType = fuelTypeRepository.findByName(car.getFuelTypeId().getName());

        Brand newBrand = null;
        if (brand.size() == 0) {
            newBrand = brandRepository.save(car.getModelId().getBrandId());
        } else {
            newBrand = brand.get(0);
        }

        Model newModel = null;
        if (model.size() == 0) {
            newModel = modelRepository.save(car.getModelId());
            newModel.setBrandId(newBrand);
        } else {
            newModel = model.get(0);
        }
        car.setModelId(newModel);

        Transmission newTrans = null;
        if (transmission.size() == 0) {
            newTrans = transmissionRepository.save(car.getTransmissionId());
        } else {
            newTrans = transmission.get(0);
        }
        car.setTransmissionId(newTrans);

        FuelType newFuel = null;
        if (fuelType.size() == 0) {
            newFuel = fuelTypeRepository.save(car.getFuelTypeId());
        } else {
            newFuel = fuelType.get(0);
        }
        car.setFuelTypeId(newFuel);

        carRepository.save(car);

        System.out.println(car.getRemarks());
        System.out.println(car.getModelId().getBrandId().getName());
        System.out.println(car.getFuelTypeId().getName());
        System.out.println(car.getTransmissionId().getName());
    }
}
