package com.prueba.prueba.cuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.cuentas.infrastructure.ICuentasService;
import com.prueba.prueba.cuentas.infrastructure.impl.CuentasServiceImpl;
import com.prueba.prueba.dto.CuentasDto;
import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.entity.Cuenta;



@RestController
@RequestMapping("/Product")
public class CuentasController {

    private ResponsDto responsDto = null;

    @Autowired
    private ICuentasService iCuentasService;

    @Autowired
    private CuentasServiceImpl cuentasServiceImpl;

// servicio rest para crear un producto anexado a un usuario de la entidad
    @PostMapping(value = "/createProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponsDto create(@RequestBody CuentasDto cuentasDto) {
        try {
            return iCuentasService.createProduct(cuentasDto);
        } catch (Exception e) {
            e.getMessage();
            return responsDto = new ResponsDto("Error", "400", false);
        }
    

}

//Servicio rest para cambiar el estado de la cuenta
@PutMapping(value = "/updateState", produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody ResponsDto updateState(@RequestBody CuentasDto cuentasDto) {
    try {
        Cuenta cuentaTem = cuentasDto.getCuenta();
        return cuentasServiceImpl.estadoCuenta(cuentaTem.getUsuario(), cuentaTem.getNumeroCuenta(), cuentaTem.getEstado());
    } catch (Exception e) {
        e.getMessage();
        return responsDto = new ResponsDto("Error", "400", false);
    }
}

  @GetMapping( value = "/estado/{numeroCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponsDto cuntaState(@PathVariable String numeroCuenta) {
        try {
            
            return cuentasServiceImpl.estadoProcuto(numeroCuenta);
        } catch (Exception e) {
            e.getMessage();
            return responsDto = new ResponsDto("Error", "400", false);
        }
}
}
