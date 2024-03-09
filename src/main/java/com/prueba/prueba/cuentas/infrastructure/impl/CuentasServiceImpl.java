package com.prueba.prueba.cuentas.infrastructure.impl;

import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.cuentas.infrastructure.ICuentasService;
import com.prueba.prueba.dto.CuentasDto;
import com.prueba.prueba.dto.EstadoDto;
import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.entity.Cuenta;
import com.prueba.prueba.entity.Usuarios;
import com.prueba.prueba.repository.CuentasRepository;
import com.prueba.prueba.repository.service.impl.CuentasRespositoryServiceImpl;
import com.prueba.prueba.repository.service.impl.UsuariosRepositoryServiceImpl;

@Service("CuentasServiceImpl")
public class CuentasServiceImpl implements ICuentasService {

    @Autowired
    private CuentasRespositoryServiceImpl cuentasRespositoryServiceImpl;

    @Autowired
    private UsuariosRepositoryServiceImpl usuariosRepositoryServiceImpl;

    @Autowired
    private CuentasRepository cuentasRepository;
    Date day = new Date();

    // servicio para la creancion de una cuenta
    @Override
    public ResponsDto createProduct(CuentasDto cuentasDto) throws Exception {

        Cuenta cuenta = cuentasDto.getCuenta();

        Usuarios userTem = usuariosRepositoryServiceImpl.searchByDocument(cuenta.getUsuario());

        String numerosAleatorios = generarNumerosAleatorios();

        if (userTem == null) {

            return new ResponsDto("No se puede crear por que el usuario no existe en la entidad", "400", cuentasDto);

        }

        // set datos de cuenta
        cuenta.setSaldo(0f);
        cuenta.setFechaCreacion(day);
        cuenta.setFechaModificacion(day);
        cuenta.setEstado("Activo");

        if (cuenta.getTipoCuenta().equals("CORRIENTE")) {

            String numeroCuenta = agregarPrefijo(numerosAleatorios, TipoCuenta.CORRIENTE);

            cuenta.setNumeroCuenta(numeroCuenta);
            cuenta.setTipoCuenta("CORRIENTE");

        } else if (cuenta.getTipoCuenta().equals("AHORROS")) {

            String numeroCuenta = agregarPrefijo(numerosAleatorios, TipoCuenta.AHORRO);

            cuenta.setNumeroCuenta(numeroCuenta);
            cuenta.setTipoCuenta("AHORROS");
        } else {
            return new ResponsDto("Producto no encontrado solo se acepta CORRIENTE o AHORROS", "400", cuentasDto);
        }

        cuentasRespositoryServiceImpl.save(cuenta);

        return new ResponsDto("Producto cuenta ahorro creado con exito", "200", cuentasDto);

    }

    @Override
    public ResponsDto updateProduct(CuentasDto cuentasDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    // servicio para cambiar el estado de la cuenta
    public ResponsDto estadoCuenta(String usuario, String numeroCuenta, String estado) {

        Cuenta cuentaTem = cuentasRepository.findByUserCuenta(usuario, numeroCuenta);

        if (cuentaTem.getNumeroCuenta() == null || cuentaTem.getNumeroCuenta().isEmpty()) {

            return new ResponsDto("los datos enviados no se encontraron", "400", cuentaTem);
        }

        cuentaTem.setFechaModificacion(day);
        Boolean estadoCu = validarEstadoCuenta(estado);

        if (estadoCu != true) {
            return new ResponsDto("No se encuentra el estado seleccionado", "400", cuentaTem);
        }

        if (estado.equals("Cancelada")) {

           if(cuentaTem.getSaldo()==0f){
            cuentaTem.setEstado(estado);
            cuentasRespositoryServiceImpl.save(cuentaTem);

            return new ResponsDto("Estado de la cuenta Actualizado", "200", cuentaTem);
     } else{

        return new ResponsDto("No se puede cancelar la cuenta ya que dispone de un saldo ", "200", cuentaTem);

     }
            
        }
        cuentaTem.setEstado(estado);

        cuentasRespositoryServiceImpl.save(cuentaTem);

        return new ResponsDto("Estado de la cuenta Actualizado", "200", cuentaTem);
    }

    // Servicio para generar un numero de 8 digitos randon
    public static String generarNumerosAleatorios() {
        Random random = new Random();
        StringBuilder numeros = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            numeros.append(random.nextInt(10));
        }

        return numeros.toString();
    }

    // Servicio para concatenar el tipo de cuneta con el numero randon
    public static String agregarPrefijo(String numeros, TipoCuenta tipoCuenta) {
        if (tipoCuenta == TipoCuenta.AHORRO) {
            return "53" + numeros;
        } else {
            return "33" + numeros;
        }
    }

    public enum TipoCuenta {
        AHORRO,
        CORRIENTE
    }

    // Servicio para validar si el estado es "activa", "inactiva" o "cancelada"
    public static boolean validarEstadoCuenta(String estado) {

        String regex = "^(Activa|Inactiva|Cancelada)$";
        return Pattern.matches(regex, estado);
    }

    public ResponsDto estadoProcuto(String numeroCuenta){

        EstadoDto estadoTem = new EstadoDto();

        Cuenta cuentaTem = cuentasRepository.findByNumeroCuenta(numeroCuenta);
        if(cuentaTem.getEstado() == null)
        return new ResponsDto("Producto no encontrado", "400", estadoTem);

        estadoTem.setEstado(cuentaTem.getEstado());
        estadoTem.setNumeroCuenta(cuentaTem.getNumeroCuenta());
        estadoTem.setSaldo(cuentaTem.getSaldo().toString());

        return new ResponsDto("El estado de su producto es", "200", estadoTem);
    }

}
