package com.cars.reto3.service;

import com.cars.reto3.model.CarModel;
import com.cars.reto3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepositorio;

    public List<CarModel> obtener(){
        return carRepositorio.findAll();
    }

    public void crear(CarModel car){
        carRepositorio.save(car);
    }
}
