package com.dev.crm.core.base.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.util.Constantes;

public class BaseDAOHibernateImpl implements BaseDAOHibernate {

	@Autowired
	protected SessionFactory sessionFactory;
	
	@Autowired
	protected EntityManager em;
	
	@Override
	public <T> void save(T t) {
		
		try {
			sessionFactory.getCurrentSession().persist(t);
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().refresh(t);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void update(T t) {
		
		try {
			sessionFactory.getCurrentSession().update(t);
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().refresh(t);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void delete(T t) {
		
		try {
			sessionFactory.getCurrentSession().delete(t);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void delete(Class<T> _class, BigDecimal _id) {
		
		try {
			
			T t = get(_class, _id);
			delete(t);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> T get(Class<T> entityClass, BigDecimal _id) {
		
		T t = null;
		
		try {
			
			t = (T) sessionFactory.getCurrentSession().get(entityClass, _id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public <T> List<T> getActiveList(Class<T> _class) {
		
		List<T> list = new ArrayList<T>();

		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(_class);
			Root<T> t = cq.from(_class);
			ParameterExpression<Boolean> p = cb.parameter(Boolean.class);
			cq.select(t).where(cb.equal(t.get("habilitado"), p));
			TypedQuery<T> query = em.createQuery(cq);
			query.setParameter(p, Constantes.HABILITADO);
			list = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public <T> List<T> findAll(Class<T> _class) {
		
		List<T> list = new ArrayList<T>();
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(_class);
			Root<T> t = cq.from(_class);
			cq.select(t);
			TypedQuery<T> query = em.createQuery(cq);
			list = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
