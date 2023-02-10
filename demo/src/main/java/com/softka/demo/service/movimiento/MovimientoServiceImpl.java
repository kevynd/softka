package com.softka.demo.service.movimiento;


import com.softka.demo.controller.mapper.MapperToEntity;
import com.softka.demo.dto.MovimientoDto;
import com.softka.demo.dto.MovimientoHistoricoDto;
import com.softka.demo.dto.ResponseDto;
import com.softka.demo.entity.CuentaEntity;
import com.softka.demo.entity.MovimientoEntity;
import com.softka.demo.repository.CuentaEntityRepository;
import com.softka.demo.repository.MovimientoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService{
    @Autowired
    private MovimientoEntityRepository movimientoEntityRepository;
    @Autowired
    private CuentaEntityRepository cuentaEntityRepository;

    @Override
    public ResponseDto<List<MovimientoDto>> consultarMovimiento(String numero) {
        List<MovimientoEntity> movimientoEntities = new ArrayList<>();
        List<MovimientoDto> movimientoDtoList = new ArrayList<>();
        MapperToEntity mapperToEntity = new MapperToEntity();

        movimientoEntities = movimientoEntityRepository.consultarMovimiento(numero);

        ResponseDto<List<MovimientoDto>> response = new ResponseDto<>();
        response.setData(mapperToEntity.transformListMovEntityToListMovDtos(movimientoEntities));
        response.addMessage("Consulta exitosa");

        return response;
    }

    @Override
    public ResponseDto<List<MovimientoHistoricoDto>> consultarMovUsuarioFecha(LocalDate fechaInicio, LocalDate fechaFin, String identificador) {
        ResponseDto<List<MovimientoHistoricoDto>> response = new ResponseDto<>();
        List<CuentaEntity> cuentaEntityList = new ArrayList<>();
        List<String> cuentasList = new ArrayList<>();
        MapperToEntity mapperToEntity = new MapperToEntity();

        cuentaEntityList = cuentaEntityRepository.buscarCuentaUsuario(identificador);

        cuentasList = mapperToEntity.transformListEntityToListCuentas(cuentaEntityList);
        List<MovimientoEntity> resMov = movimientoEntityRepository.consultarMovCuentaFecha(fechaInicio, fechaFin,cuentasList);

        response.setData(mapperToEntity.transformMovHistoricoDto(resMov));
        response.addMessage("Consulta exitosa");

        return response;
    }

    @Override
    public ResponseDto<MovimientoDto> crearMovimiento(MovimientoDto movimientoDto) {
        MovimientoEntity movimientoEntity;
        MapperToEntity mapperToEntity = new MapperToEntity();

        CuentaEntity cuentaEntity = cuentaEntityRepository.findByNumCuenta(movimientoDto.getNumeroCuenta());
        if (movimientoDto.getValor() < 0) {
            if((movimientoDto.getValor() + cuentaEntity.getSaldoInicial()) >= 0 ) {
                movimientoEntity = mapperToEntity.transformMovEntity(movimientoDto);
                movimientoEntity.setSaldo(cuentaEntity.getSaldoInicial());
            } else {
                ResponseDto<MovimientoDto> response = new ResponseDto<>(movimientoDto);
                response.setData(movimientoDto);
                response.addMessage("Saldo insuficiente");
                return response;
            }
        } else {
            movimientoEntity = mapperToEntity.transformMovEntity(movimientoDto);
            movimientoEntity.setSaldo(cuentaEntity.getSaldoInicial());
        }

        movimientoEntityRepository.save(movimientoEntity);
        cuentaEntityRepository.actualizarSaldo(movimientoDto.getNumeroCuenta(), (cuentaEntity.getSaldoInicial() + movimientoDto.getValor()));

        ResponseDto<MovimientoDto> res = new ResponseDto<>();
        res.setData(movimientoDto);
        res.addMessage("Movimiento exitoso");
        return res;
    }

    @Override
    public ResponseDto<String> actualizarMovimiento(String numero, boolean estado) {
        ResponseDto<String> response = new ResponseDto<>();

        response.setData(movimientoEntityRepository.actualizarMovimiento(numero, estado));
        response.addMessage("Actualizado exitosamente");
        return response;
    }

    @Override
    public ResponseDto<String> eliminarMovimiento(String numero) {
        ResponseDto<String> response = new ResponseDto<>();

        response.setData(movimientoEntityRepository.eliminarMovimiento(numero));
        response.addMessage("Eliminado exitosamente");

        return response;
    }



}
