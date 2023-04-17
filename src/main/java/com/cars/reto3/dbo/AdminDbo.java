package com.cars.reto3.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NamedEntityGraph
public class AdminDbo {
    private int idAdmin;
    private String email;
    private String password;
    private byte age;

}
