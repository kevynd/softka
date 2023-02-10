package com.softka.demo.repository;

import com.softka.demo.dto.MovimientoDto;
import com.softka.demo.entity.CuentaEntity;
import com.softka.demo.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoEntityRepository extends JpaRepository<MovimientoEntity, Long> {


    @Query(value = "SELECT * FROM movimientos where numero_cuenta = :numero order by id", nativeQuery = true)
    List<MovimientoEntity> consultarMovimiento(@Param("numero") String numero);

    @Query(value = "UPDATE movimientos set estado = :estado where numero_cuenta = :numero returning estado", nativeQuery = true)
    String actualizarMovimiento(@Param("numero") String numero, @Param("estado") boolean estado);

    @Query(value = "UPDATE movimientos set estado = false where numero_cuenta = :numero returning estado", nativeQuery = true)
    String eliminarMovimiento(@Param("numero") String numero);

    @Query(value = "SELECT * FROM movimientos where fecha >= :fechaInicio and fecha <= :fechaFin and numero_cuenta in (:numero) order by id", nativeQuery = true)
    public List<MovimientoEntity> consultarMovCuentaFecha(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin, @Param("numero") List<String> numero);
}