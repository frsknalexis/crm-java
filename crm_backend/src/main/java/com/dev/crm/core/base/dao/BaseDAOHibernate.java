package com.dev.crm.core.base.dao;

import java.math.BigDecimal;
import java.util.List;

public interface BaseDAOHibernate {

	public <T> void save(T t);
	
	public <T> void update(T t);
	
	public <T> void delete(T t);
	
	public <T> void delete(Class<T> _class, BigDecimal _id);
	
	public <T> T get(Class<T> entityClass, BigDecimal _id);
	
	public <T> List<T> getActiveList(Class<T> _class);
	
	public <T> List<T> findAll(Class<T> _class);
}
