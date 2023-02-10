package com.softka.demo.controller;



import com.softka.demo.dto.ClienteDto;
import com.softka.demo.dto.UsuarioDto;
import com.softka.demo.service.cliente.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/consultar")
    public ResponseEntity<UsuarioDto> consultarCliente(@RequestParam String clienteId) {

        return ResponseEntity.ok(clienteService.consultarCliente(clienteId));
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody() @Valid ClienteDto clienteDto) {

        return ResponseEntity.ok(clienteService.crearCliente(clienteDto));
    }

    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> actualizarCliente(@RequestParam String clienteId,
                                                        @RequestParam String contrasena,
                                                        @RequestParam boolean estado) {

        return ResponseEntity.ok(clienteService.actualizarCliente(clienteId,contrasena,estado));
    }

    @DeleteMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDto> eliminarCliente(@RequestParam String clienteId) {

        return ResponseEntity.ok(clienteService.eliminarCliente(clienteId));
    }

}
