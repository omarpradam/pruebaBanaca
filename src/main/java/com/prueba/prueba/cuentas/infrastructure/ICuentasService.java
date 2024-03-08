package com.prueba.prueba.cuentas.infrastructure;

import com.prueba.prueba.dto.CuentasDto;
import com.prueba.prueba.dto.ResponsDto;


public interface ICuentasService {

      public ResponsDto createProduct( CuentasDto cuentasDto) throws Exception;
	
	public ResponsDto updateProduct(CuentasDto cuentasDto) throws Exception;
}
