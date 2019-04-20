package com.dev.crm.core.dao;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaDAO extends BaseDAOHibernate {

	void spInsercionCuenta(DetalleCuenta detalleCuenta);
}
