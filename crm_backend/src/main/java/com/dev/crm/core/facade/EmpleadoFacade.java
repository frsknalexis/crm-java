package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.EmpleadoDTO;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface EmpleadoFacade {
	
	List<EmpleadoDTO> findAll();

	List<EmpleadoDTO> getActiveListEmpleados();
	
	List<EmpleadoDTO> spListarPersonaEmpleado(String creadoPor);
	
	EmpleadoDTO getByDocumentoPersonaEmpleado(String documentoPersonaEmpleado);
	
	ResponseBaseOperation spInsercionEmpleado(EmpleadoDTO empleadoDTO);
	
	ResponseBaseOperation spActualizarEmpleado(EmpleadoDTO empleadoDTO);
	
	ResponseBaseOperation disabledEmpleado(String documentoPersonaEmpleado);
	
	ResponseBaseOperation enabledEmpleado(String documentoPersonaEmpleado);
	
	ResponseBaseOperation totalRegistrosEmpleado();
}
