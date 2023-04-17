package com.cars.reto3.service;


import com.cars.reto3.model.ClientModel;
import com.cars.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepositorio;

    public List<ClientModel> obtener(){
        return clientRepositorio.findAll();
    }

    public void crear(ClientModel client){
        clientRepositorio.save(client);
    }
}
