package com.cars.reto3.controller;

import com.cars.reto3.dbo.CarDbo;
import com.cars.reto3.dbo.ScoreDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ScoreModel;
import com.cars.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(value="*")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> obtener(){
        return scoreService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> obtenerById(@PathVariable int id) {
        return scoreService.obtenerById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ScoreModel scoreDbo){
        scoreService.crear(scoreDbo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        scoreService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ScoreDbo score){
        scoreService.actualizar(score);
    }

}
