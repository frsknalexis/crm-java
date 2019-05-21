package com.dev.crm.core.facade;

import java.math.BigDecimal;
import java.util.List;

import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.UsuarioDTO;
import com.dev.crm.core.dto.UsuarioRequest;
import com.dev.crm.core.dto.UsuarioResponse;

public interface UsuarioFacade {

	List<UsuarioDTO> findAll();
	
	List<UsuarioDTO> getActiveList();
	
	UsuarioDTO getByUsuarioId(BigDecimal usuarioId);
	
	UsuarioDTO getByNombre(String nombreUsuario);
	
	UsuarioDTO getByDocumento(String documentoUsuario);
	
	UsuarioResponse getByNombreUsuarioAndPassword(UsuarioRequest usuarioRequest);
	
	ResponseBaseOperation saveOrUpdate(UsuarioDTO usuarioDTO);
	
	ResponseBaseOperation disabled(BigDecimal usuarioId);
	
	ResponseBaseOperation enabled(BigDecimal usuarioId);
	
	ResponseBaseOperation obtenerTotalRegistrosUsuario();
}
