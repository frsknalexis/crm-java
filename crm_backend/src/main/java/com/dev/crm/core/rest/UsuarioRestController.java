package com.dev.crm.core.rest;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ModuloResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.UsuarioDTO;
import com.dev.crm.core.dto.UsuarioRequest;
import com.dev.crm.core.dto.UsuarioResponse;
import com.dev.crm.core.facade.UsuarioFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRestController {

	@Autowired
	@Qualifier("usuarioFacade")
	private UsuarioFacade usuarioFacade;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		
		try {
			
			List<UsuarioDTO> usuarios = usuarioFacade.findAll();
			if(GenericUtil.isNotEmpty(usuarios)) {
				return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<UsuarioDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<UsuarioDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/usuarios/activeList")
	public ResponseEntity<List<UsuarioDTO>> getActiveList() {
		
		try {
			
			List<UsuarioDTO> usuarios = usuarioFacade.getActiveList();
			if(GenericUtil.isNotEmpty(usuarios)) {
				return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<UsuarioDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<UsuarioDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<UsuarioDTO> getByUsuarioId(@PathVariable(value="usuarioId") BigDecimal usuarioId) {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			
			if(GenericUtil.isNotEmpty(usuarioId) && usuarioId.intValue() > 0) {
				usuarioDTO = usuarioFacade.getByUsuarioId(usuarioId);
				if(GenericUtil.isObjectEmpty(usuarioDTO)) {
					return new ResponseEntity<UsuarioDTO>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/usuario/nombre/{nombreUsuario}")
	public ResponseEntity<UsuarioDTO> getByNombre(@PathVariable(value="nombreUsuario") String nombreUsuario) {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(nombreUsuario)) && (nombreUsuario.length() > 0)) {
				usuarioDTO = usuarioFacade.getByNombre(nombreUsuario);
				if(GenericUtil.isObjectEmpty(usuarioDTO)) {
					return new ResponseEntity<UsuarioDTO>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/usuario/documento/{documentoUsuario}")
	public ResponseEntity<UsuarioDTO> getByDocumentoUsuario(@PathVariable(value="documentoUsuario") String documentoUsuario) {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoUsuario)) && (documentoUsuario.length() > 0)) {
				usuarioDTO = usuarioFacade.getByDocumento(documentoUsuario);
				if(GenericUtil.isObjectEmpty(usuarioDTO)) {
					return new ResponseEntity<UsuarioDTO>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<UsuarioDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveOrUpdate")
	public ResponseEntity<ResponseBaseOperation> saveOrUpdate(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		
		try {
			
			ResponseBaseOperation response = usuarioFacade.saveOrUpdate(usuarioDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/searchUsuario")
	public ResponseEntity<UsuarioResponse> getByNombreUsuarioAndPassword(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		
		try {
			
			UsuarioResponse usuario = usuarioFacade.getByNombreUsuarioAndPassword(usuarioRequest);
			if(GenericUtil.isNotNull(usuario)) {
				return new ResponseEntity<UsuarioResponse>(usuario, HttpStatus.OK);
			}
			else if(GenericUtil.isNull(usuario)) {
				return new ResponseEntity<UsuarioResponse>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/usuario/disabled/{usuarioId}")
	public ResponseEntity<ResponseBaseOperation> disabledUsuario(@PathVariable(value="usuarioId") BigDecimal usuarioId) {
		
		try {
			
			if(GenericUtil.isNotEmpty(usuarioId) && (usuarioId.intValue() > 0)) {
				ResponseBaseOperation response = usuarioFacade.disabled(usuarioId);
				if(GenericUtil.isNotNull(response)) {
					return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ResponseBaseOperation>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/usuario/enabled/{usuarioId}")
	public ResponseEntity<ResponseBaseOperation> enabledUsuario(@PathVariable(value="usuarioId") BigDecimal usuarioId) {
		
		try {
			
			if(GenericUtil.isNotEmpty(usuarioId) && (usuarioId.intValue() > 0)) {
				ResponseBaseOperation response = usuarioFacade.enabled(usuarioId);
				if(GenericUtil.isNotNull(response)) {
					return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ResponseBaseOperation>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/totalRegistros")
	public ResponseEntity<ResponseBaseOperation> obtenerTotalRegistrosUsuario() {
		
		try {
			
			ResponseBaseOperation response = usuarioFacade.obtenerTotalRegistrosUsuario();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listamodulos/{numero}")
	public ResponseEntity<ModuloResultViewModel> spListarModulo(@PathVariable(value="numero") String numero) {
		
		try {
			
			if(GenericUtil.isNotEmpty(numero)) {
				
				String usuario = "lularosaint";
				ModuloResultViewModel cusuario = usuarioFacade.spListarModulo(usuario, numero);
				if(GenericUtil.isNotNull(cusuario)) {
					return new ResponseEntity<ModuloResultViewModel>(cusuario, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ModuloResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ModuloResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
