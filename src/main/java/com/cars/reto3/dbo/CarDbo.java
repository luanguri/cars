package com.cars.reto3.dbo;

import com.cars.reto3.model.GamaModel;
import com.cars.reto3.model.MessageModel;
import com.cars.reto3.model.ReservationModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NamedEntityGraph
public class CarDbo {
    private Integer idCar;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    private GamaModel gama;
    private List<MessageModel> messages;
    private List<ReservationModel> reservations;
}
