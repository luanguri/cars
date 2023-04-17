package com.cars.reto3.service;



import com.cars.reto3.model.ReservationModel;
import com.cars.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepositorio;

    public List<ReservationModel> obtener(){
        return reservationRepositorio.findAll();
    }

    public void crear(ReservationModel res){
        reservationRepositorio.save(res);
    }
}
