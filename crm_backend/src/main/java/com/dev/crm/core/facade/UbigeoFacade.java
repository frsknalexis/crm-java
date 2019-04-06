package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.UbigeoDTO;

public interface UbigeoFacade {

	List<UbigeoDTO> findAll();
	
	List<UbigeoDTO> findByNombreUbigeo(String termino);
}
