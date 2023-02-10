package com.softka.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="movimientos")
public class MovimientoEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Column(name = "TIPO_CUENTA")
    private String tipoCuenta;
    @Column(name = "SALDO_INICIAL")
    private float saldo;
    @Column(name = "ESTADO")
    private boolean estado;
    @Column(name = "MOVIMIENTO")
    private float movimiento;
    @Column(name = "FECHA")
    LocalDate fecha;
}
