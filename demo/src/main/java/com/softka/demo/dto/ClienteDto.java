package com.softka.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDto {
    @NotBlank
    @NotNull
    private String nombres;
    @NotBlank
    @NotNull
    private String genero;
    @NotNull
    private int edad;
    @NotNull
    private String identificacion;
    @NotBlank
    @NotNull
    private String direccion;
    @NotBlank
    @NotNull
    private String telefono;
    @NotBlank
    @NotNull
    private String password;
    @NotNull
    private boolean estado;
}
