package com.dev.crm.core.dao.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.dev.crm.core.base.dao.impl.BaseDAOHibernateImpl;
import com.dev.crm.core.dao.DetalleCuentaDAO;
import com.dev.crm.core.model.entity.DetalleCuenta;
import com.dev.crm.core.util.Constantes;

@Repository("detalleCuentaDAO")
public class DetalleCuentaDAOImpl extends BaseDAOHibernateImpl implements DetalleCuentaDAO {

	@Override
	public String spInsercionCuentaInternet(DetalleCuenta dC) {
		
		try {
			
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(Constantes.SP_INSERCION_CUENTA_INTERNET);
			storedProcedure.registerStoredProcedureParameter("COD_DOC", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("OBS", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);
			storedProcedure.setParameter("COD_DOC", dC.getDocumentoPersonaCliente());
			storedProcedure.setParameter("OBS", dC.getObservacionDetalleCuenta());
			storedProcedure.execute();
			String result = (String) storedProcedure.getOutputParameterValue("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spInsercionCuentaCable(DetalleCuenta dC) {
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createStoredProcedureQuery(Constantes.SP_INSERCION_CUENTA_CABLE);
			storeProcedure.registerStoredProcedureParameter("COD_DOC", String.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("OBS", String.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("MENSAJE", String.class, ParameterMode.OUT);
			storeProcedure.setParameter("COD_DOC", dC.getDocumentoPersonaCliente());
			storeProcedure.setParameter("OBS", dC.getObservacionDetalleCuenta());
			storeProcedure.execute();
			String result = (String) storeProcedure.getOutputParameterValue("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void spReprogramarInstalacionCable() {
		
		try {
			
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(Constantes.SP_REPROGRAMAR_INSTALACION_CABLE);
			storedProcedure.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spReprogramarInstalacionInternet() {
		
		try {
			
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(Constantes.SP_REPROGRAMAR_INSTALACION_INTERNET);
			storedProcedure.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spRevalidandoFechaCable() {
		
		try {
			
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(Constantes.SP_REVALIDANDO_FECHA_CABLE);
			storedProcedure.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spRevalidandoFechaInternet() {
		
		try {
			
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(Constantes.SP_REVALIDANDO_FECHA_INTERNET);
			storedProcedure.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
