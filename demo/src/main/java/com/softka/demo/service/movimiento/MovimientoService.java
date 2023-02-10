package com.softka.demo.service.movimiento;

import com.softka.demo.dto.MovimientoDto;
import com.softka.demo.dto.MovimientoHistoricoDto;
import com.softka.demo.dto.ResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoService {

    ResponseDto<List<MovimientoDto>> consultarMovimiento(String numero);

    ResponseDto<List<MovimientoHistoricoDto>> consultarMovUsuarioFecha(LocalDate fechaInicio, LocalDate fechaFin, String identificador);
    ResponseDto<MovimientoDto> crearMovimiento(MovimientoDto movimientoDto);

    ResponseDto<String> actualizarMovimiento(String numero, boolean estado);

    ResponseDto<String> eliminarMovimiento(String numero);
}
