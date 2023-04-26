package com.cars.reto3.controller;

import com.cars.reto3.dbo.CarDbo;
import com.cars.reto3.dbo.MessageDbo;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.model.MessageModel;
import com.cars.reto3.service.MessageService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(value="*")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> obtener(){
        return messageService.obtener();
    }
    @GetMapping("/{id}")
    public Optional<MessageModel> obtenerById(@PathVariable int id) {
        return messageService.obtenerById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody MessageModel messageDbo){
         messageService.crear(messageDbo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        messageService.eliminar(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody MessageDbo message){
        messageService.actualizar(message);
    }

}
