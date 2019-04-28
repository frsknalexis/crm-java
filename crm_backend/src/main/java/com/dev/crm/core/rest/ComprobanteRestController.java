package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ComprobanteResultViewModel;
import com.dev.crm.core.facade.ComprobanteFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/comprobante")
public class ComprobanteRestController {

	@Autowired
	@Qualifier("comprobanteFacade")
	private ComprobanteFacade comprobanteFacade;
	
	@GetMapping("/comprobantes")
	public ResponseEntity<List<ComprobanteResultViewModel>> spListarComprobante() {
		
		try {
			
			List<ComprobanteResultViewModel> comprobantesResultViewModel = comprobanteFacade.spListarComprobante();
			if(!GenericUtil.isCollectionEmpty(comprobantesResultViewModel)) {
				return new ResponseEntity<List<ComprobanteResultViewModel>>(comprobantesResultViewModel, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ComprobanteResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ComprobanteResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
}
