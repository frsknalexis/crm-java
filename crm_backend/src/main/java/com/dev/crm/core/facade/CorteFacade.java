package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.CorteInternetResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface CorteFacade {

	List<CorteInternetResultViewModel> spListarCorteInternet();
	
	ResponseBaseOperation spUpdateServicioInternet(Integer codigoServicioInternet);
}
