package com.dev.crm.core.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dev.crm.core.base.dao.impl.BaseDAOHibernateImpl;
import com.dev.crm.core.dao.UsuarioDAO;
import com.dev.crm.core.model.entity.Usuario;
import com.dev.crm.core.util.GenericUtil;

@Repository("usuarioDAO")
public class UsuarioDAOImpl extends BaseDAOHibernateImpl implements UsuarioDAO  {
	
	@Override
	public void disabledUsuario(Usuario u) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE Usuario u SET ");
		builder.append(" u.habilitado = :habilitado ");
		builder.append(" , u.modificadoPor = :modificadoPor ");
		builder.append(" , u.fechaModificacion = :fechaModificacion ");
		builder.append(" , u.fechaDesactivacion = :fechaDesactivacion");
		builder.append(" , u.ipUsuario = :ipUsuario ");
		builder.append(" , u.usuarioMaquina = :usuarioMaquina ");
		builder.append(" , u.usuarioSistema = :usuarioSistema ");
		builder.append(" WHERE u.usuarioId = :usuarioId");
		Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
		query.setParameter("usuarioId", u.getUsuarioId());
		query.setParameter("habilitado", u.getHabilitado());
		query.setParameter("modificadoPor", u.getModificadoPor());
		query.setParameter("fechaModificacion", u.getFechaModificacion());
		query.setParameter("fechaDesactivacion", u.getFechaDesactivacion());
		query.setParameter("ipUsuario", u.getIpUsuario());
		query.setParameter("usuarioMaquina", u.getUsuarioMaquina());
		query.setParameter("usuarioSistema", u.getUsuarioSistema());
		query.executeUpdate();
	}

	@Override
	public void enabledUsuario(Usuario u) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE Usuario u SET ");
		builder.append(" u.habilitado = :habilitado ");
		builder.append(" , u.modificadoPor = :modificadoPor ");
		builder.append(" , u.fechaModificacion = :fechaModificacion ");
		builder.append(" , u.fechaActivacion = :fechaActivacion ");
		builder.append(" , u.ipUsuario = :ipUsuario ");
		builder.append(" , u.usuarioMaquina = :usuarioMaquina ");
		builder.append(" , u.usuarioSistema = :usuarioSistema ");
		builder.append(" WHERE u.usuarioId = :usuarioId");
		Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
		query.setParameter("usuarioId", u.getUsuarioId());
		query.setParameter("habilitado", u.getHabilitado());
		query.setParameter("modificadoPor", u.getModificadoPor());
		query.setParameter("fechaModificacion", u.getFechaModificacion());
		query.setParameter("fechaActivacion", u.getFechaActivacion());
		query.setParameter("ipUsuario", u.getIpUsuario());
		query.setParameter("usuarioMaquina", u.getUsuarioMaquina());
		query.setParameter("usuarioSistema", u.getUsuarioSistema());
		query.executeUpdate();
	}

	@Override
	public Usuario getByNombre(String nombreUsuario) {
	
		Usuario usuario = null;
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario");
			Query query = em.createQuery(builder.toString());
			query.setParameter("nombreUsuario", nombreUsuario);
			usuario = (Usuario) query.getSingleResult();
			return usuario;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Usuario getByNombreUsuarioAndPassword(String nombreUsuario, String passwordUsuario) {
		
		Usuario usuario = null;
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.passwordUsuario = :passwordUsuario");
			Query query = em.createQuery(builder.toString());
			query.setParameter("nombreUsuario", nombreUsuario);
			query.setParameter("passwordUsuario", passwordUsuario);
			
			try {
				
				usuario = (Usuario) query.getSingleResult();
				if(GenericUtil.isNotNull(usuario)) {
					return usuario;
				}
			}
			catch(NoResultException ex) {
				if(GenericUtil.isNull(usuario)) {
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
	public Usuario getByDocumentoUsuario(String documentoUsuario) {
		
		Usuario usuario = null;
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
			Root<Usuario> u = cq.from(Usuario.class);
			ParameterExpression<String> p = cb.parameter(String.class);
			cq.select(u).where(cb.equal(u.get("documentoUsuario"), p));
			TypedQuery<Usuario> query = em.createQuery(cq);
			query.setParameter(p, documentoUsuario);
	
			try {
				usuario = (Usuario) query.getSingleResult();
				if(GenericUtil.isNotNull(usuario)) {
					return usuario;
				}
			}
			catch(NoResultException e) {
				if(GenericUtil.isNull(usuario)) {
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
	public boolean isUserPresent(String documentoUsuario) {
		
		Usuario usuario = getByDocumentoUsuario(documentoUsuario);
		if(GenericUtil.isNull(usuario)) {
			return false;
		}
		return true;
	}

	@Override
	public Long obtenerTotalRegistrosUsuario() {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT COUNT(u) FROM Usuario u");
			Query query = em.createQuery(builder.toString());
			return (Long) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
