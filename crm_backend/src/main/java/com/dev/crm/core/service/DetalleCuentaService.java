package com.dev.crm.core.service;

import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaService {

	String spInsercionCuentaInternet(DetalleCuenta detalleCuenta);
	
	String spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	Integer spContadorPendientesCable();
	
	Integer spContadorPendientesInternet();
	
	String spReprogramarInstalacionCable();
	
	String spReprogramarInstalacionInternet();
	
	String spRevalidandoFechaCable();
	
	String spRevalidandoFechaInternet();
}
