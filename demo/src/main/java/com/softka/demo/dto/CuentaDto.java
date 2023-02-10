package com.softka.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CuentaDto {
    @NotBlank
    @NotNull
    private String numeroCuenta;
    @NotBlank
    @NotNull
    private String tipoCuenta;
    @NotNull
    private float saldoInicial;
    @NotNull
    private boolean estado;
    @NotNull
    private String identificador;
}
