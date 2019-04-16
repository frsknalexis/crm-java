package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.model.entity.Persona;

public interface PersonaService {

	List<Persona> findAll();
	
	List<Persona> getActiveList();
	
	List<Persona> findPersonasByCreadoPor(String creadoPor);
	
	List<Persona> spListarPersonasNoClienteByCreadoPor(String creadoPor);
	
	List<Persona> spListaPersonaNoEmpleado(String creadoPor);
	
	Persona getByDocumentoPersona(String documentoPersona);
	
	void disabledPersona(String documentoPersona);
	
	void enabledPersona(String documentoPersona);
	
	void save(Persona persona);
	
	void update(Persona persona);
	
	boolean isPersonaPresent(String documentoPersona);
	
	Long obtenerTotalRegistrosPersona();
}
