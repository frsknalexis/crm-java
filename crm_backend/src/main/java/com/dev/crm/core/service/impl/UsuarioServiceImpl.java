package com.dev.crm.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.UsuarioDAO;
import com.dev.crm.core.model.entity.Usuario;
import com.dev.crm.core.service.UsuarioService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.DateUtil;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.IpUtil;

@Service("usuarioService")
@Transactional("hibernateTransactionManager")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> findAll() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			usuarios = usuarioDAO.findAll(Usuario.class);
			if(GenericUtil.isNotNull(usuarios)) {
				return usuarios;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> getActiveList() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			usuarios = usuarioDAO.getActiveList(Usuario.class);
			if(GenericUtil.isNotNull(usuarios)) {
				return usuarios;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getByUsuarioId(BigDecimal usuarioId) {
		
		Usuario usuario = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(usuarioId)) {
				usuario = usuarioDAO.get(Usuario.class, usuarioId);
			}
			if(GenericUtil.isNotNull(usuario)) {
				return usuario;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getByNombre(String nombreUsuario) {
		
		Usuario usuario = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(nombreUsuario))) {
				usuario = usuarioDAO.getByNombre(nombreUsuario);
			}
			if(GenericUtil.isNotNull(usuario)) {
				return usuario;
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
			
			if(!(GenericUtil.isEmpty(documentoUsuario))) {
				usuario = usuarioDAO.getByDocumentoUsuario(documentoUsuario);
			}
			if(GenericUtil.isNotNull(usuario)) {
				return usuario;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void disabledUsuario(BigDecimal usuarioId) {
		
		try {
			
			Usuario usuario = null;
			if(GenericUtil.isNotEmpty(usuarioId)) {
				usuario = usuarioDAO.get(Usuario.class, usuarioId);
				usuario.setHabilitado(Constantes.INHABILITADO);
				usuario.setFechaModificacion(DateUtil.getCurrentDate());
				usuario.setFechaDesactivacion(DateUtil.getCurrentDate());
				usuario.setIpUsuario(IpUtil.getCurrentIPAddress());
				usuario.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
				usuario.setUsuarioSistema(IpUtil.getCurrentUserSystem());
			}
			usuarioDAO.disabledUsuario(usuario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enabledUsuario(BigDecimal usuarioId) {
		
		try {
			
			Usuario usuario = null;
			if(GenericUtil.isNotEmpty(usuarioId)) {
				usuario = usuarioDAO.get(Usuario.class, usuarioId);
				usuario.setHabilitado(Constantes.HABILITADO);
				usuario.setFechaModificacion(DateUtil.getCurrentDate());
				usuario.setFechaActivacion(DateUtil.getCurrentDate());
				usuario.setIpUsuario(IpUtil.getCurrentIPAddress());
				usuario.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
				usuario.setUsuarioSistema(IpUtil.getCurrentUserSystem());
			}
			usuarioDAO.enabledUsuario(usuario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveOrUpdate(Usuario u) {
		
		try {
			
			u.setHabilitado(Constantes.HABILITADO);
			u.setIpUsuario(IpUtil.getCurrentIPAddress());
			u.setUsuarioMaquina(IpUtil.getCurrentUserMachine());
			u.setUsuarioSistema(IpUtil.getCurrentUserSystem());
			if(GenericUtil.isNotEmpty(u.getUsuarioId()) && u.getUsuarioId().intValue() > 0) {
				u.setFechaModificacion(DateUtil.getCurrentDate());
				usuarioDAO.update(u);
			}
			else {
				u.setFechaRegistro(DateUtil.getCurrentDate());
				usuarioDAO.save(u);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isUserPresent(String documentoUsuario) {
		if(!(GenericUtil.isEmpty(documentoUsuario))) {
			return usuarioDAO.isUserPresent(documentoUsuario);
		}
		return false;
	}

	@Override
	public Long obtenerTotalRegistrosUsuario() {
		
		try {
			
			Long totalRegistrosUsuario = usuarioDAO.obtenerTotalRegistrosUsuario();
			return totalRegistrosUsuario;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
