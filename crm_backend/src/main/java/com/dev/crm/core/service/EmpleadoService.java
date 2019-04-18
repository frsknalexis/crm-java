package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.model.entity.Empleado;

public interface EmpleadoService {
	
	List<Empleado> findAll();

	List<Empleado> getActiveListEmpleados();
	
	List<Empleado> spListarPersonaEmpleado(String creadoPor);
	
	List<Empleado> spListarEmpleadosIntExt();
	
	void spInsercionEmpleado(Empleado empleado);
	
	void spActualizarEmpleado(Empleado empleado);
	
	boolean isEmpleadoPresent(String documentoPersonaEmpleado);
	
	Empleado getByDocumentoPersonaEmpleado(String documentoPersonaEmpleado);
	
	void disabledEmpleado(String documentoPersonaEmpleado);
	
	void enabledEmpleado(String documentoPersonaEmpleado);
	
	Long totalRegistrosEmpleado();
	
}
