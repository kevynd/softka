package com.softka.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovimientoDto {
    @NotBlank
    @NotNull
    private String numeroCuenta;
    @NotNull
    private String tipoCuenta;
    @NotNull
    private float saldoInicial;
    @NotNull
    private boolean estado;
    @NotNull
    private float valor;

}
