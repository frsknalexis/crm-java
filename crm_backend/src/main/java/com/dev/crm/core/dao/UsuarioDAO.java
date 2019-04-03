package com.dev.crm.core.dao;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.Usuario;

public interface UsuarioDAO extends BaseDAOHibernate {

	void disabledUsuario(Usuario usuario);
	
	void enabledUsuario(Usuario usuario);
	
	Usuario getByNombre(String nombreUsuario);
	
	Usuario getByDocumentoUsuario(String documentoUsuario);
	
	Boolean isUserPresent(String documentoUsuario);
}
