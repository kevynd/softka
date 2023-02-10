package com.softka.demo.service.cuenta;

import com.softka.demo.dto.CuentaDto;
import com.softka.demo.entity.CuentaEntity;
import com.softka.demo.repository.CuentaEntityRepository;
import com.softka.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {
    private final CuentaEntityRepository cuentaEntityRepository;
    private final ClienteRepository clienteRepository;

    public CuentaServiceImpl(CuentaEntityRepository cuentaEntityRepository,
                             ClienteRepository clienteRepository) {
        this.cuentaEntityRepository = cuentaEntityRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public CuentaEntity consultarCuenta(String numeroCuenta) {

        return cuentaEntityRepository.findByNumCuenta(numeroCuenta);
    }

    @Override
    public CuentaDto crearCuenta(CuentaDto cuentaDto) {
        CuentaEntity cuentaEntity = new CuentaEntity();

        //TODO validar que el usuario de la cuenta no tenga una cuenta del mismo tipo que se quiere crear

        cuentaEntity.setNumeroCuenta(cuentaDto.getNumeroCuenta());
        cuentaEntity.setTipoCuenta(cuentaDto.getTipoCuenta());
        cuentaEntity.setSaldoInicial(cuentaDto.getSaldoInicial());
        cuentaEntity.setEstado(cuentaDto.isEstado());
        cuentaEntity.setCliente(cuentaDto.getIdentificador());

        cuentaEntityRepository.save(cuentaEntity);
        return cuentaDto;
    }

    @Override
    public String eliminarCuenta(String numero) {
        return cuentaEntityRepository.eliminarCuenta(numero);
    }

    @Override
    public String actualizarCuenta(String numero, boolean estado) {
        return cuentaEntityRepository.actualizarCuenta(numero, estado);
    }
}
