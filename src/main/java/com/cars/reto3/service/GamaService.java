package com.cars.reto3.service;

import com.cars.reto3.dbo.GamaDbo;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.model.GamaModel;
import com.cars.reto3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    GamaRepository gamaRepositorio;

    public List<GamaModel> obtener(){
        return gamaRepositorio.findAll();
    }

    public Optional<GamaModel> obtenerById(int id){
        return gamaRepositorio.findById(id);
    }

    public void crear(GamaModel gama){
        gamaRepositorio.save(gama);
    }

    public void eliminar(int id){
        gamaRepositorio.deleteById(id);
    }

    public void actualizar(GamaDbo gamaInput) {
        Optional<GamaModel> gamaDb = gamaRepositorio.findById(gamaInput.getIdGama());
        if(gamaDb.isPresent()){
            GamaModel gama = gamaDb.get();
            if(gamaInput.getName() != null){
                gama.setName(gamaInput.getName());
            }
            if(gamaInput.getDescription() != null){
                gama.setDescription(gamaInput.getDescription());
            }
            if(gamaInput.getCars() != null){
                gama.setCars(gamaInput.getCars());
            }
            gamaRepositorio.save(gama);
        }
    }
}
