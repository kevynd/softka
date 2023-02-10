package com.softka.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="cuentas")
public class CuentaEntity {
    private static final long serialVersionUID = 1470086482137526180L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Column(name = "TIPO_CUENTA")
    private String tipoCuenta;
    @Column(name = "SALDO_INICIAL")
    private float saldoInicial;
    @Column(name = "ESTADO")
    private boolean estado;
    @Column(name = "CLIENTE")
    private String cliente;
    @Column(name = "IDENTIFICADOR")
    private String identificador;
}
