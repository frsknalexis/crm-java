package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.CorteInternetResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.CorteFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/corte")
public class CorteRestController {

	@Autowired
	@Qualifier("corteFacade")
	private CorteFacade corteFacade;
	
	@GetMapping("/corteInternet")
	public ResponseEntity<List<CorteInternetResultViewModel>> spListarCorteInternet() {
		
		try {
			
			List<CorteInternetResultViewModel> cortesInternet = corteFacade.spListarCorteInternet();
			if(GenericUtil.isCollectionEmpty(cortesInternet)) {
				return new ResponseEntity<List<CorteInternetResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<CorteInternetResultViewModel>>(cortesInternet, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<CorteInternetResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/actualizarServicio/{codigoServicioInternet}")
	public ResponseEntity<ResponseBaseOperation> spUpdateServicioInternet(@PathVariable(value="codigoServicioInternet") Integer codigoServicioInternet) {
		
		try {
			
			if(GenericUtil.isNotNull(codigoServicioInternet) && codigoServicioInternet.intValue() > 0) {
				ResponseBaseOperation response = corteFacade.spUpdateServicioInternet(codigoServicioInternet);
				return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
