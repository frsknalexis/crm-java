package com.dev.crm.core.service;

import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaService {

	void spInsercionCuentaInternet(DetalleCuenta detalleCuenta);
	
	void spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	void spReprogramarInstalacionCable();
	
	void spReprogramarInstalacionInternet();
	
	void spRevalidandoFechaCable();
	
	void spRevalidandoFechaInternet();
}
