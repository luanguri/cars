package com.cars.reto3.controller;

import com.cars.reto3.dbo.GamaDbo;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.model.GamaModel;
import com.cars.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(value="*")
public class GamaController {
    @Autowired
    GamaService gamaService;

    @GetMapping("/all")
    public List<GamaModel> obtener(){
        return gamaService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<GamaModel> obtenerById(@PathVariable int id) {
        return gamaService.obtenerById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    //public String crearGama(@RequestBody GamaDbo gamaDbo){
    public void crear(@RequestBody GamaModel gamaDbo){
        gamaService.crear(gamaDbo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        gamaService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody GamaDbo gama){
        gamaService.actualizar(gama);
    }
}
