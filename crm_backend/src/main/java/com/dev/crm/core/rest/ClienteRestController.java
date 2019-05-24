package com.dev.crm.core.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteResultViewModel;
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
	
	@GetMapping("/cliente/{documentoPersonaCliente}")
	public ResponseEntity<ClienteDTO> getByDocumentoPersonaCliente(@PathVariable(value="documentoPersonaCliente") String documentoPersonaCliente) {
		
		ClienteDTO clienteDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersonaCliente)) && (documentoPersonaCliente.length() > 0)) {
				clienteDTO = clienteFacade.getByDocumentoPersonaCliente(documentoPersonaCliente);
				if(GenericUtil.isObjectEmpty(clienteDTO)) {
					return new ResponseEntity<ClienteDTO>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ClienteDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/clientes/listarClienteVendedor")
	public ResponseEntity<List<ClienteDTO>> spListarClienteVendedor() {
		
		try {
			
			String creadoPor = "mimoraleext";
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
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseBaseOperation> updateCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
		
		try {
			
			ResponseBaseOperation response = clienteFacade.updateCliente(clienteDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/cliente/disabled/{documentoPersonaCliente}")
	public ResponseEntity<ResponseBaseOperation> disabledCliente(@PathVariable(value="documentoPersonaCliente") String documentoPersonaCliente) {
		
		try {
			
			if(GenericUtil.isNotNull(documentoPersonaCliente) && !(GenericUtil.isEmpty(documentoPersonaCliente))) {
				ResponseBaseOperation response = clienteFacade.disabledCliente(documentoPersonaCliente);
				if(GenericUtil.isNotNull(response)) {
					return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ResponseBaseOperation>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/cliente/enabled/{documentoPersonaCliente}")
	public ResponseEntity<ResponseBaseOperation> enabledCliente(@PathVariable(value="documentoPersonaCliente") String documentoPersonaCliente) {
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersonaCliente)) && GenericUtil.isNotNull(documentoPersonaCliente)) {
				ResponseBaseOperation response = clienteFacade.enabledCliente(documentoPersonaCliente);
				if(GenericUtil.isNotNull(response)) {
					return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ResponseBaseOperation>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/totalRegistros")
	public ResponseEntity<ResponseBaseOperation> totalRegistrosCliente() {
		
		try {
			
			ResponseBaseOperation response = clienteFacade.totalRegistrosCliente();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/searchCliente")
	public ResponseEntity<ClienteResultViewModel> spBuscarPersonaClienteVendedor(@Valid @RequestBody ClienteFiltroRequest filtro) {
		
		try {
			
			if(GenericUtil.isNotNull(filtro)) {
				filtro.setCreadoPor("mimoraleext");
				ClienteResultViewModel cliente = clienteFacade.spBuscarPersonaClienteVendedor(filtro);
				if(GenericUtil.isNotNull(cliente)) {
					return new ResponseEntity<ClienteResultViewModel>(cliente, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ClienteResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ClienteResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/searchClientePago/{documentoPersona}")
	public ResponseEntity<ClientePagoResultViewModel> spBuscarClientePago(@PathVariable(value="documentoPersona") String documentoPersona) {
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersona)) {
				ClientePagoResultViewModel clientePago = clienteFacade.spBuscarClientePago(documentoPersona);
				if(GenericUtil.isNotNull(clientePago)) {
					return new ResponseEntity<ClientePagoResultViewModel>(clientePago, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<ClientePagoResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
		}
		catch(Exception e) {
			return new ResponseEntity<ClientePagoResultViewModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
