package com.prueba.prueba.repository.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.entity.Movimientos;
import com.prueba.prueba.repository.MovimientosRepository;
import com.prueba.prueba.repository.service.MovimientosReposotoryService;



@Service("MovimientosRepositoryServiceImpl")
public class MovimientosRepositoryServiceImpl  implements MovimientosReposotoryService{


    @Autowired
    private MovimientosRepository movimientosRepository;
    @Override
    public Movimientos save(Movimientos movimientos) {
        return movimientosRepository.save(movimientos);
    }

  

}
