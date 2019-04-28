package com.dev.crm.core.rest;

import java.util.List;

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

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PagoFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/pago")
public class PagoRestController {

	@Autowired
	@Qualifier("pagoFacade")
	private PagoFacade pagoFacade;
	
	@GetMapping("/clientes/clientesPago")
	public ResponseEntity<List<ClientePagoResultViewModel>> spListarClientesPago() {
		
		try {
			
			String usuario = "cajero";
			List<ClientePagoResultViewModel> clientesPagos = pagoFacade.spListarClientesPago(usuario);
			if(GenericUtil.isNotEmpty(clientesPagos)) {
				return new ResponseEntity<List<ClientePagoResultViewModel>>(clientesPagos, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ClientePagoResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClientePagoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/realizarPago")
	public ResponseEntity<ResponseBaseOperation> spPagoServicio(@Valid @RequestBody PagoRequest pagoRequest) {
		
		try {
			
			ResponseBaseOperation response = pagoFacade.spPagoServicio(pagoRequest);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
