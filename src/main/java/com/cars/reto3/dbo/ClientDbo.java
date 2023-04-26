package com.cars.reto3.dbo;

import com.cars.reto3.model.MessageModel;
import com.cars.reto3.model.ReservationModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NamedEntityGraph
public class ClientDbo {
    private Integer idClient;
    private String name;
    private String email;
    private String password;
    private Byte age;
    private List<MessageModel> messages;
    private List<ReservationModel> reservations;


}
