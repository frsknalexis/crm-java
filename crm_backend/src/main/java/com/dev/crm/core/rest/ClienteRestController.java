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

import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.ClienteFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteRestController {

	@Autowired
	@Qualifier("clienteFacade")
	private ClienteFacade clienteFacade;
		
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> findAll() {
		
		try {
			
			List<ClienteDTO> clientesDTO = clienteFacade.findAll();
			if(GenericUtil.isNotEmpty(clientesDTO)) {
				return new ResponseEntity<List<ClienteDTO>>(clientesDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ClienteDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/clientes/activeList")
	public ResponseEntity<List<ClienteDTO>> getActiveList() {
		
		try {
			
			List<ClienteDTO> clientesDTO = clienteFacade.getActiveListClientes();
			if(GenericUtil.isNotEmpty(clientesDTO)) {
				return new ResponseEntity<List<ClienteDTO>>(clientesDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ClienteDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/clientes/listarClienteVendedor")
	public ResponseEntity<List<ClienteDTO>> spListarClienteVendedor() {
		
		try {
			
			String creadoPor = "vendedor";
			List<ClienteDTO> clientesDTO = clienteFacade.spListarClienteVendedor(creadoPor);
			if(GenericUtil.isNotEmpty(clientesDTO)) {
				return new ResponseEntity<List<ClienteDTO>>(clientesDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ClienteDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseBaseOperation> spInsertarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
		
		try {
			
			ResponseBaseOperation response = clienteFacade.spInsertarCliente(clienteDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
