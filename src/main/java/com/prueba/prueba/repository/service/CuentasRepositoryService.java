package com.prueba.prueba.repository.service;

import com.prueba.prueba.entity.Cuenta;

public interface CuentasRepositoryService {

    public Cuenta save(Cuenta cuenta);
	public Cuenta searchByDocument(String document);
}
