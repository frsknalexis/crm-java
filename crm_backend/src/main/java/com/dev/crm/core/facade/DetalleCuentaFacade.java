package com.dev.crm.core.facade;

import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface DetalleCuentaFacade {

	ResponseBaseOperation spInsercionCuentaInternet(DetalleCuentaDTO detalleCuentaDTO);
	
	ResponseBaseOperation spInsercionCuentaCable(DetalleCuentaDTO detalleCuentaDTO);
	
	ResponseBaseOperation spReprogramarInstalacionCable();
	
	ResponseBaseOperation spReprogramarInstalacionInternet();
}
