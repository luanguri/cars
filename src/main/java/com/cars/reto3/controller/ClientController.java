package com.cars.reto3.controller;

import ch.qos.logback.core.net.server.Client;
import com.cars.reto3.dbo.ClientDbo;
import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(value="*")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> obtener(){
        return clientService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ClientModel> obtenerById(@PathVariable int id) {
        return clientService.obtenerById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ClientModel clientDbo){
        clientService.crear(clientDbo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        clientService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ClientDbo client){
        clientService.actualizar(client);
    }
}
