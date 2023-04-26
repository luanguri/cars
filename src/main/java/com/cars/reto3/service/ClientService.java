package com.cars.reto3.service;


import com.cars.reto3.dbo.ClientDbo;
import com.cars.reto3.dbo.ReportClientsDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
        if(clientDB.isPresent()){
            ClientModel client = clientDB.get();
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
    public List<ReportClientsDbo> reportClients() {
        List<ReportClientsDbo> listReportClientDbo = new LinkedList<>();
        List<ClientModel> listClients = clientRepositorio.reportClient();
        for (ClientModel client : listClients) {
            int totalReservas = client.getReservations().size();
            ReportClientsDbo reportClientsDbo = new ReportClientsDbo(totalReservas,client);
            listReportClientDbo.add(reportClientsDbo);
        }

        return listReportClientDbo;
    }
}
