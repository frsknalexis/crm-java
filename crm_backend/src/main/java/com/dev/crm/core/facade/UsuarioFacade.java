package com.dev.crm.core.facade;

import java.math.BigDecimal;
import java.util.List;

import com.dev.crm.core.dto.ModuloResultViewModel;
import com.dev.crm.core.dto.PerfilUsuarioResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.UsuarioDTO;
import com.dev.crm.core.dto.UsuarioPerfilRequest;
import com.dev.crm.core.dto.UsuarioRequest;
import com.dev.crm.core.dto.UsuarioResponse;

public interface UsuarioFacade {

	List<UsuarioDTO> findAll();
	
	List<UsuarioDTO> getActiveList();
	
	UsuarioDTO getByUsuarioId(BigDecimal usuarioId);
	
	UsuarioDTO getByNombre(String nombreUsuario);
	
	UsuarioResponse getByNombreUsuarioAndPassword(UsuarioRequest usuarioRequest);
	
	UsuarioDTO getByDocumento(String documentoUsuario);
	
	ResponseBaseOperation saveOrUpdate(UsuarioDTO usuarioDTO);

	ResponseBaseOperation actualizarPerfilPassword(UsuarioPerfilRequest request);
	
	ResponseBaseOperation disabled(BigDecimal usuarioId);
	
	ResponseBaseOperation enabled(BigDecimal usuarioId);
	
	ResponseBaseOperation obtenerTotalRegistrosUsuario();
	
	ModuloResultViewModel spListarModulo(String usuario,String numero);
	
	PerfilUsuarioResultViewModel perfilUsuario(String usuario);
}
