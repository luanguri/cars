package com.cars.reto3.dbo;

import com.cars.reto3.model.CarModel;
import com.cars.reto3.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NamedEntityGraph
public class MessageDbo {
    private int idMessage;
    private String messageText;
    private CarModel car;
    private ClientModel client;

}
