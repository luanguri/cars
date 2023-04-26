package com.cars.reto3.controller;

import com.cars.reto3.dbo.ReportClientsDbo;
import com.cars.reto3.dbo.ReportStatusDbo;
import com.cars.reto3.dbo.ReservationDbo;
import com.cars.reto3.model.ReservationModel;
import com.cars.reto3.service.ReservationService;
import com.cars.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(value="*")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    ClientService clientService;

    @GetMapping("/report-dates/{startDate}/{endDate}")
    public List<ReservationModel> reportDate(@PathVariable String startDate, @PathVariable String endDate) throws ParseException {
        return reservationService.reporteDate(startDate,endDate);
    }
    @GetMapping("/report-status")
    public ReportStatusDbo reportStatus(){
        return reservationService.reportStatus();
    }

    @GetMapping("/report-clients")
    public List<ReportClientsDbo> reportClients(){
        return clientService.reportClients();
    }

    @GetMapping("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> obtenerById(@PathVariable int id) {
        return reservationService.obtenerById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservationDbo){
        reservationService.crear(reservationDbo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ReservationDbo res){
        reservationService.actualizar(res);
    }

}
