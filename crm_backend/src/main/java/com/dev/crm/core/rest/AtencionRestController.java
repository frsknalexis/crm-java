package com.dev.crm.core.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.AsignarTecnicoComboResultViewModel;
import com.dev.crm.core.dto.ClienteAtencionDetalleResultViewModel;
import com.dev.crm.core.dto.ClienteAtencionResultViewModel;
import com.dev.crm.core.dto.ClienteDatosAtencionResultViewModel;
import com.dev.crm.core.dto.DatosOnuRequest;
import com.dev.crm.core.dto.DatosOnusResultViewModel;
import com.dev.crm.core.dto.InsertarReclamoRequest;
import com.dev.crm.core.dto.InsertarTecnicTareaRequest;
import com.dev.crm.core.dto.MensajeNotiResultViewModel;
import com.dev.crm.core.dto.ObtenernumerotareaRequest;
import com.dev.crm.core.dto.ReclamoResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.TareasResultViewModel;
import com.dev.crm.core.facade.AtencionFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@RestController
@RequestMapping("/api/v1/atencion")
public class AtencionRestController {

	@Autowired
	@Qualifier("atencionFacade")
	private AtencionFacade atencionFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@GetMapping("/clientesAtencion")
	public ResponseEntity<List<ClienteAtencionResultViewModel>> spListarClientesAtencion() {
		
		try {
			
			List<ClienteAtencionResultViewModel> clientesPago = atencionFacade.spListarClientesAtencion();
			if(!GenericUtil.isCollectionEmpty(clientesPago)) {
				return new ResponseEntity<List<ClienteAtencionResultViewModel>>(clientesPago, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ClienteAtencionResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteAtencionResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/clienteDatosAtencion/{documentoPersonaCliente}")
	public ResponseEntity<ClienteDatosAtencionResultViewModel> spListarDatosGeneralesCliente(@PathVariable(value="documentoPersonaCliente") String documentoPersonaCliente) {
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaCliente)) {
				ClienteDatosAtencionResultViewModel clienteDatosAtencion = atencionFacade.spListarDatosGeneralesCliente(documentoPersonaCliente);
				if(GenericUtil.isNotNull(clienteDatosAtencion)) {
					return new ResponseEntity<ClienteDatosAtencionResultViewModel>(clienteDatosAtencion, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ClienteDatosAtencionResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ClienteDatosAtencionResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/clientesAtencionDetalle/{documentoPersonaCliente}")
	public ResponseEntity<List<ClienteAtencionDetalleResultViewModel>> spListarClientesAtencionDetalle(@PathVariable(value = "documentoPersonaCliente") String documentoPersonaCliente) {
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaCliente)) {
				List<ClienteAtencionDetalleResultViewModel> clientesAtencionDetalle = atencionFacade.spListarClientesAtencionDetalle(documentoPersonaCliente);
				if(!GenericUtil.isCollectionEmpty(clientesAtencionDetalle)) {
					return new ResponseEntity<List<ClienteAtencionDetalleResultViewModel>>(clientesAtencionDetalle, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<List<ClienteAtencionDetalleResultViewModel>>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteAtencionDetalleResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/insrreclamo")
	public ResponseEntity<ResponseBaseOperation> spInsertarReclamo(@Valid @RequestBody InsertarReclamoRequest inserther) {
		
		try
		{
			User usuarioLogueado = userDetail.findLoggedInUser();
			//String mensaje = "jolaurenint";
			String usuario = usuarioLogueado.getUsername();
			inserther.setCodigousuario(usuario);
			ResponseBaseOperation response = atencionFacade.spInsertarReclamo(inserther);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/comboempleado/{persona}")
	public ResponseEntity<List<AsignarTecnicoComboResultViewModel>> spListarCombo(@PathVariable(value = "persona") String persona) {
		
		try {
			
			List<AsignarTecnicoComboResultViewModel> combotecnico = atencionFacade.spListarComboTecnico(persona);
			if(!GenericUtil.isCollectionEmpty(combotecnico)) {
				return new ResponseEntity<List<AsignarTecnicoComboResultViewModel>>(combotecnico, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<AsignarTecnicoComboResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<AsignarTecnicoComboResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reclamo")
	public ResponseEntity<List<ReclamoResultViewModel>> spListarReclamo(){
		
		try
			{
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			//String usuario = "jolaurenint";
			String usuario = usuarioLogueado.getUsername();
			if(StringUtil.hasText(usuario)) {
				List<ReclamoResultViewModel> herramientasAtencion = atencionFacade.spListarReclamo(usuario);
				if(!GenericUtil.isEmpty(herramientasAtencion)) {
					return new ResponseEntity<List<ReclamoResultViewModel>>(herramientasAtencion, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<List<ReclamoResultViewModel>>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ReclamoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	@PostMapping("/updatetecnico")
	public ResponseEntity<ResponseBaseOperation> spEstadoPlanta(@Valid @RequestBody InsertarTecnicTareaRequest documentoPersona) {
		
		try
		{
			User usuarioLogueado = userDetail.findLoggedInUser();
			//String usuario = "jolaurenint";
			String usuario = usuarioLogueado.getUsername();
			documentoPersona.setCodigousuario(usuario);
			ResponseBaseOperation response = atencionFacade.speditarreclmaotecnico(documentoPersona);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/obtenercantidad")
	public ResponseEntity<ResponseBaseOperation> spobtenervalor(@Valid @RequestBody ObtenernumerotareaRequest documentoPersona) {
		
		try
		{
			User usuarioLogueado = userDetail.findLoggedInUser();
			//String usuario = "joroblesext";
			String usuario = usuarioLogueado.getUsername();
			documentoPersona.setDatovaluar(usuario);
			ResponseBaseOperation response = atencionFacade.spObtnerCantidadTarea(documentoPersona);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchMensaje/{usuariocombinado}")
	public ResponseEntity<MensajeNotiResultViewModel> spbuscardatosmensaje(@PathVariable(value="usuariocombinado") String usuariocombinado) {
		
		try {
			
			if(GenericUtil.isNotEmpty(usuariocombinado)) {
				
				User usuarioLogueado = userDetail.findLoggedInUser();
				//String usuario = "joroblesext";
				String usuario = usuarioLogueado.getUsername();
				String valor = usuariocombinado + usuario;
				MensajeNotiResultViewModel cusuario =atencionFacade.spbuscardatosmensaje(valor);
				if(GenericUtil.isNotNull(cusuario)) {
					return new ResponseEntity<MensajeNotiResultViewModel>(cusuario, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<MensajeNotiResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<MensajeNotiResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/tareaspendientes")
	public ResponseEntity<List<TareasResultViewModel>> spListarTareas() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			//String usuario = "joroblesext";
			String usuario = usuarioLogueado.getUsername();
			if(GenericUtil.isNotEmpty(usuario)) {
				List<TareasResultViewModel> tarea = atencionFacade.spListarTareas(usuario);
				if(!GenericUtil.isCollectionEmpty(tarea)) {
					return new ResponseEntity<List<TareasResultViewModel>>(tarea, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<List<TareasResultViewModel>>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<TareasResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/tareaupdate/{valor}")
	public ResponseEntity<ResponseBaseOperation> spEstadoPlanta(@PathVariable("valor") String valor) {
		
		try
		{
			ResponseBaseOperation response = atencionFacade.speditartarea(valor);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/searchDatosOnu")
	public ResponseEntity<DatosOnusResultViewModel> spRecuperarDatosOnu(@Valid @RequestBody DatosOnuRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				DatosOnusResultViewModel datosOnu = atencionFacade.spRecuperarDatosOnu(request);
				if(GenericUtil.isNotNull(datosOnu)) {
					return new ResponseEntity<DatosOnusResultViewModel>(datosOnu, HttpStatus.OK);
				}
				else if(GenericUtil.isNull(datosOnu)) {
					return new ResponseEntity<DatosOnusResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<DatosOnusResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/updatetecnicoinsta")
	public ResponseEntity<ResponseBaseOperation> spUpdateTecnicoInsta(@Valid @RequestBody InsertarTecnicTareaRequest requ) {
		
		try
		{
			User usuarioLogueado = userDetail.findLoggedInUser();
			//String usuario = "jolaurenint";
			String usuario = usuarioLogueado.getUsername();
			requ.setCodigousuario(usuario);
			ResponseBaseOperation response = atencionFacade.speditarinstmaotecnico(requ);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
