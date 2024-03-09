package com.prueba.prueba.usuarios.infrastructure.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.dto.ResponsDto;
import com.prueba.prueba.dto.UsuariosDto;
import com.prueba.prueba.entity.Cuenta;
import com.prueba.prueba.entity.Usuarios;
import com.prueba.prueba.repository.service.impl.CuentasRespositoryServiceImpl;
import com.prueba.prueba.repository.service.impl.UsuariosRepositoryServiceImpl;
import com.prueba.prueba.usuarios.infrastructure.IUsuariosService;

@Service("UsuariosServiceImpl")
public class UsuariosServiceImpl implements IUsuariosService {

    @Autowired
    private UsuariosRepositoryServiceImpl usuariosRepositoryServiceImpl;

    @Autowired
    private CuentasRespositoryServiceImpl cuentasRespositoryServiceImpl;

    @Override
    // servicio para la creacion de un usuario
    public ResponsDto createUser(UsuariosDto usuariosDto) throws Exception {

        Usuarios user = usuariosDto.getUsuarios();

        Date day = new Date();

        // metodo para obtener en ano de nacimiento
        Calendar cal = Calendar.getInstance();
        cal.setTime(user.getFechaNacimiento());
        Integer anio = cal.get(Calendar.YEAR);

        // metodo para obtener el ano de la fecha actual
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(day);
        Integer anio2 = cal.get(Calendar.YEAR);

        Integer edad = anio2 - anio;

        boolean esCorreoValido = validarCorreoElectronico(user.getCorreoElectronico());

        Usuarios userTem = usuariosRepositoryServiceImpl.searchByDocument(user.getNumeroIdentificacion());

        boolean validarNombre = validarLongitudNombreApellido(user.getNombres());

        boolean validarApellido = validarLongitudNombreApellido(user.getApellido());

        if (userTem != null) {

            return new ResponsDto("No se puede crear el usuario por que ya existe en BD", "400", usuariosDto);
        } else if (edad <= 17) {

            return new ResponsDto("No se puede crear el usuario ya que es menor de edad", "400", usuariosDto);

        } else if (esCorreoValido != true) {

            return new ResponsDto("Correo invalido", "400", usuariosDto);

        } else if (validarNombre != true) {

            return new ResponsDto("El nombre no tiene una longitud valida", "400", usuariosDto);

        } else if (validarApellido != true) {

            return new ResponsDto("El apellido no tiene una longitud valida", "400", usuariosDto);
        }
        user.setFechaCreacion(day);
        user.setFechaModificacion(day);
        usuariosRepositoryServiceImpl.save(user);

        return new ResponsDto("Usuario creado con exito", "200", usuariosDto);
    }

    // servicio para la modificacion de un usuario
    @Override
    public ResponsDto updateUser(UsuariosDto usuariosDto) throws Exception {

        Usuarios user = usuariosDto.getUsuarios();
        Date day = new Date();
        Usuarios userTem = usuariosRepositoryServiceImpl.searchByDocument(user.getNumeroIdentificacion());

        if (userTem == null) {
            return new ResponsDto("El usuario no existe en BD", "400", null);
        }

        userTem.setFechaModificacion(day);
        userTem.setApellido(user.getApellido());
        userTem.setCorreoElectronico(user.getCorreoElectronico());
        userTem.setFechaNacimiento(user.getFechaNacimiento());
        userTem.setNombres(user.getNombres());
        userTem.setTipoIdentificacion(user.getTipoIdentificacion());
        usuariosRepositoryServiceImpl.save(userTem);

        return new ResponsDto("Usuario modificado con exito", "200", usuariosDto);
    }

    // servicio para la eliminacion de un usuario
    @Override
    public ResponsDto deleteUser(UsuariosDto usuariosDto) throws Exception {

        Usuarios user = usuariosDto.getUsuarios();

        Usuarios userTem = usuariosRepositoryServiceImpl.searchByDocument(user.getNumeroIdentificacion());
        if (userTem == null) {
            return new ResponsDto("El usuario no existe en BD", "400", null);
        }

        Cuenta cuentaTem = cuentasRespositoryServiceImpl
                .searchByDocument(usuariosDto.getUsuarios().getNumeroIdentificacion());

        if (cuentaTem == null)
            return new ResponsDto("Usuario no puede ser eliminado ya que tiene una cuenta", "400",
                    usuariosDto);

        usuariosRepositoryServiceImpl.deleteUsuarios(userTem);

        return new ResponsDto("Usuario Eliminado con exito", "200", usuariosDto);
    }

    public static boolean validarCorreoElectronico(String correoElectronico) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);

        return matcher.matches();
    }

    public static boolean validarLongitudNombreApellido(String nombre) {
        String regex = "^.{2,}$";
        return nombre.matches(regex);
    }

}
