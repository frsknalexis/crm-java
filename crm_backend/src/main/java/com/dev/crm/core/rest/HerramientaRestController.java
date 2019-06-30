package com.dev.crm.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import javax.validation.Valid;

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

import com.dev.crm.core.dto.HerramientaResultViewModel;
import com.dev.crm.core.dto.DetalleHerramientaRequest;
import com.dev.crm.core.dto.DetalleHerramientaViewModel;
import com.dev.crm.core.dto.EditarHerramientaRequest;
import com.dev.crm.core.dto.EditarHerramientaResultViewModel;
import com.dev.crm.core.dto.EditarPreguntaRequest;
import com.dev.crm.core.dto.HerramientaRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.dto.ValorHerramientaRequest;
import com.dev.crm.core.facade.HerramientaFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@RestController
@RequestMapping("/api/v1/herramienta")
public class HerramientaRestController {

	@Autowired
	@Qualifier("herramientaFacade")
	private HerramientaFacade herramientaFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@GetMapping("/herramientas")
	public ResponseEntity<List<HerramientaResultViewModel>> spListarDatosGeneralesCliente() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String user = usuarioLogueado.getUsername();
			//String usuario = "jolaurenint"; 
			if(StringUtil.hasText(user)) {
				List<HerramientaResultViewModel> herramientasAtencion = herramientaFacade.spListarHerramientaAtencion(user);
				if(!GenericUtil.isEmpty(herramientasAtencion)) {
					return new ResponseEntity<List<HerramientaResultViewModel>>(herramientasAtencion, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<List<HerramientaResultViewModel>>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<HerramientaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/insertarherramienta")
	public ResponseEntity<ResponseBaseOperation> spinsertherr(@Valid @RequestBody HerramientaRequest inserther) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			//String mensaje = "jolaurenint";
			inserther.setMensaje(usuario);
			ResponseBaseOperation response = herramientaFacade.spInserccionHerramienta(inserther);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/insertardetalleherramienta")
	public ResponseEntity<ResponseBaseOperation> spinsertdetherr(@Valid @RequestBody DetalleHerramientaRequest inserther) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			//String mensaje = "jolaurenint";
			inserther.setCodigousuario(usuario);
			inserther.setDescripcionherramienta(inserther.getDescripcionherramienta());
			ResponseBaseOperation response = herramientaFacade.spInsercciondetalleHerramienta(inserther);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchherramienta/{codiherra}")
	public ResponseEntity<ValorHerramientaRequest> spBuscarClientePago(@PathVariable(value="codiherra") String codiherra) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codiherra)) {
				ValorHerramientaRequest clientePago = herramientaFacade.soBusquedaHerramienta(codiherra);
				if(GenericUtil.isNotNull(clientePago)) {
					return new ResponseEntity<ValorHerramientaRequest>(clientePago, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ValorHerramientaRequest>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ValorHerramientaRequest>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/searchlista/{codiherra}")
	public ResponseEntity<List<DetalleHerramientaViewModel>> soListarPregunta(@PathVariable(value="codiherra") String codiherra) {
		
		try {
			
			List<DetalleHerramientaViewModel> herramientasAtencion = herramientaFacade.soListarPregunta(codiherra);
			
			if(!GenericUtil.isEmpty(herramientasAtencion))
			{
				return new ResponseEntity<List<DetalleHerramientaViewModel>>(herramientasAtencion, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<DetalleHerramientaViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<DetalleHerramientaViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchdatos/{codiherra}")
	public ResponseEntity<EditarHerramientaResultViewModel> soListardDatos(@PathVariable(value="codiherra") String codiherra) {
		
		try
		{
			
			EditarHerramientaResultViewModel response = herramientaFacade.soListarDatosHerra(codiherra);
			return new ResponseEntity<EditarHerramientaResultViewModel>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<EditarHerramientaResultViewModel>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/editarherramienta")
	public ResponseEntity<ResponseBaseOperation> speditarherra(@Valid @RequestBody EditarHerramientaRequest inserther) {
		
		try {
			
			inserther.setDescripcionherramienta(inserther.getDescripcionherramienta());
			ResponseBaseOperation response = herramientaFacade.spEditarHerramienta(inserther);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/editarpregunta")
	public ResponseEntity<ResponseBaseOperation> spEditarPregunta(@Valid @RequestBody EditarPreguntaRequest inserther) {
		
		try
		{
			ResponseBaseOperation response = herramientaFacade.spEditarPregunta(inserther);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
