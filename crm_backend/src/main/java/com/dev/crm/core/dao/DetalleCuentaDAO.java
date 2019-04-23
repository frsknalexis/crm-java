package com.dev.crm.core.dao;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaDAO extends BaseDAOHibernate {

	String spInsercionCuentaInternet(DetalleCuenta detalleCuenta);
	
	String spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	Integer spContadorPendientesCable();
	
	Integer spContadorPendientesInternet();
	
	String spReprogramarInstalacionCable();
	
	String spReprogramarInstalacionInternet();
	
	String spRevalidandoFechaCable();
	
	String spRevalidandoFechaInternet();
}
