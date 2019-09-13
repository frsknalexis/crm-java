package com.dev.crm.core.rest;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.DeudasGestorMontoAcumuladoResultViewModel;
import com.dev.crm.core.dto.DeudasGestoresResultViewModel;
import com.dev.crm.core.dto.DeudasPorGestorRequest;
import com.dev.crm.core.dto.DeudasPorGestorResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;
import com.dev.crm.core.dto.GestoresResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.GestorFacade;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.view.pdf.PdfGenerator;

@RestController
@RequestMapping("/api/v1/gestor")
public class GestorRestController {

	@Autowired
	@Qualifier("gestorFacade")
	private GestorFacade gestorFacade;
	
	@GetMapping("/gestorClientes")
	public ResponseEntity<List<ClienteGestorResultViewModel>> listarClienteGestor() {
		
		try {
			
			List<ClienteGestorResultViewModel> clientesGestor = gestorFacade.listarClienteGestor();
			if(GenericUtil.isCollectionEmpty(clientesGestor)) {
				return new ResponseEntity<List<ClienteGestorResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<ClienteGestorResultViewModel>>(clientesGestor, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteGestorResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/gestores")
	public ResponseEntity<List<GestoresResultViewModel>> listarGestores() {
		
		try {
			
			List<GestoresResultViewModel> gestores = gestorFacade.listarGestores();
			if(GenericUtil.isCollectionEmpty(gestores)) {
				return new ResponseEntity<List<GestoresResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<GestoresResultViewModel>>(gestores, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<GestoresResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/reporteDeudasGestores")
	public ResponseEntity<List<DeudasGestoresResultViewModel>> recuperarDiasDeudasGestoresParametrizado(@Valid @RequestBody 
			DiasDeudasRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<DeudasGestoresResultViewModel> deudasGestores = gestorFacade.recuperarDiasDeudasGestoresParametrizado(request);
				if(GenericUtil.isCollectionEmpty(deudasGestores) && deudasGestores.isEmpty()) {
					return new ResponseEntity<List<DeudasGestoresResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<List<DeudasGestoresResultViewModel>>(deudasGestores, HttpStatus.OK);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<DeudasGestoresResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/deudasPorGestor")
	public ResponseEntity<List<DeudasPorGestorResultViewModel>> reporteListarDeudasPorGestor(@Valid @RequestBody DeudasPorGestorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<DeudasPorGestorResultViewModel> deudasPorGestor = gestorFacade.listarDeudasPorGestor(request);
				if(GenericUtil.isCollectionEmpty(deudasPorGestor)) {
					return new ResponseEntity<List<DeudasPorGestorResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<DeudasPorGestorResultViewModel>>(deudasPorGestor, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<DeudasPorGestorResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/updateClienteGestor")
	public ResponseEntity<ResponseBaseOperation> updateClienteGestor(@Valid @RequestBody ClienteGestorRequest request) {
		
		try {
			
			ResponseBaseOperation response = gestorFacade.updateClienteGestor(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/reporteGestorMontoAcumulado", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generarReporteGestorMontoAcumulado() {
		
		try {
			
			List<DeudasGestorMontoAcumuladoResultViewModel> listaDeudasGestorAcumulado = gestorFacade.listarDeudasGestorMontoAcumulado();
			
			ByteArrayInputStream bis = PdfGenerator.deudasGestorAcumuladoReportToPDF(listaDeudasGestorAcumulado);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=GestorMontoAcumulado.pdf");
			
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
}
