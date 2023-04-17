package com.cars.reto3.controller;

import com.cars.reto3.dbo.GamaDbo;
import com.cars.reto3.model.GamaModel;
import com.cars.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    GamaService gamaService;

    @GetMapping("/all")
    public List<GamaModel> obtener(){
        return gamaService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //public String crearGama(@RequestBody GamaDbo gamaDbo){
    public void crear(@RequestBody GamaModel gamaDbo){
        gamaService.crear(gamaDbo);
    }
}
