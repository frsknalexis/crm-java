package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.CargoDTO;

public interface CargoFacade {

	List<CargoDTO> findAll();
	
	List<CargoDTO> findByDescripcionCargo(String termino);
}
