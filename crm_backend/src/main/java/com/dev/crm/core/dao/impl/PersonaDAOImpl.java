package com.dev.crm.core.dao.impl;

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
import com.dev.crm.core.dao.PersonaDAO;
import com.dev.crm.core.model.entity.Persona;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("personaDAO")
public class PersonaDAOImpl extends BaseDAOHibernateImpl implements PersonaDAO {

	@Override
	public List<Persona> findPersonasByCreadoPor(String creadoPor) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			CriteriaBuilder cb =em.getCriteriaBuilder();
			CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
			Root<Persona> persona = cq.from(Persona.class);
			ParameterExpression<String> p = cb.parameter(String.class);
			cq.select(persona).where(cb.equal(persona.get("creadoPor"), p));
			TypedQuery<Persona> query = em.createQuery(cq);
			query.setParameter(p, creadoPor);
			personas = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public void disabledPersona(Persona p) {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(" UPDATE Persona p SET ");
			builder.append(" p.habilitado = : habilitado ");
			builder.append(" , p.modificadoPor = :modificadoPor ");
			builder.append(" , p.fechaModificacion = :fechaModificacion ");
			builder.append(" , p.fechaDesactivacion = :fechaDesactivacion ");
			builder.append(" , p.ipUsuario = :ipUsuario ");
			builder.append(" , p.usuarioMaquina = :usuarioMaquina ");
			builder.append(" WHERE u.documentoPersona = :documentoPersona");
			Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
			query.setParameter("documentoPersona", p.getDocumentoPersona());
			query.setParameter("habilitado", p.getHabilitado());
			query.setParameter("modificadoPor", p.getModificadoPor());
			query.setParameter("fechaModificacion", p.getFechaModificacion());
			query.setParameter("fechaDesactivacion", p.getFechaDesactivacion());
			query.setParameter("ipUsuario", p.getIpUsuario());
			query.setParameter("usuarioMaquina", p.getUsuarioMaquina());
			query.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enabledPersona(Persona p) {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(" UPDATE Persona p SET ");
			builder.append(" p.habilitado = :habilitado ");
			builder.append(" , p.modificadoPor = :modificadoPor ");
			builder.append(" , p.fechaModificacion = :fechaModificacion ");
			builder.append(" , p.fechaActivacion = :fechaActivacion ");
			builder.append(" , p.ipUsuario = :ipUsuario ");
			builder.append(" , p.usuarioMaquina = :usuarioMaquina ");
			builder.append(" WHERE u.documentoPersona = :documentoPersona");
			Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
			query.setParameter("documentoPersona", p.getDocumentoPersona());
			query.setParameter("habilitado", p.getHabilitado());
			query.setParameter("modificadoPor", p.getModificadoPor());
			query.setParameter("fechaModificacion", p.getFechaModificacion());
			query.setParameter("fechaActivacion", p.getFechaActivacion());
			query.setParameter("ipUsuario", p.getIpUsuario());
			query.setParameter("usuarioMaquina", p.getUsuarioMaquina());
			query.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Persona getByDocumentoPersona(String documentoPersona) {
		
		Persona persona = null;
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
			Root<Persona> pe = cq.from(Persona.class);
			ParameterExpression<String> p = cb.parameter(String.class);
			cq.select(pe).where(cb.equal(pe.get("documentoPersona"), p));
			TypedQuery<Persona> query = em.createQuery(cq);
			query.setParameter(p, documentoPersona);
			
			try {
				persona = query.getSingleResult();
				if(GenericUtil.isNotNull(persona)) {
					return persona;
				}
			}
			catch(NoResultException e) {
				if(GenericUtil.isNull(persona)) {
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
	public boolean isPersonaPresent(String documentoPersona) {
		
		Persona persona = getByDocumentoPersona(documentoPersona);
		if(GenericUtil.isNull(persona)) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> spListarPersonasNoClienteByCreadoPor(String creadoPor) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("listaPersonasNoClientes");
			query.setParameter("COD_USU", creadoPor);
			personas = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> spListaPersonaNoEmpleado(String creadoPor) {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createStoredProcedureQuery(Constantes.SP_LISTA_PERSONA_NO_EMPLEADO, Persona.class);
			storeProcedure.registerStoredProcedureParameter("COD_USU", String.class, ParameterMode.IN);
			storeProcedure.setParameter("COD_USU", creadoPor);
			storeProcedure.execute();
			personas = storeProcedure.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public Long totalRegistrosPersona() {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT COUNT(p) FROM Persona p");
			Query query = em.createQuery(builder.toString());
			return (Long) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Long totalRegistrosPersonas() {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT COUNT(p) FROM Persona p");
			Query query = em.createQuery(builder.toString());
			return (Long) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
