package com.softka.demo.repository;

import com.softka.demo.entity.ClienteEntity;
import com.softka.demo.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query(value = "SELECT * FROM clientes where cliente_id = :clienteId", nativeQuery = true)
    ClienteEntity consultarCliente(@Param("clienteId") String clienteId);

    @Query(value = "UDPATE clientes SET cliente_id = :clienteId, contrasena = :contrasena, estado = :estado where cliente_id = :clienteId", nativeQuery = true)
    ClienteEntity actualizarCliente(@Param("clienteId") String clienteId, @Param("contrasena") String contrasena, @Param("estado") boolean estado);

    @Query(value = "UDPATE clientes SET estado = :false where cliente_id = :clienteId", nativeQuery = true)
    ClienteEntity eliminarCliente(@Param("clienteId") String clienteId);

}
