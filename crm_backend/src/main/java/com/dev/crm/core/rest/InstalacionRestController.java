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
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ActivacionRequest;
import com.dev.crm.core.dto.ActivacionesPorDiaRequest;
import com.dev.crm.core.dto.ActivacionesPorDiaResultViewModel;
import com.dev.crm.core.dto.ActivacionesPorRangoRequest;
import com.dev.crm.core.dto.ActivacionesPorRangoResultViewModel;
import com.dev.crm.core.dto.ActivacionesResultViewModel;
import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;
import com.dev.crm.core.dto.InstalacionesResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.InstalacionFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.view.pdf.PdfGenerator;

@RestController
@RequestMapping("/api/v1/instalacion")
public class InstalacionRestController {

	@Autowired
	@Qualifier("instalacionFacade")
	private InstalacionFacade instalacionFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@GetMapping("/instalacionesDiaInternet")
	public ResponseEntity<List<InstalacionDiaInternetResultViewModel>> spListarInstalacionDiaInternet() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String user = usuarioLogueado.getUsername();
			List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = instalacionFacade.spListarInstalacionDiaInternet(user);
			if(GenericUtil.isCollectionEmpty(instalacionesDiaInternet)) {
				return new ResponseEntity<List<InstalacionDiaInternetResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<InstalacionDiaInternetResultViewModel>>(instalacionesDiaInternet, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<InstalacionDiaInternetResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/informeInstalacionDia")
	public ResponseEntity<List<InformeInstalacionDiaResultViewModel>> listarInformeInstalacionDia() {
		
		try {
			
			List<InformeInstalacionDiaResultViewModel> informesInstalacionDia = instalacionFacade.listarInformeInstalacionDia();
			if(GenericUtil.isCollectionEmpty(informesInstalacionDia)) {
				return new ResponseEntity<List<InformeInstalacionDiaResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<InformeInstalacionDiaResultViewModel>>(informesInstalacionDia, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<InformeInstalacionDiaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/instalacionesPorTecnico")
	public ResponseEntity<List<InstalacionesPorTecnicoResultViewModel>> instalacionesPorTecnico() {
		
		try {
			
			List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico = instalacionFacade.instalacionesPorTecnico();
			if(GenericUtil.isCollectionEmpty(instalacionesPorTecnico)) {
				return new ResponseEntity<List<InstalacionesPorTecnicoResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<InstalacionesPorTecnicoResultViewModel>>(instalacionesPorTecnico, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<InstalacionesPorTecnicoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/instalacionesRealizadas")
	public ResponseEntity<List<InstalacionesResultViewModel>> contadorInstalacionesRealizadas() {
		
		try {
			
			List<InstalacionesResultViewModel> instalacionesRealizadas = instalacionFacade.contadorInstalacionesRealizadas();
			if(GenericUtil.isCollectionEmpty(instalacionesRealizadas)) {
				return new ResponseEntity<List<InstalacionesResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<InstalacionesResultViewModel>>(instalacionesRealizadas, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<InstalacionesResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
 	
	@PostMapping("/activacionesPorDia")
	public ResponseEntity<List<ActivacionesPorDiaResultViewModel>> listarActivacionesPorDia(@Valid @RequestBody ActivacionesPorDiaRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<ActivacionesPorDiaResultViewModel> activacionesPorDia = instalacionFacade.listarActivacionesPorDia(request);
				if(GenericUtil.isCollectionEmpty(activacionesPorDia)) {
					return new ResponseEntity<List<ActivacionesPorDiaResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<ActivacionesPorDiaResultViewModel>>(activacionesPorDia, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ActivacionesPorDiaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/activacionesPorRango")
	public ResponseEntity<List<ActivacionesPorRangoResultViewModel>> listarActivacionesPorRango(@Valid @RequestBody ActivacionesPorRangoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				List<ActivacionesPorRangoResultViewModel> activacionesPorRango = instalacionFacade.listarActivacionesPorRango(request);
				if(GenericUtil.isCollectionEmpty(activacionesPorRango)) {
					return new ResponseEntity<List<ActivacionesPorRangoResultViewModel>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<ActivacionesPorRangoResultViewModel>>(activacionesPorRango, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ActivacionesPorRangoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping(value = "/reporteActivaciones", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> reporteActivacionesInstalacion() {
		
		try {
			
			List<ActivacionesResultViewModel> activacionesInstalacion = instalacionFacade.listarActivacionesInstalacion();
			if(GenericUtil.isCollectionEmpty(activacionesInstalacion)) {
				return new ResponseEntity<InputStreamResource>(HttpStatus.NO_CONTENT);
			}
			
			ByteArrayInputStream bis = PdfGenerator.activacionesInstalacionReportToPDF(activacionesInstalacion);
			
			HttpHeaders headers = new  HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=ReporteActivaciones.pdf");
			
			return ResponseEntity
					.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/insrtact")
	public ResponseEntity<ResponseBaseOperation> spInsertarActivacion(@Valid @RequestBody ActivacionRequest codigo) {
		
		try {
			
			ResponseBaseOperation response = instalacionFacade.spInsertarActivacion(codigo);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
