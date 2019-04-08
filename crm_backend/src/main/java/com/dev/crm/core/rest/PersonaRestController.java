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

import com.dev.crm.core.dto.PersonaDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PersonaFacade;
import com.dev.crm.core.util.GenericUtil;

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
			
			String creadoPor = "vendedor";
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
}
