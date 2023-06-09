package com.cars.reto3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer idAdmin;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    //@Column(length = 3)
    private Byte age;

}
