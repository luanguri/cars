package com.cars.reto3.controller;

import com.cars.reto3.dbo.CarDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(value="*")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/all")
    public List<CarModel> obtener(){
        return carService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<CarModel> obtenerById(@PathVariable int id) {
        return carService.obtenerById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody CarModel carDbo){
        carService.crear(carDbo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        carService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody CarDbo car){
        carService.actualizar(car);
    }

}
