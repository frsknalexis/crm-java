package com.dev.crm.core.dao;

import java.util.List;

import com.dev.crm.core.base.dao.BaseDAOHibernate;
import com.dev.crm.core.model.entity.Persona;

public interface PersonaDAO extends BaseDAOHibernate {

	List<Persona> findPersonasByCreadoPor(String creadoPor);
	
	List<Persona> spListarPersonasNoClienteByCreadoPor(String creadoPor);
	
	List<Persona> spListaPersonaNoEmpleado(String creadoPor);
	
	Persona getByDocumentoPersona(String documentoPersona);
	
	boolean isPersonaPresent(String documentoPersona);
	
	void disabledPersona(Persona persona);
	
	void enabledPersona(Persona persona);
	
	Long totalRegistrosPersona();
	
	Long totalRegistrosPersonas();
}
