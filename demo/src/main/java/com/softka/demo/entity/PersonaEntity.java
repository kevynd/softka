package com.softka.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="personas")
public class PersonaEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private  ClienteEntity cliente;
}
