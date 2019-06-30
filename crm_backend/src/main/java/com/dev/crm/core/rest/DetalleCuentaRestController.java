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

import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;
import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DatosMaterialesRequest;
import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.dto.ObservacionResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.DetalleCuentaFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/detalleCuenta")
public class DetalleCuentaRestController {

	@Autowired
	@Qualifier("detalleCuentaFacade")
	private DetalleCuentaFacade detalleCuentaFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@GetMapping("/cuentas")
	public ResponseEntity<List<CuentasPorInstalarResultViewModel>> listarCuentaPorInstalar() {
		
		try {
			
			List<CuentasPorInstalarResultViewModel> cuentasPorInstalar = detalleCuentaFacade.listarCuentaPorInstalar();
			if(GenericUtil.isCollectionEmpty(cuentasPorInstalar)) {
				return new ResponseEntity<List<CuentasPorInstalarResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<CuentasPorInstalarResultViewModel>>(cuentasPorInstalar, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CuentasPorInstalarResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/anular/{codigoDetalleCuenta}")
	public ResponseEntity<ResponseBaseOperation> spUpdateDetalleCuenta(@PathVariable(value = "codigoDetalleCuenta") Integer codigoDetalleCuenta) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				ResponseBaseOperation response = detalleCuentaFacade.spUpdateDetalleCuenta(codigoDetalleCuenta);
				return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/observacion/{codigoDetalleCuenta}")
	public ResponseEntity<ObservacionResultViewModel> spRecuperarObservacion(@PathVariable(value = "codigoDetalleCuenta") Integer codigoDetalleCuenta) {
		
		try {
			
			if(GenericUtil.isNotEmpty(codigoDetalleCuenta) && codigoDetalleCuenta.intValue() > 0) {
				ObservacionResultViewModel observacion = detalleCuentaFacade.spRecuperarObservacion(codigoDetalleCuenta);
				if(GenericUtil.isNotNull(observacion)) {
					return new ResponseEntity<ObservacionResultViewModel>(observacion, HttpStatus.OK);
				}
				else if(GenericUtil.isNull(observacion)) {
					return new ResponseEntity<ObservacionResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ObservacionResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@PostMapping("/saveCuentaInternet")
	public ResponseEntity<ResponseBaseOperation> spInsercionCuentaInternet(@Valid @RequestBody DetalleCuentaRequest request) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			request.setCodigoUsuario(usuario);
			ResponseBaseOperation response = detalleCuentaFacade.spInsercionCuentaInternet(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/envioDatos")
	public ResponseEntity<ResponseBaseOperation> spEnvioDatosInternetServicio(@Valid @RequestBody DatosInternetServicioRequest request) {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spEnvioDatosInternetServicio(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/datosMateriales")
	public ResponseEntity<ResponseBaseOperation> spEnvioDatosMaterial(@Valid @RequestBody DatosMaterialesRequest request) {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spEnvioDatosMaterial(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	@PostMapping("/saveCuentaCable")
	public ResponseEntity<ResponseBaseOperation> spInsercionCuentaCable(@Valid @RequestBody DetalleCuentaDTO detalleCuentaDTO) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			detalleCuentaDTO.setCodigoexterno(usuario);
			ResponseBaseOperation response = detalleCuentaFacade.spInsercionCuentaCable(detalleCuentaDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	*/
	@GetMapping("/contadorPendientesCable")
	public ResponseEntity<ResponseBaseOperation> spContadorPendientesCable() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spContadorPendientesCable();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/contadorPendientesInternet")
	public ResponseEntity<ResponseBaseOperation> spContadorPendientesInternet() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spContadorPendientesInternet();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reprogramacionInstalacionCable")
	public ResponseEntity<ResponseBaseOperation> spReprogramarInstalacionCable() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spReprogramarInstalacionCable();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/reprogramacionInstalacionInternet")
	public ResponseEntity<ResponseBaseOperation> spReprogramarInstalacionInternet() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spReprogramarInstalacionInternet();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/revalidandoInstalacionCable")
	public ResponseEntity<ResponseBaseOperation> spRevalidandoFechaCable() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spRevalidandoFechaCable();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/revalidandoInstalacionInternet")
	public ResponseEntity<ResponseBaseOperation> spRevalidandoFechaInternet() {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spRevalidandoFechaInternet();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
