package com.prueba.prueba.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.dto.UsuariosDto;
import com.prueba.prueba.usuarios.infrastructure.IUsuariosService;

@RestController
@RequestMapping("/User")
public class UsuariosController {

    private ResponsDto responsDto = null;

    @Autowired
    private IUsuariosService iUsuariosService;

    // Servicio rest para la creacion de un usuario
    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponsDto create(@RequestBody UsuariosDto usuariosDto) {
        try {
            return iUsuariosService.createUser(usuariosDto);
        } catch (Exception e) {
            e.getMessage();
            return responsDto = new ResponsDto("Error", "400", false);
        }

    }

    // Servicio rest para la modificacion de un usuario
    @PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponsDto update(@RequestBody UsuariosDto usuariosDto) {
        try {
            return iUsuariosService.updateUser(usuariosDto);
        } catch (Exception e) {
            e.getMessage();
            return responsDto = new ResponsDto("Error", "400", false);
        }
    }
    
    // Servicio rest para la eliminacion de un usuario
    @DeleteMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponsDto delete(@RequestBody UsuariosDto usuariosDto) {
        try {
            return iUsuariosService.deleteUser(usuariosDto);
        } catch (Exception e) {
            e.getMessage();
            return responsDto = new ResponsDto("Error", "400", false);
        }

    }

}
