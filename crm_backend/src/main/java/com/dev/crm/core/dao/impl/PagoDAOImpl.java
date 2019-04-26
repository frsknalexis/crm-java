package com.dev.crm.core.dao.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.dev.crm.core.base.dao.impl.BaseDAOHibernateImpl;
import com.dev.crm.core.dao.PagoDAO;
import com.dev.crm.core.model.entity.Pago;
import com.dev.crm.core.util.Constantes;

@Repository("pagoDAO")
public class PagoDAOImpl extends BaseDAOHibernateImpl implements PagoDAO {

	@Override
	public String spPagoServicio(Pago p) {
		
		try {
			
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(Constantes.SP_PAGO_SERVICIO);
			storedProcedure.registerStoredProcedureParameter("CDOCOMP", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CODDOC", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DNI_RUC", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PAGO", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);
			storedProcedure.execute();
			String result = (String) storedProcedure.getOutputParameterValue("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
