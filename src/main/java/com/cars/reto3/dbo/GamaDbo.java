package com.cars.reto3.dbo;

import com.cars.reto3.model.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NamedEntityGraph
public class GamaDbo {
    private Integer idGama;
    private String name;
    private String description;
    private List<CarModel> cars;
}
