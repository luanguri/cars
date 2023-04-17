package com.cars.reto3.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NamedEntityGraph
public class GamaDbo {
    private int idGama;
    private String name;
    private String description;

}
