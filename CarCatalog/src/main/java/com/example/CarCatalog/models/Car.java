package com.example.CarCatalog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "vin_number", nullable = false)
    private String vin_number;

    @OneToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private Model modelId;

    @Column(name = "price", nullable = false)
    private Integer price;

    // TODO Add date here

    @OneToOne
    @JoinColumn(name = "transmission_id", referencedColumnName = "id", nullable = false)
    private Transmission transmissionId;

    @OneToOne
    @JoinColumn(name = "fuel_type_id", referencedColumnName = "id", nullable = false)
    private FuelType fuelTypeId;

    @Column(name = "remarks")
    private String remarks;

    public Car() {
    }

    public Car(String vin_number, Model modelId, Integer price, Transmission transmissionId, FuelType fuelTypeId, String remarks) {
        this.vin_number = vin_number;
        this.modelId = modelId;
        this.price = price;
        this.transmissionId = transmissionId;
        this.fuelTypeId = fuelTypeId;
        this.remarks = remarks;
    }

    public String getVin_number() {
        return this.vin_number;
    }

    public void setVin_number(String vin_number) {
        this.vin_number = vin_number;
    }

    public Model getModelId() {
        return this.modelId;
    }

    public void setModelId(Model modelId) {
        this.modelId = modelId;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Transmission getTransmissionId() {
        return this.transmissionId;
    }

    public void setTransmissionId(Transmission transmissionId) {
        this.transmissionId = transmissionId;
    }

    public FuelType getFuelTypeId() {
        return this.fuelTypeId;
    }

    public void setFuelTypeId(FuelType fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}