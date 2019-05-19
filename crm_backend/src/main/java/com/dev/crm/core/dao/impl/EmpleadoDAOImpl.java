package com.dev.crm.core.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dev.crm.core.base.dao.impl.BaseDAOHibernateImpl;
import com.dev.crm.core.dao.EmpleadoDAO;
import com.dev.crm.core.model.entity.Empleado;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Repository("empleadoDAO")
public class EmpleadoDAOImpl extends BaseDAOHibernateImpl implements EmpleadoDAO {

	@Override
	public void spInsercionEmpleado(Empleado e) {
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createStoredProcedureQuery(Constantes.SP_INSERCION_EMPLEADO, Empleado.class);
			storeProcedure.registerStoredProcedureParameter("COD_DOC", String.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_ACT", Boolean.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_CAR", String.class, ParameterMode.IN);
			storeProcedure.setParameter("COD_DOC", e.getDocumentoPersonaEmpleado());
			storeProcedure.setParameter("COD_ACT", e.getEstado());
			storeProcedure.setParameter("COD_CAR", e.getCargo().getCodigoCargo());
			storeProcedure.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void spActualizarEmpleado(Empleado e) {
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createStoredProcedureQuery(Constantes.SP_ACTUALIZAR_EMPLEADO, Empleado.class);
			storeProcedure.registerStoredProcedureParameter("COD_DOC", String.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_EMP", BigDecimal.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_CAR", String.class, ParameterMode.IN);
			storeProcedure.setParameter("COD_DOC", e.getDocumentoPersonaEmpleado());
			storeProcedure.setParameter("COD_EMP", e.getCodigoEmpleado());
			storeProcedure.setParameter("COD_CAR", e.getCargo().getCodigoCargo());
			storeProcedure.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Empleado getByDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		
		Empleado empleado = null;
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
			Root<Empleado> e = cq.from(Empleado.class);
			ParameterExpression<String> p = cb.parameter(String.class);
			cq.select(e).where(cb.equal(e.get("documentoPersonaEmpleado"), p));
			TypedQuery<Empleado> query = em.createQuery(cq);
			query.setParameter(p, documentoPersonaEmpleado);
			
			try {
				empleado = query.getSingleResult();
				if(GenericUtil.isNotNull(empleado)) {
					return empleado;
				}
			}
			catch(NoResultException ex) {
				if(GenericUtil.isNull(empleado)) {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isEmpleadoPresent(String documentoPersonaEmpleado) {
		
		Empleado empleado = getByDocumentoPersonaEmpleado(documentoPersonaEmpleado);
		if(GenericUtil.isNull(empleado)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Empleado> getActiveListEmpleados() {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
			Root<Empleado> e = cq.from(Empleado.class);
			ParameterExpression<Boolean> p = cb.parameter(Boolean.class);
			cq.select(e).where(cb.equal(e.get("estado"), p));
			TypedQuery<Empleado> query = em.createQuery(cq);
			query.setParameter(p, Constantes.HABILITADO);
			empleados = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public void disabledEmpleado(Empleado e) {
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createStoredProcedureQuery(Constantes.SP_ACT_DES_EMPLEADO, Empleado.class);
			storeProcedure.registerStoredProcedureParameter("COD_DOC", String.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_EMP", BigDecimal.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_CAR", String.class, ParameterMode.IN);
			storeProcedure.setParameter("COD_DOC", e.getDocumentoPersonaEmpleado());
			storeProcedure.setParameter("COD_EMP", e.getCodigoEmpleado());
			storeProcedure.setParameter("COD_CAR", e.getCargo().getCodigoCargo());
			storeProcedure.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void enabledEmpleado(Empleado e) {
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createStoredProcedureQuery(Constantes.SP_ACT_DES_EMPLEADO, Empleado.class);
			storeProcedure.registerStoredProcedureParameter("COD_DOC", String.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_EMP", BigDecimal.class, ParameterMode.IN);
			storeProcedure.registerStoredProcedureParameter("COD_CAR", String.class, ParameterMode.IN);
			storeProcedure.setParameter("COD_DOC", e.getDocumentoPersonaEmpleado());
			storeProcedure.setParameter("COD_EMP", e.getCodigoEmpleado());
			storeProcedure.setParameter("COD_CAR", e.getCargo().getCodigoCargo());
			storeProcedure.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> spListarPersonaEmpleado(String creadoPor) {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createNamedStoredProcedureQuery("listarPersonaEmpleado");
			storeProcedure.setParameter("COD_USU", creadoPor);
			storeProcedure.execute();
			empleados = storeProcedure.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public Long totalRegistrosEmpleado() {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT COUNT(e) FROM Empleado e");
			Query query = em.createQuery(builder.toString());
			
			try {
				
				return (Long) query.getSingleResult();
			}
			catch(Exception e) {
				return StringUtil.parseLongNull("0");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
