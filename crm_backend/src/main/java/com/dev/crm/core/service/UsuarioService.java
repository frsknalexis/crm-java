package com.dev.crm.core.service;

import java.math.BigDecimal;
import java.util.List;

import com.dev.crm.core.dto.ModuloResultViewModel;
import com.dev.crm.core.dto.PerfilUsuarioResultViewModel;
import com.dev.crm.core.dto.UsuarioPerfilRequest;
import com.dev.crm.core.model.entity.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();
	
	List<Usuario> getActiveList();
	
	Usuario getByUsuarioId(BigDecimal usuarioId);
	
	Usuario getByNombre(String nombreUsuario);
	
	Usuario getByNombreUsuarioAndPassword(String nombreUsuario, String passwordUsuario);
	
	Usuario getByDocumentoUsuario(String documentoUsuario);
	
	void disabledUsuario(BigDecimal usuarioId);
	
	void enabledUsuario(BigDecimal usuarioId);
	
	void saveOrUpdate(Usuario usuario);
	
	boolean isUserPresent(String documentoUsuario);
	
	void actualizarPerfilPassword(UsuarioPerfilRequest request);
	
	Long obtenerTotalRegistrosUsuario();
	
	ModuloResultViewModel spListarModulo(String usuario,String numero);
	
	PerfilUsuarioResultViewModel perfilUsuario(String usuario);
}
