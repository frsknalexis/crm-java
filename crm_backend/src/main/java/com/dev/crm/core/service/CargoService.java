package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.model.entity.Cargo;

public interface CargoService {

	List<Cargo> findAll();
	
	List<Cargo> findByDescripcionCargo(String termino);
}
