package com.dev.crm.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.dev.crm.core.base.dao.impl.BaseDAOHibernateImpl;
import com.dev.crm.core.dao.UsuarioDAO;
import com.dev.crm.core.model.entity.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOImpl extends BaseDAOHibernateImpl implements UsuarioDAO  {
	
	@Override
	public void disabledUsuario(Usuario usuario) {
		
	}

	@Override
	public void enabledUsuario(Usuario usuario) {
		
	}

	@Override
	public Usuario getByNombre(String nombreUsuario) {
	
		return null;
	}

	@Override
	public Usuario getByDocumentoUsuario(String documentoUsuario) {
		
		return null;
	}

	@Override
	public Boolean isUserPresent(String documentoUsuario) {
		
		return null;
	}

}
