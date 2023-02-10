package com.softka.demo.service.cliente;

import com.softka.demo.controller.mapper.MapperToEntity;
import com.softka.demo.dto.ClienteDto;
import com.softka.demo.dto.UsuarioDto;
import com.softka.demo.entity.ClienteEntity;
import com.softka.demo.entity.PersonaEntity;
import com.softka.demo.repository.ClienteRepository;
import com.softka.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public UsuarioDto consultarCliente(String clienteId) {
        UsuarioDto clienteResponse = new UsuarioDto();
        ClienteEntity cli = clienteRepository.consultarCliente(clienteId);

        clienteResponse.setClienteId(cli.getContrasena());
        clienteResponse.setContrasena(cli.getClienteId());
        return clienteResponse;
    }

    @Override
    public ClienteDto crearCliente(ClienteDto clienteDto) {
        MapperToEntity mapperToEntity = new MapperToEntity();

        ClienteEntity cliente = mapperToEntity.transformClienteEntity(clienteDto);

        PersonaEntity person = mapperToEntity.transformPersonaEntity(clienteDto);

        person.setCliente(cliente);
        cliente.setPersona(person);

        personaRepository.save(person);

        return clienteDto;
    }

    @Override
    public UsuarioDto actualizarCliente(String clienteId, String contrasena, boolean estado) {
        UsuarioDto clienteResponse = new UsuarioDto();

        ClienteEntity cli = clienteRepository.actualizarCliente(clienteId, contrasena, estado);
        clienteResponse.setClienteId(cli.getClienteId());
        clienteResponse.setContrasena(cli.getContrasena());
        clienteResponse.setEstado(cli.isEstado());

        return clienteResponse;
    }

    @Override
    public UsuarioDto eliminarCliente(String clienteId){
        UsuarioDto cliente = new UsuarioDto();

        ClienteEntity cli = clienteRepository.eliminarCliente(clienteId);

        cliente.setClienteId(cli.getClienteId());
        cliente.setContrasena(cli.getContrasena());
        cliente.setEstado(cli.isEstado());

        return cliente;
    }
}
