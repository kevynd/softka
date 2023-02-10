package com.softka.demo.controller;


import com.softka.demo.dto.ClienteDto;
import com.softka.demo.dto.CuentaDto;
import com.softka.demo.entity.CuentaEntity;
import com.softka.demo.service.cuenta.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentaEntity> consultarCuenta(@RequestParam String numeroCuenta) {

        return ResponseEntity.ok(cuentaService.consultarCuenta(numeroCuenta));
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentaDto> crearCuenta(@RequestBody() @Valid CuentaDto cuentaDto) {

        return ResponseEntity.ok(cuentaService.crearCuenta(cuentaDto));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearCuenta(@RequestParam() String numero,
                                                 @RequestParam() boolean estado) {

        return ResponseEntity.ok(cuentaService.actualizarCuenta(numero, estado));
    }

    @DeleteMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarCuenta(@RequestParam() String numero) {

        return ResponseEntity.ok(cuentaService.eliminarCuenta(numero));
    }
}
