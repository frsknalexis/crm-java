package com.dev.crm.core.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ModuloResultViewModel;
import com.dev.crm.core.dto.PerfilUsuarioResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.UsuarioDTO;
import com.dev.crm.core.dto.UsuarioPerfilRequest;
import com.dev.crm.core.dto.UsuarioRequest;
import com.dev.crm.core.dto.UsuarioResponse;
import com.dev.crm.core.facade.UsuarioFacade;
import com.dev.crm.core.model.entity.Usuario;
import com.dev.crm.core.service.UsuarioService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Component("usuarioFacade")
public class UsuarioFacadeImpl implements UsuarioFacade {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<UsuarioDTO> findAll() {
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		try {
			
			List<Usuario> usuarios = usuarioService.findAll();
			usuarios.stream().forEach(u -> {
				usuariosDTO.add(modelMapper.map(u, UsuarioDTO.class));
			});
			return usuariosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UsuarioDTO> getActiveList() {
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		try {
			
			List<Usuario> usuarios = usuarioService.getActiveList();
			for(Usuario u : usuarios) {
				UsuarioDTO usuarioDTO = modelMapper.map(u, UsuarioDTO.class);
				usuariosDTO.add(usuarioDTO);
			}
			return usuariosDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UsuarioDTO getByUsuarioId(BigDecimal usuarioId) {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(usuarioId) && usuarioId.intValue() > 0) {
				Usuario usuario = usuarioService.getByUsuarioId(usuarioId);
				if(GenericUtil.isNotNull(usuario)) {
					usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
				}
			}
			return usuarioDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UsuarioDTO getByNombre(String nombreUsuario) {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(nombreUsuario)) && (nombreUsuario.length() > 0)) {
				Usuario usuario = usuarioService.getByNombre(nombreUsuario);
				if(GenericUtil.isNotNull(usuario)) {
					usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
				}
			}
			return usuarioDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UsuarioResponse getByNombreUsuarioAndPassword(UsuarioRequest usuarioRequest) {
		
		UsuarioResponse usuarioResponse = null;
		
		try {
			
			if(GenericUtil.isNotNull(usuarioRequest)) {
				Usuario usuario = usuarioService.getByNombreUsuarioAndPassword(usuarioRequest.getNombreUsuario(), usuarioRequest.getPasswordUsuario());
				if(GenericUtil.isNotNull(usuario)) {
					usuarioResponse = modelMapper.map(usuario, UsuarioResponse.class);
				}
			}
			return usuarioResponse;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public UsuarioDTO getByDocumento(String documentoUsuario) {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoUsuario)) && (documentoUsuario.length() > 0)) {
				Usuario usuario = usuarioService.getByDocumentoUsuario(documentoUsuario);
				if(GenericUtil.isNotNull(usuario)) {
					usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
				}
			}
			return usuarioDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation saveOrUpdate(UsuarioDTO usuarioDTO) {
		
		try {
			
			Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
			if(GenericUtil.isNotNull(usuario)) {
				
				if(GenericUtil.isNotEmpty(usuarioDTO.getUsuarioId()) && usuarioDTO.getUsuarioId().intValue() > 0) {
					UsuarioDTO usuDTO = getByUsuarioId(usuarioDTO.getUsuarioId());
					if(usuDTO.getDocumentoUsuario().equals(usuarioDTO.getDocumentoUsuario())) {
						usuarioService.saveOrUpdate(usuario);
						return new ResponseBaseOperation(Constantes.UPDATED_STATUS, Constantes.MESSAGE_UPDATED, usuarioDTO);
					}
					else if(usuarioService.isUserPresent(usuarioDTO.getDocumentoUsuario())) {
						return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.MESSAGE_ERROR, usuarioDTO);
					}
				}
				
				if(usuarioService.isUserPresent(usuarioDTO.getDocumentoUsuario())) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.MESSAGE_ERROR, usuarioDTO);
				}
				usuarioService.saveOrUpdate(usuario);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, Constantes.MESSAGE_CREATED, usuarioDTO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResponseBaseOperation actualizarPerfilPassword(UsuarioPerfilRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				usuarioService.actualizarPerfilPassword(request);
				return new ResponseBaseOperation(Constantes.UPDATED_STATUS, Constantes.MESSAGE_UPDATED, request);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation disabled(BigDecimal usuarioId) {
		
		try {
			
			UsuarioDTO usuarioDTO = null;
			if(GenericUtil.isNotEmpty(usuarioId) && usuarioId.intValue() > 0) {
				usuarioDTO = getByUsuarioId(usuarioId);
			}
			if(GenericUtil.isNotNull(usuarioDTO)) {
				if(usuarioDTO.getHabilitado().equals(Constantes.HABILITADO)) {
					usuarioService.disabledUsuario(usuarioId);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_DISABLED, usuarioDTO);
				}
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation enabled(BigDecimal usuarioId) {
		
		try {
			
			UsuarioDTO usuarioDTO = null;
			if(GenericUtil.isNotEmpty(usuarioId) && usuarioId.intValue() > 0) {
				usuarioDTO = getByUsuarioId(usuarioId);
			}
			if(GenericUtil.isNotNull(usuarioDTO)) {
				if(usuarioDTO.getHabilitado().equals(Constantes.INHABILITADO)) {
					usuarioService.enabledUsuario(usuarioId);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_ENABLED, usuarioDTO);
				}
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation obtenerTotalRegistrosUsuario() {
		try {
			
			Long totalRegistrosUsuario = usuarioService.obtenerTotalRegistrosUsuario();
			if(totalRegistrosUsuario == 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ' ' + totalRegistrosUsuario, totalRegistrosUsuario);
			}
			else if(totalRegistrosUsuario > 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ' ' + totalRegistrosUsuario, totalRegistrosUsuario);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ModuloResultViewModel spListarModulo(String usuario,String numero) {

		ModuloResultViewModel cDaOnu;
		
		try {
			
			if(!GenericUtil.isEmpty(usuario) && !GenericUtil.isEmpty(numero)) {
				cDaOnu = usuarioService.spListarModulo(usuario, numero);
				if(GenericUtil.isNotNull(cDaOnu)) {
					return cDaOnu;
				}
				else {
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
	public PerfilUsuarioResultViewModel perfilUsuario(String usuario) {
		
		PerfilUsuarioResultViewModel perfilUsuario;
		
		try {
			
			if(GenericUtil.isNotNull(usuario)) {
				perfilUsuario = usuarioService.perfilUsuario(usuario);
				if(GenericUtil.isNotNull(perfilUsuario)) {
					return perfilUsuario;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
