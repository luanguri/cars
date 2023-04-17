package com.cars.reto3.dbo;

import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NamedEntityGraph
public class ReservationDbo {
    private int idReservation;
    private Date startDate;
    private Date devolutiontDate;
    private CarModel car;
    private ClientModel client;

}
