package com.cars.reto3.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NamedEntityGraph
public class ClientDbo {
    private int idClient;
    private String name;
    private String email;
    private String password;
    private byte age;

}
