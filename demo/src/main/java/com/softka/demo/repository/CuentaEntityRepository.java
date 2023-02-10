package com.softka.demo.repository;

import com.softka.demo.entity.CuentaEntity;
import org.hibernate.sql.ast.tree.insert.Values;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CuentaEntityRepository extends JpaRepository<CuentaEntity, Long> {

    @Query(value = "SELECT * FROM cuentas where numero_cuenta = :numero", nativeQuery = true)
    CuentaEntity findByNumCuenta(@Param("numero") String numeroCuenta);

    @Query(value = "SELECT * FROM cuentas where cliente = :clienteId", nativeQuery = true)
    List<CuentaEntity> buscarCuentaUsuario(@Param("clienteId") String cleinteId);

    @Query(value = "UPDATE cuentas set estado = :estado where numero_cuenta = :numero returning numero_cuenta", nativeQuery = true)
    String actualizarCuenta(@Param("numero") String numero, @Param("estado") boolean estado);

    @Query(value = "UPDATE cuentas set estado = false where numero_cuenta = :numero returning numero_cuenta", nativeQuery = true)
    String eliminarCuenta(@Param("numero") String numero);

    @Query(value = "UPDATE cuentas set saldo_inicial = :saldo where numero_cuenta = :numero returning numero_cuenta", nativeQuery = true)
    String actualizarSaldo(@Param("numero") String numeroCuenta, @Param("saldo") float saldo);
}