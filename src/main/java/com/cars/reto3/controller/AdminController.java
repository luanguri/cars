package com.cars.reto3.controller;

import com.cars.reto3.dbo.AdminDbo;
import com.cars.reto3.model.AdminModel;
import com.cars.reto3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel> obtenerAdministrador(){
        return adminService.obtenerAdministradores();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String crearAdministradores(@RequestBody AdminModel adminDbo){
        return adminService.crearAdministradores(adminDbo);
    }
}
