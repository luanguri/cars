package com.cars.reto3.service;

import com.cars.reto3.dbo.MessageDbo;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.model.MessageModel;
import com.cars.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepositorio;

    public List<MessageModel> obtener(){
        return messageRepositorio.findAll();
    }

    public Optional<MessageModel> obtenerById(int id){
        return messageRepositorio.findById(id);
    }
    public void crear(MessageModel message){
        messageRepositorio.save(message);
    }

    public void eliminar(int id){
        messageRepositorio.deleteById(id);
    }
    public void actualizar(MessageDbo messageInput) {
        Optional<MessageModel> messageDb = messageRepositorio.findById(messageInput.getIdMessage());
        if(messageDb.isPresent()){
            MessageModel message = messageDb.get();
            if(messageInput.getMessageText() != null){
                message.setMessageText(messageInput.getMessageText());
            }
            if(messageInput.getCar() != null){
                message.setCar(messageInput.getCar());
            }
            if(messageInput.getClient() != null){
                message.setClient(messageInput.getClient());
            }
            messageRepositorio.save(message);
        }
    }
}
