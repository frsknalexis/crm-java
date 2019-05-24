package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.PersonaDTO;
import com.dev.crm.core.dto.PersonaRequest;
import com.dev.crm.core.dto.PersonaRequestE;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface PersonaFacade {

	List<PersonaDTO> findAll();
	
	List<PersonaDTO> getActiveList();
	
	List<PersonaDTO> findPersonasByCreadoPor(String creadoPor);
	
	List<PersonaDTO> spListarPersonasNoClienteByCreadoPor(String creadoPor);
	
	List<PersonaDTO> spListaPersonaNoEmpleado(String creadoPor);
	
	PersonaDTO getByDocumentoPersona(String documentoPersona);
	
	ResponseBaseOperation save(PersonaDTO personaDTO);
	
	ResponseBaseOperation update(PersonaDTO personaDTO);
	
	ResponseBaseOperation disabledPersona(String documentoPersona);
	
	ResponseBaseOperation enabledPersona(String documentoPersona);
	
	ResponseBaseOperation totalRegistrosPersona();
	
	ResponseBaseOperation totalRegistrosPersonas();
	
	ResponseBaseOperation spInsertarPersona (PersonaRequest valor); 
	
	ResponseBaseOperation spEditarPersona (PersonaRequestE valor);
}
