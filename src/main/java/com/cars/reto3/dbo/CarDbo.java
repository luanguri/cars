package com.cars.reto3.dbo;

import com.cars.reto3.model.GamaModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NamedEntityGraph
public class CarDbo {
    private int idCar;
    private String name;
    private String brand;
    private int year;
    private String description;
    private GamaModel gama;
}
