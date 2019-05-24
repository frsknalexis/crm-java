package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.PersonaDTO;
import com.dev.crm.core.dto.PersonaRequest;
import com.dev.crm.core.dto.PersonaRequestE;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PersonaFacade;
import com.dev.crm.core.model.entity.Persona;
import com.dev.crm.core.service.PersonaService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Component("personaFacade")
public class PersonaFacadeImpl implements PersonaFacade {

	@Autowired
	@Qualifier("personaService")
	private PersonaService personaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<PersonaDTO> findAll() {
		
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		
		try {
			
			List<Persona> personas = personaService.findAll();
			personas.stream().forEach(p -> {
				personasDTO.add(modelMapper.map(p, PersonaDTO.class));
			});
			return personasDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PersonaDTO> getActiveList() {
		
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		
		try {
			
			List<Persona> personas = personaService.findAll();
			for(Persona p : personas) {
				PersonaDTO personaDTO = modelMapper.map(p, PersonaDTO.class);
				personasDTO.add(personaDTO);
			}
			return personasDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PersonaDTO> findPersonasByCreadoPor(String creadoPor) {
		
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		
		try {
			
			List<Persona> personas = personaService.findPersonasByCreadoPor(creadoPor);
			personas.stream().forEach(p -> {
				personasDTO.add(modelMapper.map(p, PersonaDTO.class));
			});
			return personasDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PersonaDTO> spListarPersonasNoClienteByCreadoPor(String creadoPor) {
		
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		
		try {
			
			List<Persona> personas = personaService.spListarPersonasNoClienteByCreadoPor(creadoPor);
			personas.stream().forEach(p -> {
				personasDTO.add(modelMapper.map(p, PersonaDTO.class));
			});
			return personasDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PersonaDTO> spListaPersonaNoEmpleado(String creadoPor) {
		
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		
		try {
			
			List<Persona> personas = personaService.spListaPersonaNoEmpleado(creadoPor);
			personas.stream().forEach(p -> {
				personasDTO.add(modelMapper.map(p, PersonaDTO.class));
			});
			return personasDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PersonaDTO getByDocumentoPersona(String documentoPersona) {
		
		PersonaDTO personaDTO = null;
		
		try {
			
			if(!(GenericUtil.isEmpty(documentoPersona)) && (documentoPersona.length() > 0)) {
				Persona persona = personaService.getByDocumentoPersona(documentoPersona);
				if(GenericUtil.isNotNull(persona)) {
					personaDTO = modelMapper.map(persona, PersonaDTO.class);
				}
			}
			return personaDTO;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation save(PersonaDTO personaDTO) {
		
		try {
			
			Persona persona = modelMapper.map(personaDTO, Persona.class);
			if(GenericUtil.isNotNull(persona)) {
				
				if(personaService.isPersonaPresent(personaDTO.getDocumentoPersona())) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, Constantes.MESSAGE_ERROR, personaDTO);
				}
				personaService.save(persona);
				return new ResponseBaseOperation(Constantes.CREATED_STATUS, Constantes.MESSAGE_CREATED, personaDTO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResponseBaseOperation update(PersonaDTO personaDTO) {
		
		try {
			
			Persona persona = modelMapper.map(personaDTO, Persona.class);
			if(GenericUtil.isNotNull(persona)) {
				
				if(personaService.isPersonaPresent(personaDTO.getDocumentoPersona())) {
					personaService.update(persona);
					return new ResponseBaseOperation(Constantes.UPDATED_STATUS, Constantes.MESSAGE_UPDATED, personaDTO);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

	@Override
	public ResponseBaseOperation disabledPersona(String documentoPersona) {
		
		try {
			
			PersonaDTO personaDTO = null;
			if(!(GenericUtil.isEmpty(documentoPersona)) && (documentoPersona.length() > 0)) {
				personaDTO = getByDocumentoPersona(documentoPersona);
			}
			if(GenericUtil.isNotNull(personaDTO)) {
				if(personaDTO.getHabilitado().equals(Constantes.HABILITADO)) {
					personaService.disabledPersona(documentoPersona);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_DISABLED, personaDTO);
				}
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation enabledPersona(String documentoPersona) {
		
		try {
			
			PersonaDTO personaDTO = null;
			if(!(GenericUtil.isEmpty(documentoPersona)) && (documentoPersona.length() > 0)) {
				personaDTO = getByDocumentoPersona(documentoPersona);
			}
			if(GenericUtil.isNotNull(personaDTO)) {
				if(personaDTO.getHabilitado().equals(Constantes.INHABILITADO)) {
					personaService.enabledPersona(documentoPersona);
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_SUCCESS_ENABLED, personaDTO);
				}
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation totalRegistrosPersona() {
		
		try {
			
			Long totalRegistrosPersona = personaService.obtenerTotalRegistrosPersona();
			if(totalRegistrosPersona == 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ' ' + totalRegistrosPersona, totalRegistrosPersona);
			}
			else if(totalRegistrosPersona > 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS + ' ' + totalRegistrosPersona, totalRegistrosPersona);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ResponseBaseOperation totalRegistrosPersonas() {
		
		try {
			
			Long totalRegistrosPersona = personaService.obtenerTotalRegistrosPersona();
			if(totalRegistrosPersona == 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS_CON + totalRegistrosPersona, totalRegistrosPersona);
			}
			else if(totalRegistrosPersona > 0) {
				return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, Constantes.MESSAGE_TOTAL_REGISTROS_CON + totalRegistrosPersona, totalRegistrosPersona);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spInsertarPersona(PersonaRequest valor) {

		try {
			
			if(GenericUtil.isNotNull(valor)) {
				String result = personaService.spInsertarPersona(valor);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, valor);
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spEditarPersona(PersonaRequestE valor) {

		try {
			
			if(GenericUtil.isNotNull(valor)) {
				String result = personaService.spEditarPersona(valor);
				if(StringUtil.hasText(result)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, valor);
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
