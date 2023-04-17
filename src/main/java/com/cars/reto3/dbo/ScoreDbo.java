package com.cars.reto3.dbo;

import com.cars.reto3.model.ReservationModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NamedEntityGraph
public class ScoreDbo {
    private int idScore;
    private float value;
    private ReservationModel reservation;

}
