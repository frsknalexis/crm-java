package com.dev.crm.core.facade;

import java.math.BigDecimal;
import java.util.List;

import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.UsuarioDTO;

public interface UsuarioFacade {

	List<UsuarioDTO> findAll();
	
	List<UsuarioDTO> getActiveList();
	
	UsuarioDTO getByUsuarioId(BigDecimal usuarioId);
	
	UsuarioDTO getByNombre(String nombreUsuario);
	
	UsuarioDTO getByDocumento(String documentoUsuario);
	
	ResponseBaseOperation saveOrUpdate(UsuarioDTO usuarioDTO);
	
	ResponseBaseOperation disabled(BigDecimal usuarioId);
	
	ResponseBaseOperation enabled(BigDecimal usuarioId);
	
	ResponseBaseOperation obtenerTotalRegistrosUsuario();
}
