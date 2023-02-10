package com.softka.demo.controller;

import com.softka.demo.dto.ClienteDto;
import com.softka.demo.dto.MovimientoDto;
import com.softka.demo.dto.MovimientoHistoricoDto;
import com.softka.demo.service.movimiento.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.softka.demo.dto.ResponseDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;

    @GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<List<MovimientoDto>>> consultarMovimiento(@RequestParam() String numero) {

        return ResponseEntity.ok(movimientoService.consultarMovimiento(numero));
    }

    @GetMapping(value = "/consultar/usuario_fecha", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<List<MovimientoHistoricoDto>>> consultarMovUsuarioFecha(@RequestParam() LocalDate fechaInicio,
                                                                                                @RequestParam() LocalDate fechaFin,
                                                                                                @RequestParam() String identificador) {

        return ResponseEntity.ok(movimientoService.consultarMovUsuarioFecha(fechaInicio, fechaFin, identificador));
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<MovimientoDto>> crearMovimiento(@RequestBody() @Valid MovimientoDto movimientoDto) {

        return ResponseEntity.ok(movimientoService.crearMovimiento(movimientoDto));
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<String>> actualizarMovimiento(@RequestParam() String numero, @RequestParam boolean estado) {

        return ResponseEntity.ok(movimientoService.actualizarMovimiento(numero, estado));
    }

    @DeleteMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<String>> eliminarMovimiento(@RequestParam() String numero) {

        return ResponseEntity.ok(movimientoService.eliminarMovimiento(numero));
    }
}
