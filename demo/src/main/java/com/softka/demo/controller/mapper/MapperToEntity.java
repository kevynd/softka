package com.softka.demo.controller.mapper;

import com.softka.demo.dto.ClienteDto;
import com.softka.demo.dto.CuentaDto;
import com.softka.demo.dto.MovimientoDto;
import com.softka.demo.dto.MovimientoHistoricoDto;
import com.softka.demo.entity.ClienteEntity;
import com.softka.demo.entity.CuentaEntity;
import com.softka.demo.entity.MovimientoEntity;
import com.softka.demo.entity.PersonaEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MapperToEntity {

    public PersonaEntity transformPersonaEntity(ClienteDto cli) {
        PersonaEntity personaEntity = new PersonaEntity();

        personaEntity.setNombre(cli.getNombres());
        personaEntity.setGenero(cli.getGenero());
        personaEntity.setIdentificacion(cli.getIdentificacion());
        personaEntity.setEdad(cli.getEdad());
        personaEntity.setTelefono(cli.getTelefono());
        personaEntity.setDireccion(cli.getDireccion());

        return personaEntity;
    }

    public ClienteEntity transformClienteEntity(ClienteDto cli) {
       ClienteEntity clienteEntity = new ClienteEntity();

       clienteEntity.setClienteId(cli.getIdentificacion());
       clienteEntity.setContrasena(cli.getPassword());
       clienteEntity.setEstado(cli.isEstado());


        return clienteEntity;
    }

    public CuentaEntity transformCuentaEntity(CuentaDto cuenta) {
        CuentaEntity cuentaEntity = new CuentaEntity();

        cuentaEntity.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaEntity.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaEntity.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaEntity.setEstado(cuenta.isEstado());
        return cuentaEntity;
    }

    public  MovimientoEntity transformMovEntity(MovimientoDto movimientoDto) {
        MovimientoEntity mov = new MovimientoEntity();

        mov.setFecha(LocalDate.now());
        mov.setNumeroCuenta(movimientoDto.getNumeroCuenta());
        mov.setTipoCuenta(movimientoDto.getTipoCuenta());
        mov.setSaldo(movimientoDto.getSaldoInicial());
        mov.setEstado(movimientoDto.isEstado());
        mov.setMovimiento(movimientoDto.getValor());

        return mov;
    }

    public List<MovimientoDto> transformListMovEntityToListMovDtos(List<MovimientoEntity> movimientoEntities) {
        List<MovimientoDto> listMovDtos = new ArrayList<>();

        movimientoEntities.forEach(movimientoEntity -> {
            MovimientoDto mov = new MovimientoDto();
            mov.setEstado(movimientoEntity.isEstado());
            mov.setNumeroCuenta(movimientoEntity.getNumeroCuenta());
            mov.setValor(movimientoEntity.getMovimiento());
            mov.setSaldoInicial(movimientoEntity.getSaldo());
            mov.setTipoCuenta(movimientoEntity.getTipoCuenta());

            listMovDtos.add(mov);
        });
        return listMovDtos;
    }

    public List<String> transformListEntityToListCuentas(List<CuentaEntity> cuentaEntityList) {
        List<String> cuentasList = new ArrayList<>();

        cuentaEntityList.forEach(cuentaEntity ->
                cuentasList.add(cuentaEntity.getNumeroCuenta()));

        return cuentasList;
    }

    public List<MovimientoHistoricoDto> transformMovHistoricoDto(List<MovimientoEntity> movimientoEntityList) {
        List<MovimientoHistoricoDto> movimientoHistoricoDtos = new ArrayList<>();

        movimientoEntityList.forEach(movimientoEntity -> {
            MovimientoHistoricoDto mov = new MovimientoHistoricoDto();

            mov.setFecha(movimientoEntity.getFecha());
            //mov.setCliente(cliente);
            mov.setNumeroCuenta(movimientoEntity.getNumeroCuenta());
            mov.setTipoCuenta(movimientoEntity.getTipoCuenta());
            mov.setSaldoInicial(movimientoEntity.getSaldo());
            mov.setEstado(movimientoEntity.isEstado());
            mov.setMovimiento(movimientoEntity.getMovimiento());
            mov.setSaldoDisponible(movimientoEntity.getSaldo() + movimientoEntity.getMovimiento());

            movimientoHistoricoDtos.add(mov);
        });

        return movimientoHistoricoDtos;
    }

}
