package com.cars.reto3.dbo;

import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import com.cars.reto3.model.ScoreModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NamedEntityGraph
public class ReservationDbo {
    private Integer idReservation;
    private Date startDate;
    private Date devolutiontDate;
    private String status;
    private ScoreModel score;
    private CarModel car;
    private ClientModel client;

}
