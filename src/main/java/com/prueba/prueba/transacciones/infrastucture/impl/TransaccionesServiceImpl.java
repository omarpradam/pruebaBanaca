package com.prueba.prueba.transacciones.infrastucture.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.dto.TransaccionDto;
import com.prueba.prueba.entity.Cuenta;
import com.prueba.prueba.entity.Movimientos;
import com.prueba.prueba.repository.CuentasRepository;
import com.prueba.prueba.repository.service.impl.MovimientosRepositoryServiceImpl;
import com.prueba.prueba.transacciones.infrastucture.ITransaccionesService;

@Service("TransaccionesServiceImpl")
public class TransaccionesServiceImpl implements ITransaccionesService {

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private MovimientosRepositoryServiceImpl movimientosRepositoryServiceImpl;

    Date day = new Date();

    Movimientos movimientoTem = new Movimientos();

    public ResponsDto serviceRetiro(TransaccionDto transaccionDto) {

        Cuenta cuentaTem = cuentasRepository.findByUserCuenta(transaccionDto.getNumeroDocumento(),
                transaccionDto.getNumeroCuentaSalida());

        if (cuentaTem.getNumeroCuenta() == null) {

            return new ResponsDto("Cuenta no encontrada", "400", null);

        }
        Float monto = Float.parseFloat(transaccionDto.getMonto());

        Float saldo = cuentaTem.getSaldo();

        Float saldoActual = cuentaTem.getSaldo() - monto;

        cuentaTem.setSaldo(saldoActual <= 0 ? 0 : saldoActual);
        cuentasRepository.save(cuentaTem);

        movimientoTem.setFechaMovimiento(day);
        movimientoTem.setMonto(saldo.toString());
        movimientoTem.setNumeroCuenta(transaccionDto.getNumeroCuentaSalida());
        movimientoTem.setTipoMovimiento("RETIRO");
        movimientoTem.setNumeroDocumento(transaccionDto.getNumeroDocumento());
        movimientoTem.setSaldoActual(saldoActual.toString());
        movimientosRepositoryServiceImpl.save(movimientoTem);

        return new ResponsDto("Retiro Exitoso", "200", movimientoTem);
    }

    public ResponsDto serviceConsignacion(TransaccionDto transaccionDto) {

        Cuenta cuentaTem = cuentasRepository.findByUserCuenta(transaccionDto.getNumeroDocumento(),
                transaccionDto.getNumeroCuentaDestino());

        if (cuentaTem.getNumeroCuenta() == null)
            return new ResponsDto("Cuenta no encontrada", "400", null);

        Float monto = Float.parseFloat(transaccionDto.getMonto());

        Float saldo = cuentaTem.getSaldo();

        Float saldoActual = cuentaTem.getSaldo() + monto;

        cuentaTem.setSaldo(saldoActual <= 0 ? 0 : saldoActual);
        cuentasRepository.save(cuentaTem);

        movimientoTem.setFechaMovimiento(day);
        movimientoTem.setMonto(saldo.toString());
        movimientoTem.setNumeroCuenta(transaccionDto.getNumeroCuentaDestino());
        movimientoTem.setTipoMovimiento("CONSIGNACION");
        movimientoTem.setNumeroDocumento(transaccionDto.getNumeroDocumento());
        movimientoTem.setSaldoActual(saldoActual.toString());
        movimientosRepositoryServiceImpl.save(movimientoTem);

        return new ResponsDto("Consignacion Exitosa", "200", movimientoTem);
    }

    public ResponsDto serviceTransaccion(TransaccionDto transaccionDto) {

        Movimientos movimientoTemTrans = new Movimientos();
        //se validan si las cuentas enviadas existen en la BD
        Cuenta cuentaTem = cuentasRepository.findByUserCuenta(transaccionDto.getNumeroDocumento(),
                transaccionDto.getNumeroCuentaSalida());

        if (cuentaTem.getNumeroCuenta() == null)
            return new ResponsDto("Cuenta no encontrada", "400", null);

        Cuenta cuentaDestino = cuentasRepository.findByNumeroCuenta(transaccionDto.getNumeroCuentaDestino());

        if (cuentaDestino.getNumeroCuenta() == null)
            return new ResponsDto("Cuenta no encontrada", "400", null);

        serviceConsignacionTransferencia(transaccionDto);

        Float monto = Float.parseFloat(transaccionDto.getMonto());

        Float saldo = cuentaTem.getSaldo();

        Float saldoActual = cuentaTem.getSaldo() - monto;

        cuentaTem.setSaldo(saldoActual <= 0 ? 0 : saldoActual);
        cuentasRepository.save(cuentaTem);

        movimientoTemTrans.setFechaMovimiento(day);
        movimientoTemTrans.setMonto(saldo.toString());
        movimientoTemTrans.setNumeroCuenta(transaccionDto.getNumeroCuentaDestino());
        movimientoTemTrans.setTipoMovimiento("TRANSACCION");
        movimientoTemTrans.setNumeroDocumento(transaccionDto.getNumeroDocumento());
        movimientoTemTrans.setSaldoActual(saldoActual.toString());
        movimientosRepositoryServiceImpl.save(movimientoTemTrans);


        return new ResponsDto("Transderencia Exitosa", "200", movimientoTemTrans);
    }

    public ResponsDto serviceConsignacionTransferencia(TransaccionDto transaccionDto) {

        Movimientos movimientoTemCo = new Movimientos();
        Cuenta cuentaDestino = cuentasRepository.findByNumeroCuenta(transaccionDto.getNumeroCuentaDestino());

        if (cuentaDestino.getNumeroCuenta() == null)
            return new ResponsDto("Cuenta no encontrada", "400", null);


        Float monto = Float.parseFloat(transaccionDto.getMonto());

        Float saldo = cuentaDestino.getSaldo();

        Float saldoActual = cuentaDestino.getSaldo() + monto;

        cuentaDestino.setSaldo(saldoActual <= 0 ? 0 : saldoActual);
        cuentasRepository.save(cuentaDestino);

        movimientoTemCo.setFechaMovimiento(day);
        movimientoTemCo.setMonto(saldo.toString());
        movimientoTemCo.setNumeroCuenta(transaccionDto.getNumeroCuentaDestino());
        movimientoTemCo.setTipoMovimiento("CONSIGNACION");
        movimientoTemCo.setNumeroDocumento(transaccionDto.getNumeroDocumento());
        movimientoTemCo.setSaldoActual(saldoActual.toString());
        movimientosRepositoryServiceImpl.save(movimientoTemCo);

        return new ResponsDto("Consignacion Exitosa", "200", movimientoTemCo);
    }

}
