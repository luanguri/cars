package com.cars.reto3.service;

import com.cars.reto3.model.MessageModel;
import com.cars.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepositorio;

    public List<MessageModel> obtener(){
        return messageRepositorio.findAll();
    }

    public void crear(MessageModel message){
        messageRepositorio.save(message);
    }
}
