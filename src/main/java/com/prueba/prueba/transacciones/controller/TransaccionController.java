package com.prueba.prueba.transacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.dto.TransaccionDto;
import com.prueba.prueba.transacciones.infrastucture.impl.TransaccionesServiceImpl;

@RestController
@RequestMapping("/Transaction")
public class TransaccionController {

    private ResponsDto responsDto = null;

    @Autowired
    private TransaccionesServiceImpl transaccionesServiceImpl;

    // servicio rest para realizar un retiro
    @PostMapping(value = "/transactionWithdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponsDto serviceRetiro(@RequestBody TransaccionDto transaccionDto) {
        try {
            return transaccionesServiceImpl.serviceRetiro(transaccionDto);
        } catch (Exception e) {
            e.getMessage();
            return responsDto = new ResponsDto("Error", "400", false);
        }
    

}

   // servicio rest para realizar una consignacion
   @PostMapping(value = "/transactionConsignment", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsDto serviceConsignment(@RequestBody TransaccionDto transaccionDto) {
       try {
           return transaccionesServiceImpl.serviceConsignacion(transaccionDto);
       } catch (Exception e) {
           e.getMessage();
           return responsDto = new ResponsDto("Error", "400", false);
       }
   

}

   // servicio rest para realizar una transferencias entre cuentas
   @PostMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsDto serviceTransaction(@RequestBody TransaccionDto transaccionDto) {
       try {
           return transaccionesServiceImpl.serviceTransaccion(transaccionDto);
       } catch (Exception e) {
           e.getMessage();
           return responsDto = new ResponsDto("Error", "400", false);
       }
   

}

}
