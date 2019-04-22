package com.dev.crm.core.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.DetalleCuentaDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.DetalleCuentaFacade;

@RestController
@RequestMapping("/api/v1/detalleCuenta")
public class DetalleCuentaRestController {

	@Autowired
	@Qualifier("detalleCuentaFacade")
	private DetalleCuentaFacade detalleCuentaFacade;
	
	@PostMapping("/saveCuentaInternet")
	public ResponseEntity<ResponseBaseOperation> spInsercionCuentaInternet(@Valid @RequestBody DetalleCuentaDTO detalleCuentaDTO) {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spInsercionCuentaInternet(detalleCuentaDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveCuentaCable")
	public ResponseEntity<ResponseBaseOperation> spInsercionCuentaCable(@Valid @RequestBody DetalleCuentaDTO detalleCuentaDTO) {
		
		try {
			
			ResponseBaseOperation response = detalleCuentaFacade.spInsercionCuentaCable(detalleCuentaDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
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
}
