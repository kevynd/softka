package com.softka.demo.service.cliente;

import com.softka.demo.dto.ClienteDto;
import com.softka.demo.dto.UsuarioDto;


public interface ClienteService {

    public UsuarioDto consultarCliente(String clienteId);
    public ClienteDto crearCliente(ClienteDto clienteDto);

    public UsuarioDto actualizarCliente(String clienteId, String contrasena, boolean estado);

    public UsuarioDto eliminarCliente(String clienteDto);
}
