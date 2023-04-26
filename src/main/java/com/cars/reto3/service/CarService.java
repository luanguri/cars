package com.cars.reto3.service;

import com.cars.reto3.dbo.CarDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepositorio;

    public List<CarModel> obtener(){
        return carRepositorio.findAll();
    }

    public Optional<CarModel> obtenerById(int id){
        return carRepositorio.findById(id);
    }
    public void crear(CarModel car){
        carRepositorio.save(car);
    }

    public void eliminar(int id){
        carRepositorio.deleteById(id);
    }


    public void actualizar(CarDbo carInput) {
        Optional<CarModel> carDB = carRepositorio.findById(carInput.getIdCar());
        if(carDB.isPresent()){
            CarModel car = carDB.get();
            if(carInput.getBrand()!=null){
                car.setBrand(carInput.getBrand());
            }
            if(carInput.getDescription()!=null){
                car.setDescription(carInput.getDescription());
            }
            if(carInput.getGama()!=null){
                car.setGama(carInput.getGama());
            }
            if(carInput.getMessages()!=null){
                car.setMessages(carInput.getMessages());
            }
            if(carInput.getName()!=null){
                car.setName(carInput.getName());
            }
            if(carInput.getReservations()!=null){
                car.setReservations(carInput.getReservations());
            }
            if(carInput.getYear()!=null){
                car.setBrand(carInput.getBrand());
            }
            carRepositorio.save(car);
        }
    }
}
