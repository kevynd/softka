package com.softka.demo.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDto {
    private String contrasena;
    private String clienteId;
    private boolean estado;
}
