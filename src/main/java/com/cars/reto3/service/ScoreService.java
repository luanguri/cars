package com.cars.reto3.service;


import com.cars.reto3.dbo.ScoreDbo;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.model.ScoreModel;
import com.cars.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepositorio;

    public List<ScoreModel> obtener(){
        return scoreRepositorio.findAll();
    }
    public Optional<ScoreModel> obtenerById(int id){
        return scoreRepositorio.findById(id);
    }

    public void crear(ScoreModel score){
        scoreRepositorio.save(score);
    }

    public void eliminar(int id){
        scoreRepositorio.deleteById(id);
    }

    public void actualizar(ScoreDbo scoreInput) {
        Optional<ScoreModel> scoreDb = scoreRepositorio.findById(scoreInput.getIdScore());
        if(scoreDb.isPresent()){
            ScoreModel score = scoreDb.get();
            if(scoreInput.getStars() != null){
                score.setStars(scoreInput.getStars());
            }
            scoreRepositorio.save(score);
        }
    }
}
