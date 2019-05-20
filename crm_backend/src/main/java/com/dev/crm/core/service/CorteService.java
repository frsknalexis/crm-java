package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.CorteInternetResultViewModel;

public interface CorteService {

	List<CorteInternetResultViewModel> spListarCorteInternet();
	
	void spUpdateServicioInternet(Integer codigoServicioInternet);
}
