package com.cars.reto3.controller;

import com.cars.reto3.dbo.CarDbo;
import com.cars.reto3.dbo.ReservationDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ReservationModel;
import com.cars.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(value="*")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> obtenerById(@PathVariable int id) {
        return reservationService.obtenerById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservationDbo){
        reservationService.crear(reservationDbo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ReservationDbo res){
        reservationService.actualizar(res);
    }

}
