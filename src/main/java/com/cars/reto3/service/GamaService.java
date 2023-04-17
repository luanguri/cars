package com.cars.reto3.service;

import com.cars.reto3.model.GamaModel;
import com.cars.reto3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaService {
    @Autowired
    GamaRepository gamaRepositorio;

    public List<GamaModel> obtener(){
        return gamaRepositorio.findAll();
    }

    public void crear(GamaModel gama){
        gamaRepositorio.save(gama);
    }
}
