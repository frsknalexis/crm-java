package com.dev.crm.core.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.CambioDireccionRequest;
import com.dev.crm.core.dto.ClienteDTO;
import com.dev.crm.core.dto.ClienteFiltroRequest;
import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ClienteResultViewModel;
import com.dev.crm.core.dto.ClienteVendedorResultViewModel;
import com.dev.crm.core.dto.DatosClienteResultViewModel;
import com.dev.crm.core.dto.PdfClienteResultViewModel;
import com.dev.crm.core.dto.PersonaClienteRequest;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.ClienteFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.view.excel.ExcelGenerator;
import com.dev.crm.core.view.pdf.PdfGenerator;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteRestController {

	@Autowired
	@Qualifier("clienteFacade")
	private ClienteFacade clienteFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
		
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
	
	@GetMapping("/cliente/recuperarDatosCliente/{documentoPersonaCliente}")
	public ResponseEntity<DatosClienteResultViewModel> recuperarDatosCliente(@PathVariable(value = "documentoPersonaCliente") String documentoPersonaCliente) {
		
		DatosClienteResultViewModel clienteDatos = null;
		
		try {
			
			if(GenericUtil.isNotNull(documentoPersonaCliente) && (documentoPersonaCliente.length() > 0)) {
				clienteDatos = clienteFacade.recuperarDatosCliente(documentoPersonaCliente);
				if(GenericUtil.isObjectEmpty(clienteDatos)) {
					return new ResponseEntity<DatosClienteResultViewModel>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<DatosClienteResultViewModel>(clienteDatos, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<DatosClienteResultViewModel>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/clientes/listarClientesPorVendedor")
	public ResponseEntity<List<ClienteVendedorResultViewModel>> listarClientesPorVendedor() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			List<ClienteVendedorResultViewModel> clientes = clienteFacade.listarClientesPorVendedor(usuario);
			if(GenericUtil.isCollectionEmpty(clientes)) {
				return new ResponseEntity<List<ClienteVendedorResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<ClienteVendedorResultViewModel>>(clientes, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteVendedorResultViewModel>>(HttpStatus.BAD_REQUEST);
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
	
	@PutMapping("/updatePersonaCliente")
	public ResponseEntity<ResponseBaseOperation> updatePersonaCliente(@Valid @RequestBody PersonaClienteRequest request) {
		
		try {
			
			ResponseBaseOperation response = clienteFacade.updatePersonaCliente(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/cliente/cambiarDomicilio")
	public ResponseEntity<ResponseBaseOperation> spModificarDomicilio(@Valid @RequestBody CambioDireccionRequest request) {
		
		try {
			
			ResponseBaseOperation response = clienteFacade.spModificarDomicilio(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
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
				
				User usuarioLogueado = userDetail.findLoggedInUser();
				String usuario = usuarioLogueado.getUsername();
				filtro.setCreadoPor(usuario);
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
	
	@GetMapping(value = "/pdfClientes", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> clientesReportToPDF() throws IOException {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			
			List<PdfClienteResultViewModel> pdfClientes = clienteFacade.spListarPdfCliente(usuario);
			
			ByteArrayInputStream bis = PdfGenerator.clientesReportToPDF(pdfClientes);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=clientesReport.pdf");
			
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/excelClientes")
	public ResponseEntity<InputStreamResource> clientesReportToExcel() throws IOException {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String usuario = usuarioLogueado.getUsername();
			
			List<PdfClienteResultViewModel> pdfClientes = clienteFacade.spListarPdfCliente(usuario);
			
			ByteArrayInputStream bis = ExcelGenerator.clientesToExcel(pdfClientes);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=clientes.xlsx");
			
			return ResponseEntity.ok()
					.headers(headers)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
}
