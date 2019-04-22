package com.dev.crm.core.dao;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaDAO extends BaseDAOHibernate {

	String spInsercionCuentaInternet(DetalleCuenta detalleCuenta);
	
	String spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	void spReprogramarInstalacionCable();
	
	void spReprogramarInstalacionInternet();
	
	void spRevalidandoFechaCable();
	
	void spRevalidandoFechaInternet();
}
