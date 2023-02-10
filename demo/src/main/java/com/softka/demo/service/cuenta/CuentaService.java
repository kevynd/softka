package com.softka.demo.service.cuenta;

import com.softka.demo.dto.CuentaDto;
import com.softka.demo.entity.CuentaEntity;

public interface CuentaService {

    CuentaEntity consultarCuenta(String numeroCuenta);
    CuentaDto crearCuenta(CuentaDto cuentaDto);

    String actualizarCuenta(String numero, boolean estado);

    String eliminarCuenta(String numero);

}
