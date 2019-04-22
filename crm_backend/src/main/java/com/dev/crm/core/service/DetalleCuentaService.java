package com.dev.crm.core.service;

import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaService {

	String spInsercionCuentaInternet(DetalleCuenta detalleCuenta);
	
	String spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	void spReprogramarInstalacionCable();
	
	void spReprogramarInstalacionInternet();
	
	void spRevalidandoFechaCable();
	
	void spRevalidandoFechaInternet();
}
