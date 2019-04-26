package com.dev.crm.core.dao;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.Pago;

public interface PagoDAO extends BaseDAOHibernate {

	String spPagoServicio(Pago pago);
}
