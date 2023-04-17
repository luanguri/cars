package com.cars.reto3.service;


import com.cars.reto3.model.ScoreModel;
import com.cars.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepositorio;

    public List<ScoreModel> obtener(){
        return scoreRepositorio.findAll();
    }

    public void crear(ScoreModel score){
        scoreRepositorio.save(score);
    }
}
