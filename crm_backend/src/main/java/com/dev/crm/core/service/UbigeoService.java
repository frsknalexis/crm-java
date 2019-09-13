package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.UbigeoResultViewModel;
import com.dev.crm.core.model.entity.Ubigeo;

public interface UbigeoService {

	List<Ubigeo> findAll();
	
	List<Ubigeo> findByNombreUbigeo(String termino);
	
	List<UbigeoResultViewModel> listarUbigeo();
}
