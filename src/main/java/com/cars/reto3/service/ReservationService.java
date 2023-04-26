package com.cars.reto3.service;



import com.cars.reto3.dbo.ReportStatusDbo;
import com.cars.reto3.dbo.ReservationDbo;
import com.cars.reto3.model.ReservationModel;
import com.cars.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepositorio;

    public List<ReservationModel> obtener(){
        return reservationRepositorio.findAll();
    }

    public Optional<ReservationModel> obtenerById(int id){
        return reservationRepositorio.findById(id);
    }
    public void crear(ReservationModel res){
        reservationRepositorio.save(res);
    }

    public void eliminar(int id){
        reservationRepositorio.deleteById(id);
    }

    public void actualizar(ReservationDbo reservationInput) {
        Optional<ReservationModel> reservationDb = reservationRepositorio.findById(reservationInput.getIdReservation());
        if(reservationDb.isPresent()){
            ReservationModel reservation = reservationDb.get();
            if (reservationInput.getStartDate() != null){
                reservation.setStartDate(reservationInput.getStartDate());
            }
            if (reservationInput.getDevolutiontDate() != null){
                reservation.setDevolutionDate(reservationInput.getDevolutiontDate());
            }
            if (reservationInput.getScore() != null){
                reservation.setScore(reservationInput.getScore());
            }
            if (reservationInput.getStatus() != null){
                reservation.setStatus(reservationInput.getStatus());
            }
            if (reservationInput.getCar() != null){
                reservation.setCar(reservationInput.getCar());
            }
            if (reservationInput.getClient() != null){
                reservation.setClient(reservationInput.getClient());
            }
            reservationRepositorio.save(reservation);
        }
    }

    public List<ReservationModel> reporteDate(String startDate, String endDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date stDate = format.parse(startDate);
        Date edDate = format.parse(endDate);
        if(stDate.before(edDate)){
            return reservationRepositorio.findByStartDateBetween(stDate,edDate);
        } //{}
        else{
            return null;
        }
    }

    public ReportStatusDbo reportStatus() {
        Integer coutCompleted = reservationRepositorio.countByStatus("completed");
        Integer coutCancelled = reservationRepositorio.countByStatus("cancelled");
        return new ReportStatusDbo(coutCompleted,coutCancelled);
    }

}
