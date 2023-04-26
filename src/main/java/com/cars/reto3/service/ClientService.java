package com.cars.reto3.service;


import com.cars.reto3.dbo.ClientDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepositorio;

    public List<ClientModel> obtener(){
        return clientRepositorio.findAll();
    }
    public Optional<ClientModel> obtenerById(int id){
        return clientRepositorio.findById(id);
    }

    public void crear(ClientModel client){
        clientRepositorio.save(client);
    }

    public void eliminar(int id){
        clientRepositorio.deleteById(id);
    }



    public void actualizar(ClientDbo clientInput) {
        Optional<ClientModel> clientDB = clientRepositorio.findById(clientInput.getIdClient());
        ClientModel client = clientDB.get();
        if(clientDB.isPresent()){
            if(clientInput.getName()!=null){
                client.setName(clientInput.getName());
            }
            if(clientInput.getAge()!=null){
                client.setAge(clientInput.getAge());
            }
            if(clientInput.getReservations()!=null){
                client.setReservations(clientInput.getReservations());
            }
            if(clientInput.getMessages()!=null){
                client.setMessages(clientInput.getMessages());
            }
            if(clientInput.getEmail()!=null){
                client.setEmail(clientInput.getEmail());
            }
            if(clientInput.getPassword()!=null){
                client.setPassword(clientInput.getPassword());
            }
            clientRepositorio.save(client);
        }
    }
}
