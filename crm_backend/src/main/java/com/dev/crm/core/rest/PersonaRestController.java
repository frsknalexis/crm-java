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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.PersonaDTO;
import com.dev.crm.core.dto.PersonaRequest;
import com.dev.crm.core.dto.PersonaRequestE;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PersonaFacade;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.IpUtil;
import com.dev.crm.core.view.excel.ExcelGenerator;
import com.dev.crm.core.view.pdf.PdfGenerator;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaRestController {

	@Autowired
	@Qualifier("personaFacade")
	private PersonaFacade personaFacade;
	
	@GetMapping("/personas")
	public ResponseEntity<List<PersonaDTO>> findAll() {
		
		try {
			
			List<PersonaDTO> personasDTO = personaFacade.findAll();
			if(GenericUtil.isNotEmpty(personasDTO)) {
				return new ResponseEntity<List<PersonaDTO>>(personasDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<PersonaDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<PersonaDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/personas/activeList")
	public ResponseEntity<List<PersonaDTO>> getActiveList() {
		
		try {
			
			List<PersonaDTO> personasDTO = personaFacade.getActiveList();
			if(GenericUtil.isNotEmpty(personasDTO)) {
				return new ResponseEntity<List<PersonaDTO>>(personasDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<PersonaDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<PersonaDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/personas/listByCreadoPor")
	public ResponseEntity<List<PersonaDTO>> getListByCreadoPor() {
		
		try {
			
			String creadoPor = "mimoraleext";
			List<PersonaDTO> personasDTO = personaFacade.findPersonasByCreadoPor(creadoPor);
			if(GenericUtil.isNotEmpty(personasDTO)) {
				return new ResponseEntity<List<PersonaDTO>>(personasDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<PersonaDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<PersonaDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/personas/listaPersonasNoClientes")
	public ResponseEntity<List<PersonaDTO>> spListarPersonasNoClienteByCreadoPor() {
		
		try {
			
			String creadoPor = "mimoraleext";
			List<PersonaDTO> personasDTO = personaFacade.spListarPersonasNoClienteByCreadoPor(creadoPor);
			if(GenericUtil.isNotEmpty(personasDTO)) {
				return new ResponseEntity<List<PersonaDTO>>(personasDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<PersonaDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<PersonaDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/personas/listaPersonasNoEmpleados")
	public ResponseEntity<List<PersonaDTO>> spListaPersonaNoEmpleado() {
		
		try {
			
			String creadoPor = "lularosaint";
			List<PersonaDTO> personasDTO = personaFacade.spListaPersonaNoEmpleado(creadoPor);
			if(GenericUtil.isNotEmpty(personasDTO)) {
				return new ResponseEntity<List<PersonaDTO>>(personasDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<PersonaDTO>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<PersonaDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/persona/{documentoPersona}")
	public ResponseEntity<PersonaDTO> getByDocumentoPersona(@PathVariable(value="documentoPersona") String documentoPersona) {
		
		PersonaDTO personaDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersona)) && (documentoPersona.length() > 0)) {
				personaDTO = personaFacade.getByDocumentoPersona(documentoPersona);
				if(GenericUtil.isObjectEmpty(personaDTO)) {
					return new ResponseEntity<PersonaDTO>(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<PersonaDTO>(personaDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<PersonaDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseBaseOperation> savePersona(@Valid @RequestBody PersonaDTO personaDTO) {
		
		try {
			
			ResponseBaseOperation response = personaFacade.save(personaDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseBaseOperation> updatePersona(@Valid @RequestBody PersonaDTO personaDTO) {
		
		try {
			
			ResponseBaseOperation response = personaFacade.update(personaDTO);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/persona/disabled/{documentoPersona}")
	public ResponseEntity<ResponseBaseOperation> disabledPersona(@PathVariable(value="documentoPersona") String documentoPersona) {
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersona)) && (documentoPersona.length() > 0)) {
				ResponseBaseOperation response = personaFacade.disabledPersona(documentoPersona);
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
	
	@GetMapping("/persona/enabled/{documentoPersona}")
	public ResponseEntity<ResponseBaseOperation> enabledPersona(@PathVariable(value="documentoPersona") String documentoPersona) {
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersona)) && (documentoPersona.length() > 0)) {
				ResponseBaseOperation response = personaFacade.enabledPersona(documentoPersona);
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
	public ResponseEntity<ResponseBaseOperation> totalRegistrosPersona() {
		
		try {
			
			ResponseBaseOperation response = personaFacade.totalRegistrosPersona();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/totalidad")
	public ResponseEntity<ResponseBaseOperation> totalRegistrosPersonas() {
		
		try {
			
			ResponseBaseOperation response = personaFacade.totalRegistrosPersonas();
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/pdfReport", produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> personasReportToPDF() {
		
		try {
			
			List<PersonaDTO> personasDTO = personaFacade.findAll();
			ByteArrayInputStream bis = PdfGenerator.personasToPDF(personasDTO);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=personasReport.pdf");
			
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/excelReport")
	public ResponseEntity<InputStreamResource> personasReportToExcel() {
		
		try {
			
			List<PersonaDTO> personasDTO = personaFacade.findAll();
			ByteArrayInputStream bis = ExcelGenerator.personasToExcel(personasDTO);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=personas.xlsx");
			
			return ResponseEntity.ok()
					.headers(headers)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return  new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/insrpersona")
	public ResponseEntity<ResponseBaseOperation> spInsertarPersona(@Valid @RequestBody PersonaRequest valor) {
		
		try
		{
			String mensaje = "mimoraleext";
			valor.setCreadopor(mensaje);
			valor.setIpmaquina(IpUtil.getCurrentIPAddress());
			valor.setUsuariomaquina(IpUtil.getCurrentUserMachine());
			valor.setUsuariosistema(IpUtil.getCurrentUserSystem());
			ResponseBaseOperation response = personaFacade.spInsertarPersona(valor);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/editpersona")
	public ResponseEntity<ResponseBaseOperation> spEditarPersona(@Valid @RequestBody PersonaRequestE valor) {
		
		try
		{
			String mensaje = "mimoraleext";
			valor.setModificadopor(mensaje);
			ResponseBaseOperation response = personaFacade.spEditarPersona(valor);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
}
