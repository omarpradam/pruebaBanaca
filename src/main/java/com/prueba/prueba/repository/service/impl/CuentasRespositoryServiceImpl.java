package com.prueba.prueba.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.entity.Cuenta;
import com.prueba.prueba.repository.CuentasRepository;
import com.prueba.prueba.repository.service.CuentasRepositoryService;

@Service("CuentasRespositoryServiceImpl")
public class CuentasRespositoryServiceImpl implements CuentasRepositoryService {

    @Autowired
    private CuentasRepository cuentasRepository;

    @Override
    public Cuenta save(Cuenta cuenta) {
        
        return cuentasRepository.save(cuenta);
    }

    @Override
    public Cuenta searchByDocument(String document) {
        Cuenta cuentaTem = cuentasRepository.findByUsuario(document);
        return cuentaTem;
    }

}
