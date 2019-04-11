package com.dev.crm.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dev.crm.core.base.dao.impl.BaseDAOHibernateImpl;
import com.dev.crm.core.dao.ClienteDAO;
import com.dev.crm.core.model.entity.Cliente;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("clienteDAO")
public class ClienteDAOImpl extends BaseDAOHibernateImpl implements ClienteDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> spListarClienteVendedor(String creadoPor) {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createNamedStoredProcedureQuery("listarClientesVendedor");
			storeProcedure.setParameter("COD_USU", creadoPor);
			storeProcedure.execute();
			clientes = storeProcedure.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public Cliente getByDocumentoPersonaCliente(String documentoPersonaCliente) {
		
		Cliente cliente = null;
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
			Root<Cliente> c = cq.from(Cliente.class);
			ParameterExpression<String> p = cb.parameter(String.class);
			cq.select(c).where(cb.equal(c.get("documentoPersonaCliente"), p));
			TypedQuery<Cliente> query = em.createQuery(cq);
			query.setParameter(p, documentoPersonaCliente);
			
			try {
				cliente = query.getSingleResult();
				if(GenericUtil.isNotNull(cliente)) {
					return cliente;
				}
			}
			catch(NoResultException e) {
				if(GenericUtil.isNull(cliente)) {
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
	public boolean isClientePresent(String documentoPersonaCliente) {
		
		Cliente cliente = getByDocumentoPersonaCliente(documentoPersonaCliente);
		if(GenericUtil.isNull(cliente)) {
			return false;
		}
		return false;
	}

	@Override
	public void spInsertarCliente(Cliente c) {
		
		try {
			
			StoredProcedureQuery storeProcedure = em.createNamedStoredProcedureQuery("insertarCliente");
			storeProcedure.setParameter("COD_DOC", c.getDocumentoPersonaCliente());
			storeProcedure.setParameter("NOM_COM", c.getNombreComercialCliente());
			storeProcedure.setParameter("ACT_CLI", c.getEstado());
			storeProcedure.setParameter("COR_CLI", c.getCorreoCliente());
			storeProcedure.setParameter("FAX_CLI", c.getFacebookCliente());
			storeProcedure.setParameter("COD_SEX", c.getSexo().getCodigoSexo());
			storeProcedure.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void disabledCliente(Cliente c) {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(" UPDATE Cliente c SET ");
			builder.append(" c.estado = :estado ");
			builder.append(" WHERE c.documentoPersonaCliente = :documentoPersonaCliente");
			Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
			query.setParameter("estado", c.getEstado());
			query.setParameter("documentoPersonaCliente", c.getDocumentoPersonaCliente());
			query.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enabledCliente(Cliente c) {
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(" UPDATE Cliente c SET ");
			builder.append(" c.estado = :estado ");
			builder.append(" WHERE c.documentoPersonaCliente = :documentoPersonaCliente");
			Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
			query.setParameter("estado", c.getEstado());
			query.setParameter("documentoPersonaCliente", c.getDocumentoPersonaCliente());
			query.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cliente> getActiveListClientes() {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
			Root<Cliente> c = cq.from(Cliente.class);
			ParameterExpression<Boolean> p = cb.parameter(Boolean.class);
			cq.select(c).where(cb.equal(c.get("estado"), p));
			TypedQuery<Cliente> query = em.createQuery(cq);
			query.setParameter(p, Constantes.HABILITADO);
			clientes = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
}
