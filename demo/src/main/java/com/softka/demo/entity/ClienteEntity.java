package com.softka.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="clientes")
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = 1470086482137526180L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "CLIENTE_ID")
    private String clienteId;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToOne(mappedBy = "cliente")
    private PersonaEntity persona;
}
